package com.example.demo.test;

public class ListNode {
	
	ListNode next;
    int val;
    
    public ListNode() {}

    public ListNode(int value) {
        val = value;
        next = null;
    }

    public ListNode(int value, ListNode n) {
        val = value;
        next = n;
    }


}
