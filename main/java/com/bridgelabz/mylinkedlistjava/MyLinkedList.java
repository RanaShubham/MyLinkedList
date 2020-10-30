package com.bridgelabz.mylinkedlistjava;

public class MyLinkedList<K>
{
	private Node<K> head;
	private Node<K> tail;
	
	public MyLinkedList()
	{
		this.head = null;
		this.tail = null;
	}
	
	/**
	 * @return head Node of this Node.
	 */
	public Node<K> getHead() 
	{
		return this.head;
	}

	/**
	 * @return tail Node of this Node
	 */
	public Node<K> getTail() 
	{
		return this.tail;
	}
	
	/**
	 * Adds the Node object to MyLinkedList at the top. When first node is added, its tail and head refer to null.
	 * Subsequent addition of Node types is done on top.
	 * @param myNode
	 */
	public void addTop(Node<K> myNode)
	{
		if (this.tail == null) 
		{
			this.tail = myNode;
		}
		if (this.head == null)
		{
			this.head = myNode;
		}
		else
		{
			Node<K> tempNode = this.head;
			this.head = myNode;
			this.head.setNext(tempNode);
		}
	}
	
	/**Adds the node to MyLinkedList at the bottom. When first node is added, its tail and head refer to null.
	 * Subsequent additions of nodes is done at bottom.
	 * @param myNode
	 */
	public void addBottom(Node<K> myNode)
	{
		if (this.tail == null) 
		{
			this.tail = myNode;
		}
		if (this.head == null)
		{
			this.head = myNode;
		}
		else
		{
			this.tail.setNext(myNode);
			this.tail = myNode;
		}
	}
	
	/**
	 * When called upon MyLinkedList type, prints all the Node types available in it.
	 */
	public void printMyLinkedNodes() 
	{
		StringBuffer myNodes = new StringBuffer("My Nodes: ");
		Node<K> tempNode = head;
		
		while(tempNode.getNext() != null)
		{
			myNodes.append(tempNode.getKey());
			if (!tempNode.equals(tail)) 
				myNodes.append("->");
			tempNode = tempNode.getNext();
		}
		myNodes.append(tempNode.getKey());
		System.out.println(myNodes);
	}
}
