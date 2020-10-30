package com.bridgelabz.mylinkedlisttest;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.mylinkedlistjava.MyLinkedList;
import com.bridgelabz.mylinkedlistjava.MyNode;
import com.bridgelabz.mylinkedlistjava.NodeNotFoundException;

public class MyLinkedListTest {

	@Test
	public void given3Numbers_WhenAdded_ShouldBeAddedToTop() 
	{
		MyNode<Integer> myFirstNode = new MyNode<>(70);
		MyNode<Integer> mySecondNode = new MyNode<>(30);
		MyNode<Integer> myThirdNode = new MyNode<>(56);
		
		MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
		myLinkedList.addTop(myFirstNode);
		myLinkedList.addTop(mySecondNode);
		myLinkedList.addTop(myThirdNode);
		
		boolean result = myLinkedList.getHead().equals(myThirdNode) &&
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
		MyNode<Integer> myThirdNode = new MyNode<>(70);
		
		MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
		myLinkedList.addBottom(myFirstNode);
		myLinkedList.addBottom(mySecondNode);
		myLinkedList.addBottom(myThirdNode);
		
		boolean result = myLinkedList.getHead().equals(myFirstNode) &&
						 myLinkedList.getHead().getNext().equals(mySecondNode) &&
						 myLinkedList.getTail().equals(myThirdNode);
		myLinkedList.printMyLinkedNodes();
		Assert.assertTrue(result);
	}
	
	@Test
	public void given3Numbers_WhenAddingLastNumber_ShouldBeAddedBetweenFirstAndSecondNumber() 
	{
		MyNode<Integer> myFirstNode = new MyNode<>(56);
		MyNode<Integer> mySecondNode = new MyNode<>(70);
		MyNode<Integer> myThirdNode = new MyNode<>(30);
		
		MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
		myLinkedList.addBottom(myFirstNode);
		myLinkedList.addBottom(mySecondNode);
		myLinkedList.addAfter(myFirstNode, myThirdNode);
		
		boolean result = myLinkedList.getHead().equals(myFirstNode) &&
						 myLinkedList.getHead().getNext().equals(myThirdNode) &&
						 myLinkedList.getTail().equals(mySecondNode);
		myLinkedList.printMyLinkedNodes();
		Assert.assertTrue(result);
	}
	
	@Test(expected = NodeNotFoundException.class)
	public void doingInsertbetweenNodes_WhenEndNodesNotFound_ShouldThrowNodeNotFoundException() 
	{
		MyNode<Integer> myFirstNode = new MyNode<>(56);
		MyNode<Integer> myThirdNode = new MyNode<>(30);
		
		MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
		myLinkedList.addBottom(myFirstNode);
		myLinkedList.addBottom(null);
		myLinkedList.addAfter(myFirstNode, myThirdNode);
		
	}
}
