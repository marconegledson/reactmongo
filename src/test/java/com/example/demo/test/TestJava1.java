package com.example.demo.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestJava1 {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(6,14,10,7,2,3,8);
		List<Integer> even =  numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		List<Integer> odd =  numbers.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());
		
		List<Integer> numbersNew = new ArrayList<>();
		numbersNew.addAll(even);
		numbersNew.addAll(odd);
		
		System.out.println(numbersNew);

	}

}
