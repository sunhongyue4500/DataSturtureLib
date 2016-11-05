package priorityQueue;

/**
 * 用堆来维护优先队列的索引
 * @author sunhy
 *
 * @param <Key>
 */
public class IndexMinPQ<Key extends Comparable<Key>> {	
	private int[] pq;	// 索引二叉堆，由1开始
	private int[] qp;	// 逆序 qp[pq[i]] = pq[qp[i]] = i;
	private Key[]keys;
	//元素个数	
	private int N = 0;
	
	/**
	 * 构造元素个数为maxN的索引优先队列	
	 * @param maxN
	 */
	public IndexMinPQ(int maxN) {
		keys = (Key[])new Comparable[maxN+1];
		pq = new int[maxN+1];
		qp = new int[maxN+1];
		for(int i=0; i<=maxN; i++) qp[i] = -1;
	}
	
	/**
	 * 返回队列是否为空
	 * @return
	 */
	boolean isEmpty() {
		return N == 0;
	}
	
	/**
	 * 是否存在索引位k的元素
	 * @param k
	 * @return
	 */
	public boolean contains(int k) {
		return qp[k] != -1;
	}
	
	public Key min() {
		return keys[pq[1]];
	}
	
	/**
	 * 删除最小元素并返回它的索引
	 * @return
	 */
	public int delMin() {
		int indexOfMin = pq[1];
		exch(1, N--);
		sink(1);
		keys[pq[N+1]] = null;
		qp[pq[N+1]] = -1;
		return indexOfMin;
	}
	
	public int minIndex() {
		return pq[1];
	}
	
	/**
	 * 将索引为k的元素替换为key
	 * @param k
	 * @param key
	 */
	public void change(int k, Key key) {
		keys[k] = key;
		swim(qp[k]);
		sink(qp[k]);
	}
	
	/**
	 * 删除索引k及其相关联的元素
	 * @param k
	 */
	public void delete(int k) {
		int index = qp[k];
		exch(index, N--);
		swim(index);
		sink(index);
		keys[k] = null;
		qp[k] = -1;
	}
	
	public void insert(int k, Key key) {
		N++;
		qp[k] = N;
		pq[N] = k;
		keys[k] = key;
		swim(N);
	}
	
	/**
	 * 小值上浮
	 * @param k
	 */
	private void swim(int k) {
		while(k > 1 && less(k, k / 2)) {
			exch(k, k/2);
			k = k / 2;
		}
	}
	
	/**
	 * 大值下沉
	 * @param k
	 */
	private void sink(int k) {
		while(2*k <= N) {
			int j = 2*k;
			if (j+1 <= N && !less(j, j+1)) j++;
			if (less(k, j)) break;
			exch(k, j);
			k = j;
		}
	}
	
	/** 比较两个位置的元素大小
	 * @param i
	 * @param j
	 * @return
	 */
	private boolean less(int i,int j) {
		return pq[i] < pq[j];
	}
	
	/**
	 * 交换两个位置的元素
	 * @param i
	 * @param j
	 */
	private void exch(int i, int j) {
		int temp =  pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}
}
