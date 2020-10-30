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
	 * Inserts a Node between two Nodes.
	 * @param Node after which new Node needs to be added.
	 * @param Node that needs to be added.
	 */
	public void addAfter(Node<K> myFirstNode, Node<K> myThirdNode) 
	{
		if (myFirstNode == null)
			throw new NodeNotFoundException("First node after which you want to add a node was not found");
		if(myFirstNode.getNext() == null)
			throw new NodeNotFoundException("Two nodes not available to inset new a Node in between");
		Node<K> tempNode = myFirstNode.getNext();
		myFirstNode.setNext(myThirdNode);
		myThirdNode.setNext(tempNode);
	}
	
	/**
	 * When calling popHead() on Node type linked list, the head of the list will be assigned to the Node next to head Node.
	 */
	public void popHead() 
	{
		if(this.head == null)
			throw new NodeNotFoundException("No head node available to pop");
		this.head = this.getHead().getNext();
	}
	
	/**
	 * When calling cutTail() on Node type linked list, the tail of the list will be assigned to the Node next to tail Node.
	 */
	public void cutTail() 
	{
		if(this.tail == null)
			throw new NodeNotFoundException("No tail node available to cut");
		
		Node<K> secondLastNode = this.head;
		
		while (secondLastNode.getNext() != this.tail) 
		{
			secondLastNode = secondLastNode.getNext();
		}
		secondLastNode.setNext(null);
		this.tail = secondLastNode;
	}
	
	/**Call on a Node list object to get a Node with specified key
	 * @param key
	 * @return Node with given key
	 */
	public Node<K> findNodeWithKey(K key)
	{
		Node<K> nodeWithKey = this.head;
		
		if (this.head == null)
			throw new NodeNotFoundException("No nodes available");
		try 
		{
			while (nodeWithKey.getKey() != key)
			{
				nodeWithKey = nodeWithKey.getNext();
			}
		return nodeWithKey;
		
		} catch (NullPointerException e) 
		{
			return nodeWithKey;
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
