package queues;
import exceptionclasses.EmptyQueueException;

/**
 * <p>Title: The LinkedQueue Class</p>
 *
 * <p>Description: Defines the properties and behaviors of a linked queue.</p>
 *
 * @author Christopher Huayanay, Mike Olewnicki
 */
 
public class LinkedQueue<E> implements QueueADT<E>
{
	private Node<E> front, rear; //references to the first and last nodes

	/**
	 * default constructor - creates an empty queue
	 */
	public LinkedQueue()
	{
		front = rear = null;
	}
	
	/**
	 * enqueue method - adds the specified item to the rear of the queue
	 * @param newItem a reference to the item to be added to the queue
	 */
	public void enqueue (E newItem)
	{
		if (front == null && rear == null) {
			front = new Node<E>(newItem);
			rear = front;
		}
		else {
			rear.setNext(new Node<E>(newItem));
			rear = rear.getNext();
		}
	}

	/**
	 * dequeue method - removes the item at the front of the queue
	 * @return a reference to the item removed from the front of the queue
	 * @throws an EmptyQueueException if the queue is empty
	 */
	public E dequeue() throws EmptyQueueException
	{
		
		if (this.isEmpty()) { 
				throw new EmptyQueueException("LinkedQueue collection is empty");
		}
		else if (front.equals(rear)) {
			E result = front.getItem();
			front = rear = null;
			return result;
		}
		else {
			E result = front.getItem();
			front = front.getNext();
			return result;
		}
	}

	/**
	 * front method - returns a reference to the item at the front of the queue
	 * without removing it from the queue
	 * @return a reference to the item at the front of the queue
	 * @throws an EmptyQueueException if the queue is empty  
	 */
	public E front() throws EmptyQueueException
	{
		if (this.isEmpty()) {
			throw new EmptyQueueException("When calling front: LinkedQueue collection is empty");
		}
		return front.getItem();
	}
	/**
	 * removeLast method - returns a reference to the item at the rear of the queue
	 * while removing it from the queue
	 * @return a reference to the item that was the rear of the queue
	 * @throws an EmptyQueueException if the queue is empty  
	 */
	public E removeLast() throws EmptyQueueException
	{
		if(this.isEmpty()){
			throw new EmptyQueueException("On removeLast: LinkedQueue collection is empty");
		}
		else if (front.equals(rear)) {
			E result = rear.getItem();
			front = rear = null;
			return result;
		}
		else {
			E result = rear.getItem();
			Node<E> currNode = front;
			while (!(currNode.getNext().equals(rear))) {
			currNode = currNode.getNext();
			}
			rear = currNode;
			rear.setNext(null);
			return result;
		}
	}
	/**
	 * isEmpty method - determines whether or not the queue is empty
	 * @return true if the queue is empty; false if the queue is not empty
	 */
	public boolean isEmpty()
	{
		if (front == null && rear == null)
			return true;
		else
			return false;
	}
	/**
	 * search method - returns a 1-dimensional position index for a node that contains an Object that equals sItem
	 * @return the 1-dimensional position index for a node that contains an Object that equals sItem in the queue
	 */
	public int search(E sItem) {
		int count = 0;
		Node<E> currNode = front;
		while (currNode != null) {
			count += 1;
			if (currNode.getItem().equals(sItem))
				return count;
			currNode = currNode.getNext();		
		}
		return -1;
	}

	/**
	 * size method - returns a count of the number of items in the queue
	 * @return the number of items in the queue
	 */
	public int size()
	{
			Node<E> currNode = front;
			int count = 0;
			while (currNode != null) {
				count += 1;
				currNode = currNode.getNext();
			}
			return count;
	}
	
	/**
	 * toString method - returns a String representing the state of the queue
	 * @return a string containing all items in the queue
	 */
	public String toString()
	{
		String s = new String("");
		Node<E> currNode = front;
		while (currNode != null) {
			s = s + currNode.getItem().toString() + "\n";
			currNode = currNode.getNext();
		}
		return s;
	}
}