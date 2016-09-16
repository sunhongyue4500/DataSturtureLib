package com.Buaa;

//节点类
public class Node {
	private Object element;
	private Node next;
	
	//头结点构造方法
	public Node (Node node) {
		this.next = node;
	}
	
	//非头结点的构造方法
	public Node (Node node, Object element) {
		this.next = node;
		this.element = element;
	}

	public void setElement (Object element) {
		this.element = element;
	}
	
	public Object getElement () { 
		return this.element;
	}
	
	public void setNext (Node next) {
		this.next = next;
	}
	
	public Node getNext () {
		return this.next;
	}
	
	public String toString() {
		return this.element.toString();
	}
	
}
