package com.example.demo.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestJava3 {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3);
		Map<Integer, Integer> mapper = new HashMap<>();
		
		for (Integer integer : numbers) {
			if(!mapper.containsKey(integer)) {
				mapper.put(integer, 1);
			}else {
				mapper.put(integer, mapper.get(integer)+1);
			}
		}
		boolean resyk = mapper.entrySet().stream().filter(entry -> entry.getValue() > 1).count() > 1;
		
		System.out.println(resyk); ;

	}

}
