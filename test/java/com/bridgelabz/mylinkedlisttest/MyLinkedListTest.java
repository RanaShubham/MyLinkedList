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

		Assert.assertTrue(result);
	}
	
	@Test
	public void given3Nodes_WhenAddingLastNumber_ShouldBeAddedBetweenFirstAndSecondNumber() 
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

		Assert.assertTrue(result);
	}
	
	@Test(expected = NodeNotFoundException.class)
	public void InsertingbetweenNodes_WhenEndNodesNotFound_ShouldThrowNodeNotFoundException() 
	{
		MyNode<Integer> myFirstNode = new MyNode<>(56);
		MyNode<Integer> myThirdNode = new MyNode<>(30);
		
		MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
		myLinkedList.addBottom(myFirstNode);
		myLinkedList.addBottom(null);
		myLinkedList.addAfter(myFirstNode, myThirdNode);
		
	}
	
	@Test
	public void givenNodeList_WhenCalledPopHeadMethod_ShouldBeAbleToRemoveFirstNode() 
	{
		MyNode<Integer> myFirstNode = new MyNode<>(56);
		MyNode<Integer> mySecondNode = new MyNode<>(30);
		MyNode<Integer> myThirdNode = new MyNode<>(70);
		
		MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
		myLinkedList.addBottom(myFirstNode);
		myLinkedList.addBottom(mySecondNode);
		myLinkedList.addBottom(myThirdNode);
		
		myLinkedList.popHead();
				
		boolean result = myLinkedList.getHead().equals(mySecondNode);
		Assert.assertTrue(result);
	}
	
	@Test(expected = NodeNotFoundException.class)
	public void givenEmptyNodeListToPopHead_ShouldThrowNodeNotFoundException() 
	{		
		MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
		myLinkedList.addBottom(null);
		myLinkedList.popHead();
	}
	
	@Test
	public void givenNodeList_WhenCalledCutTailMethod_ShouldBeAbleToRemoveLastNode() 
	{
		MyNode<Integer> myFirstNode = new MyNode<>(56);
		MyNode<Integer> mySecondNode = new MyNode<>(30);
		MyNode<Integer> myThirdNode = new MyNode<>(70);
		
		MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
		myLinkedList.addBottom(myFirstNode);
		myLinkedList.addBottom(mySecondNode);
		myLinkedList.addBottom(myThirdNode);
		myLinkedList.cutTail();
		
		boolean result = myLinkedList.getTail().equals(mySecondNode);
		Assert.assertTrue(result);
	}
	
	@Test(expected = NodeNotFoundException.class)
	public void givenEmptyNodeListToCutTail_ShouldThrowNodeNotFoundException() 
	{		
		MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
		myLinkedList.addBottom(null);
		myLinkedList.cutTail();
	}
	
	@Test
	public void givenAKey__ShouldBeAbleToFindNodeWithThatkey() 
	{
		MyNode<Integer> myFirstNode = new MyNode<>(56);
		MyNode<Integer> mySecondNode = new MyNode<>(30);
		MyNode<Integer> myThirdNode = new MyNode<>(70);
		
		MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
		myLinkedList.addBottom(myFirstNode);
		myLinkedList.addBottom(mySecondNode);
		myLinkedList.addBottom(myThirdNode);
		
		boolean result = myLinkedList.findNodeWithKey(30).equals(mySecondNode);
		Assert.assertTrue(result);
	}
	
	@Test
	public void givenNullKeyToFindNode__ShouldBeAbleToFindNodeWithNullkey() 
	{
		MyNode<Integer> myFirstNode = new MyNode<>(56);
		MyNode<Integer> mySecondNode = new MyNode<>(30);
		MyNode<Integer> myThirdNode = new MyNode<>(null);
		
		MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
		myLinkedList.addBottom(myFirstNode);
		myLinkedList.addBottom(mySecondNode);
		myLinkedList.addBottom(myThirdNode);
		
		boolean result = myLinkedList.findNodeWithKey(null).equals(myThirdNode);

		Assert.assertTrue(result);
	}
	
	@Test (expected = NodeNotFoundException.class)
	public void givenKeyToFindNode__ifNotPresentinNodeList_ShouldThrowNodeNotFoundException() 
	{
		MyNode<Integer> myFirstNode = new MyNode<>(56);
		MyNode<Integer> mySecondNode = new MyNode<>(30);
		MyNode<Integer> myThirdNode = new MyNode<>(70);
		
		MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
		myLinkedList.addBottom(myFirstNode);
		myLinkedList.addBottom(mySecondNode);
		myLinkedList.addBottom(myThirdNode);
		
		boolean result = myLinkedList.findNodeWithKey(90).equals(myThirdNode);

		Assert.assertTrue(result);
	}
	
	@Test
	public void given4Nodes_WhenAddingnewNode_ShouldBeAddedAfterSecondNumber() 
	{
		MyNode<Integer> myFirstNode = new MyNode<>(56);
		MyNode<Integer> mySecondNode = new MyNode<>(30);
		MyNode<Integer> myThirdNode = new MyNode<>(70);
		MyNode<Integer> myNewNode = new MyNode<Integer>(40);
		
		MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
		myLinkedList.addBottom(myFirstNode);
		myLinkedList.addBottom(mySecondNode);
		myLinkedList.addBottom(myThirdNode);
		myLinkedList.addAfter(mySecondNode, myNewNode);
		
		boolean result = myLinkedList.getHead().getNext().getNext().equals(myNewNode);

		Assert.assertTrue(result);
	}
	
	@Test
	public void given4Nodes_shouldRemoveOneNodeWithAnyGivenKey() 
	{
		MyNode<Integer> myFirstNode = new MyNode<>(56);
		MyNode<Integer> mySecondNode = new MyNode<>(30);
		MyNode<Integer> myThirdNode = new MyNode<>(40);
		MyNode<Integer> myFourthNode = new MyNode<>(70);

		MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
		myLinkedList.addBottom(myFirstNode);
		myLinkedList.addBottom(mySecondNode);
		myLinkedList.addBottom(myThirdNode);
		myLinkedList.addBottom(myFourthNode);
		
		myLinkedList.removeNodeWithKey(40);
		
		boolean result = myLinkedList.getHead().getNext().getNext().getKey().equals(70);
		Assert.assertTrue(result);
	}
	
	@Test
	public void given4Nodes_ShouldRemoveNodeWithKey_whenGivenNullKey() 
	{
		MyNode<Integer> myFirstNode = new MyNode<>(56);
		MyNode<Integer> mySecondNode = new MyNode<>(null);
		MyNode<Integer> myThirdNode = new MyNode<>(40);
		MyNode<Integer> myFourthNode = new MyNode<>(70);

		MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
		myLinkedList.addBottom(myFirstNode);
		myLinkedList.addBottom(mySecondNode);
		myLinkedList.addBottom(myThirdNode);
		myLinkedList.addBottom(myFourthNode);
		
		System.out.println("Size "+myLinkedList.size());
		myLinkedList.printMyLinkedNodes();
		myLinkedList.removeNodeWithKey(null);
		System.out.println("Size "+myLinkedList.size());
		myLinkedList.printMyLinkedNodes();
		
		boolean result = myLinkedList.getHead().getNext().getKey().equals(40);
		Assert.assertTrue(result);
	}
}
