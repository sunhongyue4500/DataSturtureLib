package priorityQueue;


/**
 * 基于最大堆的优先队列
 * @author sunhy
 *
 * @param <Key>
 */
public class MaxPQ<Key extends Comparable<Key>>{
	//基于堆的完全二叉树	
	private Key[] pq;
	//元素个数	
	private int N = 0;
	
	/** 
	 * 创建一个初始容量为的优先队列
	 * @param max 初始容量
	 */
	@SuppressWarnings("unchecked")
	public MaxPQ(int max) {
		this.pq = (Key[])new Comparable[max+1];
	}
	
	/**
	 * 用a中的元素创建一个优先队列
	 * @param a
	 */
	public MaxPQ(Key[] a) {
		this(a.length);
		for (Key key : a) {
			insert(key);
		}
	}
	
	/**
	 * 向优先队列中插入一个元素
	 * @param v
	 */
	void insert(Key v) {
		pq[++N] = v;
		swim(N);
	}
	
	/**
	 * 返回最大元素
	 * @return
	 */
	Key max() {
		return pq[1];
	}
	
	/**
	 * 删除并返回最大元素
	 * @return
	 */
	Key delMax() {
		Key key = pq[1];
		exch(1, N);
		pq[N--] = null;
		sink(1);
		return key;
	}
	
	/**
	 * 返回队列是否为空
	 * @return
	 */
	boolean isEmpty() {
		return N == 0;
	}
	
	/**
	 * 返回优先队列中的元素的个数
	 * @return
	 */
	int size() {
		return N;
	}
	
	/** 比较两个位置的元素大小
	 * @param i
	 * @param j
	 * @return
	 */
	private boolean less(int i,int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}
	
	/**
	 * 交换两个位置的元素
	 * @param i
	 * @param j
	 */
	private void exch(int i, int j) {
		Key tempKey =  pq[i];
		pq[i] = pq[j];
		pq[j] = tempKey;
	}
	
	/**
	 * 上浮
	 * @param k
	 */
	private void swim(int k) {
		while(k > 1 && !less(k, k / 2)) {
			exch(k, k/2);
			k = k / 2;
		}
	}
	
	/**
	 * 下沉
	 * @param k
	 */
	private void sink(int k) {
		while(2*k <= N) {
			int j = 2*k;
			if (j+1 <= N && less(j, j+1)) j++;
			if (!less(k, j)) break;
			exch(k, j);
			k = j;
		}
	}
}
