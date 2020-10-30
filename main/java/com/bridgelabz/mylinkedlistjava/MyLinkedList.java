package com.bridgelabz.mylinkedlistjava;

public class MyLinkedList
{
	private Node head;
	private Node tail;
	
	public MyLinkedList()
	{
		this.head = null;
		this.tail = null;
	}
	
	/**
	 * @return head Node of this Node.
	 */
	public Node getHead() 
	{
		return this.head;
	}

	/**
	 * @return tail Node of this Node
	 */
	public Node getTail() 
	{
		return this.tail;
	}
	
	/**
	 * Adds the Node object to MyLinkedList. When first node is added, its tail and head refer to null.
	 * By changing where the tail and head refer to, we can add more Node types to MyLinkedList.
	 * @param myNode
	 */
	public void addTop(Node myNode)
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
			Node tempNode = this.head;
			this.head = myNode;
			this.head.setNext(tempNode);
		}
	}
	
	/**
	 * When called upon MyLinkedList type, prints all the Node types available in it.
	 */
	public void printMyLinkedNodes() 
	{
		StringBuffer myNodes = new StringBuffer("My Nodes: ");
		Node tempNode = head;
		
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
