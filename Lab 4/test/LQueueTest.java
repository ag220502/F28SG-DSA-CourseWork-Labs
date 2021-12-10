import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LQueueTest {

	LQueue q;
	@Before
	public void setup()
	{
		q = new LQueue();
	}
	
	/*
	 * 2: complete the following test methods as specified. 
	 */
	
	@Test
	public void testIsEmpty() {
		// test that q.isEmpty returns true
		assertTrue(q.isEmpty());
	}
	
	@Test
	public void testIsEmptyFalse() {
		// add an element to the queue "q"
		q.enqueue("A");
		// then test that q is not an empty queue.
		assertFalse(q.isEmpty());
	}

	@Test
	public void testSizeEmpty() {
		// test the size of an empty queue is 0
		assertEquals(0,q.size());
	}
	
	@Test
	public void testSizeNonEmpty() {
		// add an element(s) to the queue
		q.enqueue("A");
		q.enqueue("B");
		q.enqueue("C");
		
		// then test the size of the queue
		assertEquals(3,q.size());
	}

	@Test
	public void testEnqueue() {
		// enqueue an element(s) to the queue
		q.enqueue("A");
		assertEquals("A",q.front());
		q.enqueue("B");
		q.enqueue("C");
		// then test that the correct element is at the front
		assertEquals("A",q.front());
	}
	
	@Test
	public void testDequeue() {
		// enqueue multiple elements to the queue
		q.enqueue("A");
		q.enqueue("B");
		q.enqueue("C");
		// then check that they are returned in the
		// correct order with dequeue.
		assertEquals("A",q.dequeue());
		assertEquals("B",q.dequeue());
		assertEquals("C",q.dequeue());
		
	}
	
	@Test(expected = QueueException.class)  
	public void testEmptyDequeue() {  
		q.dequeue();
	}
	
	@Test(expected = QueueException.class)  
	public void testEmptyFront() {
		q.front();
	}
}
