package com.example.demo.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class MergeTwoSortedListsTest {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		
		System.out.println(mergeTwoLists(l1, l2));
	}
	
	
	 public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        List<Integer> values = new ArrayList<>();
	        values.add(l1.val);
	        while(l1.next != null){
	        	l1 = l1.next;
	            values.add(l1.val);
	        }
	        values.add(l2.val);
	        while(l2.next != null){
	        	l2 = l2.next;
	            values.add(l2.val);
	        }
	        values = values.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
	        ListNode merged = new ListNode(0);
	        ListNode node = merged;
	        for(int i = 0; i < values.size(); i++){
	          node.next = new ListNode(values.get(i));
	          node = node.next;
	        }
	            
	        return node.next;
	    }
}
