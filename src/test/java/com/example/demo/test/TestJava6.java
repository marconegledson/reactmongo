package com.example.demo.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TestJava6 {

	public static void main(String[] args) {
		Set<Character> chars = "pqqqprq".chars().mapToObj(c -> (char)c).collect(Collectors.toSet());
		String str = chars.stream().map(c -> c.toString()).collect(Collectors.joining());
		
		System.out.println(str);
		
	}

}
