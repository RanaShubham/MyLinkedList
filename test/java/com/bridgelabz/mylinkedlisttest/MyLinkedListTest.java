package com.bridgelabz.mylinkedlisttest;

import static org.junit.Assert.*;

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
		
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.addTop(myFirstNode);
		myLinkedList.addTop(mySecondNode);
		myLinkedList.addTop(myThridNode);
		
		boolean result = myLinkedList.getHead().equals(myThridNode) &&
						 myLinkedList.getHead().getNext().equals(mySecondNode) &&
						 myLinkedList.getTail().equals(myFirstNode);		
		Assert.assertTrue(result);
	}

}
