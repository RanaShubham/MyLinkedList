package com.bridgelabz.mylinkedlistjava;

public interface Node <K> 
{
	/**
	 * @return Key
	 */
	K getKey();
	void setKey(K key);
	
	/**
	 * @return Reference of the next node.
	 */
	Node<K> getNext();
	void setNext(Node<K> next);
}
