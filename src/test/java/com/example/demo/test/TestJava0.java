package com.example.demo.test;

import java.util.List;
import java.util.stream.Collectors;

public class TestJava0 {
	
	public static void main(String[] args) {
		String str = "pqqqqprq";
		List<String> chars = str.chars().mapToObj(e -> String.valueOf((char) e)).collect(Collectors.toList());
		
		for (int i = 0, j = 0; i < chars.size(); i++) {
			boolean hasDuplicate = false;
			j = i+1;
			while(j < chars.size()) {
				if(chars.get(i).equals(chars.get(j))) {
					chars.remove(j);
					hasDuplicate = true;
					j = i+1;
				}else {
					break;
				}
			}
			
			if(hasDuplicate) {
				chars.remove(i);
				i = -1;
			}
		}
		
		System.out.println(chars.stream().collect(Collectors.joining()));

	}

}
