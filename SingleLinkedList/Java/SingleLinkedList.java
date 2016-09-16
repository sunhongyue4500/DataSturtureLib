package com.Buaa;

public class SingleLinkedList implements List{
	Node headNode;
	Node currentNode;
	int size;
	
	//令当前节点指向要操作的节点的前一个节点
	private void index(int index) throws Exception {
		if (index < -1 || index > size -1 ) {
			throw new Exception("参数错误");
		}
		if (index == -1) return;
		int j = 0;
		currentNode = headNode.getNext();
		while (currentNode != null && j < index) {
			currentNode = currentNode.getNext();
			j++;
		}
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}
	@Override
	public void insert(int index, Object obj) throws Exception {
		// TODO Auto-generated method stub
		if (index < 0 || index > size) {
			throw new Exception("参数错误");
		}
		index(index-1);
		currentNode.setNext(new Node(currentNode.getNext(), obj));
		size++;
	}
	
	@Override
	public void delete(int index) throws Exception {
		// TODO Auto-generated method stub
		if (index < 0 || index > size) {
			throw new Exception("参数错误");
		}
		index(index-1);
		currentNode.setNext(currentNode.getNext().getNext());
		size--;
	}
	
	@Override
	public Object element(int index) throws Exception {
		// TODO Auto-generated method stub
		if (index < 0 || index > size) {
			throw new Exception("参数错误");
		}
		index(index-1);
		return currentNode.getNext().getElement();
	}
	
	

}
