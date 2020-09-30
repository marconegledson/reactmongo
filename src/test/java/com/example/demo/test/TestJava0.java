package com.example.demo.test;

import java.util.List;
import java.util.stream.Collectors;

public class TestJava0 {
	
	public static void main(String[] args) {
		String str = "pqqprq";
		List<String> chars = str.chars().mapToObj(e -> String.valueOf((char) e)).collect(Collectors.toList());
		
		for (int i = 0; i < chars.size(); i++) {
			if(chars.size() > 2 && chars.get(i).equals(chars.get(i+1))) {
				chars.remove(i+1);
				chars.remove(i);
				i = -1;
			}
		}
		
		System.out.println(chars.stream().collect(Collectors.joining()));

	}

}
