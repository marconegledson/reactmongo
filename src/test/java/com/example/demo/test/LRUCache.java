package com.example.demo.test;

import java.util.LinkedHashSet;
import java.util.Set;

public class LRUCache {
	
	private int limit = 0;
	private Set<Integer> cache = null;
	
	public LRUCache(int limit) {
		this.limit = limit;
		cache = new LinkedHashSet<Integer>(limit);
	}

	
	public void refer(int key) {
		if(cache.contains(key)) {
			cache.remove(key);
		}
		if(cache.size() == this.limit) {
			cache.remove(cache.iterator().next());
		}
		cache.add(key);
	}
	
	public void display() {
		cache.stream().forEach(i -> System.out.println(i));
	}

}
