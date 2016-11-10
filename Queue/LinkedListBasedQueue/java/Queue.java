package linkListBasedQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import resizingArrayQueue.ResizingArrayQueue;

public class Queue<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	private int N;
	
	public Queue() {
		first = last = null;
		N = 0;
	}
	
	private class Node {
		Item item;
		Node next;
		
		public Node(Item newItem) {
			item = newItem;
			next = null;
		}
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void enqueue(Item item) {
		Node newNode = new Node(item);
		if (isEmpty()) {
			first = newNode;
		} else {
			last.next = newNode;
		}
		last = newNode;
		N++;
	}
	
	public Item dequeue() {
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
		Node temp = first;
		first = first.next;
		N--;
		return temp.item;
	}
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<Item> {
		private Node tempNode = first;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return tempNode.next == null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			tempNode = tempNode.next;
			return tempNode.item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
		
	}

    public static void main(String[] args) {
        ResizingArrayQueue<String> queue = new ResizingArrayQueue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) queue.enqueue(item);
            else if (!queue.isEmpty()) StdOut.print("dequeue: " + queue.dequeue() + " ");
        }
        
        for (Iterator<String> i = queue.iterator(); i.hasNext(); ) {
        		
        	StdOut.println("(" + i.next() + " )");
        }
       
        StdOut.println("(" + queue.size() + " left on queue)");
    }

}
