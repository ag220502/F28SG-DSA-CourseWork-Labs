package sort.parallel;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import sort.sequential.SequentialMergeSort;
import sort.sequential.SortingCommon;
import utils.Benchmark;

/*
 * Merge Sort results with thresholding
 * ~~~~~~~~~~~~~~~~~~
 *
 * After parallelisation:
 * - 1 thread
 *   - no threshold:   runtime=3718ms	1 steals
 *   - threshold=128:  runtime=3659ms	1 steals
 *   - threshold=512:  runtime=3641ms	1 steals
 *   - threshold=2048: runtime=3575ms	1 steals
 *   - threshold=8192: runtime=3739ms	1 steals
 *
 * - 2 threads
 *   - no threshold:   runtime=2717ms	2 steals
 *   - threshold=128:  runtime=2708ms	2 steals
 *   - threshold=512:  runtime=2703ms	2 steals
 *   - threshold=2048: runtime=2722ms	2 steals
 *   - threshold=8192: runtime=2795ms	2 steals
 *
 * - 4 threads
 *   - no threshold:   runtime=2721ms	6 steals
 *   - threshold=128:  runtime=2572ms	4 steals
 *   - threshold=512:  runtime=2603ms	5 steals
 *   - threshold=2048: runtime=2567ms	4 steals
 *   - threshold=8192: runtime=2624ms	5 steals
 *   
 * - 8 threads
 *   - no threshold:   runtime=2594ms	9 steals
 *   - threshold=128:  runtime=2491ms	11 steals
 *   - threshold=512:  runtime=2509ms	14 steals
 *   - threshold=2048: runtime=2590ms	16 steals
 *   - threshold=8192: runtime=2549ms	14 steals
	
 *   <insert more if you have more than 2 CPU cores>
 *
 * Parameters of the shortest runtime:
 * - runtime: 2491ms
 * - how many threads: 8
 * - threshold value: 128
 * 
 * Best parallel speedup: 1.49
 * 
 * Parallelism efficiency: 18.625
*/

public class ParallelMergeSortThreshold extends RecursiveTask<LinkedList<Integer>> {
	LinkedList<Integer> arr;
	int threshold;

	public ParallelMergeSortThreshold(LinkedList<Integer> arr, int threshold) {
		this.arr = arr;
		this.threshold = threshold;
	}

	@Override
	protected LinkedList<Integer> compute() {
		int length = arr.size();

		// Q2: rewrite the base case condition and body of this if statement,
		// so that you run:
		//
		// sequential merge sort for small inputs (the "base case")
		// by using SequentialMergeSort.mergeSort(..) 
		//
		// or run
		//
		// parallel merge sort in parallel for large inputs (the "recursive" case)
		if (length < 2) {
//			if the length is less than 2 then using sequential merge sort 
			return SequentialMergeSort.mergeSort(arr);
		}

		else { // parallel case

			/* compute the size of the two sub arrays */
			int halfSize = length / 2;

			/* declare these as `left` and `right` arrays */
			LinkedList<Integer> left = new LinkedList<Integer>();
			LinkedList<Integer> right = new LinkedList<Integer>();

			/* populate the left array with values */
			Iterator<Integer> it = arr.iterator();
			int index = 0;
			while (index < halfSize) {
				left.add(it.next());
				index++;
			}

			/* populate the right array with values */
			index = 0;
			while (index < length - halfSize) {
				right.add(it.next());
				index++;
			}
			
			// TODO replace this to use the parallel fork/join approach but this
			// time using this ParallelMergeSoftThreshold class to create the two tasks,
			// rather than the ParallelMergeSort class that you used in Q1B. Remember
			// that this time you also need to pass the threshold as the 2nd argument
			// to the constructor.
			//Creating objects for sorting left and right lists  
			ParallelMergeSortThreshold newLeft = new ParallelMergeSortThreshold(left,this.threshold);
			ParallelMergeSortThreshold newRight = new ParallelMergeSortThreshold(right,this.threshold);
			//Forking the left list so that it can work parallel to right list		
			newLeft.fork();
			//Sorting the right list using compute method in current thread
			LinkedList<Integer> resultRight = newRight.compute();
			//Collecting the result of the sorted left list
			LinkedList<Integer> resultLeft = newLeft.join();
//			
//			LinkedList<Integer> resultLeft = SequentialMergeSort.mergeSort(left);
//			LinkedList<Integer> resultRight = SequentialMergeSort.mergeSort(right);

			/* merge the sorted sub arrays */
			return SequentialMergeSort.merge(resultLeft, resultRight);
		}
	}

	/**
	 * Threshold based parallel merge sort
	 * 
	 * @param numbers     the input list
	 * @param threshold   when to switch from parallel divide-and-conquer to
	 *                    sequential divide-and-conquer
	 * @param parallelism how many threads to use in the ForkJoin workpool
	 * @return the sorted list
	 */
	public static LinkedList<Integer> parallelMergeSortThreshold(LinkedList<Integer> numbers, int threshold,
			int parallelism) {
		ForkJoinPool pool = new ForkJoinPool(parallelism);
		ParallelMergeSortThreshold mergeSortTask = new ParallelMergeSortThreshold(numbers, threshold);
		LinkedList<Integer> result = pool.invoke(mergeSortTask);
		return result;
	}

	/**
	 * Benchmarks threshold based parallel merge sort
	 */
	public static void main(String[] args) {
		/* generates a random list */
		LinkedList<Integer> numbers = SortingCommon.randomList(50000);

		/* gets the number of cores in this computer's CPU */
		int cpuCores = Runtime.getRuntime().availableProcessors();

		/*
		 * 1. prints the runtime for the parallel merge sort from Q1B.
		 * 
		 * 2. prints the runtime for the threshold based parallel merge sort for the
		 * implementation in Q2.
		 */
		for (int threads = 1; threads <= cpuCores; threads *= 2) {
			System.out.print("mergeSort\t no threshold\t\t");
			Benchmark.parallel(new ParallelMergeSort(numbers), threads);
			for (int threshold = 128; threshold <= 8192; threshold *= 4) {
				System.out.print("mergeSort\t threshold=" + threshold + "\t\t");
				Benchmark.parallel(new ParallelMergeSortThreshold(numbers, threshold), threads);
			}
		}
	}

}