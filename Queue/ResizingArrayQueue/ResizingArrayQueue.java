package resizingArrayQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ResizingArrayQueue<Item> implements Iterable<Item> {
	private Item[] q;	//保存元素
	private int n;		//元素个数
	private int first;	//队列第一个元素的索引
	private int last;	//下一个可用的位置的索引
	
	public ResizingArrayQueue() {
		// TODO Auto-generated constructor stub
		q = (Item[])new Object[2];
		first = 0;
		last = 0;
		n = 0;
	}
	
	public boolean isEmpty() {
		return n == 0;
	}
	
	public int size() {
		return n;
	}
	
	/**
	 * 重新调整大小
	 * @param capicity 要调整的大小
	 */
	public void resize(int capicity) {
		assert capicity >= n;	// 容量断言
		Item[] temp = (Item[])new Object[capicity];
		for (int i=0; i<n; i++) {
			temp[i] = q[(first + i) % (q.length)] ;
		}
		q = temp;
		first = 0;
		last = n;
	}
	
	
	/**
	 * 入队
	 * @param item 待添加的元素
	 */
	public void enqueue(Item item) {
		if(n == q.length) resize(2 * q.length); 
		q[last] = item;
		last++;
		if (last == q.length) last = 0;  // 环
		n++;
	}
	
	/**
	 * 出队，返回最早添加的元素
	 * @return
	 * @throws java.util.NoSuchElementException if this queue is empty
	 */
	public Item dequeue() {
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
		Item item = q[first];
		q[first] = null;	//深入理解java中的null
		first++;
		if (first == q.length) first = 0;
		n--;
		if (n > 0 && n == q.length / 4) resize(q.length / 2);
		return item;
	}
	
	
	/**
	 * 获取最早添加的元素
	 * @return	最早添加的元素
	 */
	public Item peek() {
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
		return q[first];
	}
	
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ArrayIterator();
	}
	
	/**
	 * 一个迭代器，没有实现remove,因为其是可选的
	 * @author sunhy
	 *
	 */
	private class ArrayIterator implements Iterator<Item> {
		int i = 0;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i < n;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			if (!hasNext()) throw new NoSuchElementException();
			Item item = q[(first+i) % q.length];
			i++;
			return item;
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
            else if (!queue.isEmpty()) StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println("(" + queue.size() + " left on queue)");
    }
    
}


