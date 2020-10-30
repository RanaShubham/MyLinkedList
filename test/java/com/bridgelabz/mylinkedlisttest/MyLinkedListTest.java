package com.bridgelabz.mylinkedlisttest;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.mylinkedlistjava.MyLinkedList;
import com.bridgelabz.mylinkedlistjava.MyNode;

public class MyLinkedListTest {

	@Test
	public void given3Numbers_WhenAdded_ShouldBeAddedToTop() 
	{
		MyNode<Integer> myFirstNode = new MyNode<>(70);
		MyNode<Integer> mySecondNode = new MyNode<>(30);
		MyNode<Integer> myThridNode = new MyNode<>(56);
		
		MyLinkedList myLinkedList = new MyLinkedList<Integer>();
		myLinkedList.addTop(myFirstNode);
		myLinkedList.addTop(mySecondNode);
		myLinkedList.addTop(myThridNode);
		
		boolean result = myLinkedList.getHead().equals(myThridNode) &&
						 myLinkedList.getHead().getNext().equals(mySecondNode) &&
						 myLinkedList.getTail().equals(myFirstNode);	
		myLinkedList.printMyLinkedNodes();
		Assert.assertTrue(result);
	}
	
	@Test
	public void given3Numbers_WhenAdded_ShouldBeAddedToBottom() 
	{
		MyNode<Integer> myFirstNode = new MyNode<>(56);
		MyNode<Integer> mySecondNode = new MyNode<>(30);
		MyNode<Integer> myThridNode = new MyNode<>(70);
		
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.addBottom(myFirstNode);
		myLinkedList.addBottom(mySecondNode);
		myLinkedList.addBottom(myThridNode);
		
		boolean result = myLinkedList.getHead().equals(myFirstNode) &&
						 myLinkedList.getHead().getNext().equals(mySecondNode) &&
						 myLinkedList.getTail().equals(myThridNode);
		myLinkedList.printMyLinkedNodes();
		Assert.assertTrue(result);
	}

}
