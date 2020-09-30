package com.example.demo.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TestJava5 {

	public static void main(String[] args) {
		List<String> strs = Arrays.asList("The sentence should be reversed".split(" "))
										.stream()
										.sorted(Comparator.reverseOrder())
										.collect(Collectors.toList())
										;
		System.out.println(strs);
		
	}

}
