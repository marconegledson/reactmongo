package com.example.demo.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TestJava4 {

	public static void main(String[] args) {
		Set<Integer> numbers = new TreeSet<>(Arrays.asList(1, 6, 3, 9, 2));
		List<Integer> reversed = numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		Integer result = 0;
		if(!reversed.isEmpty() && reversed.size() > 3) {
			result = reversed.get(0) * reversed.get(1) * reversed.get(2);
		}
		
		System.out.println(result);
		
	}

}
