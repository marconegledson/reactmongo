package com.example.demo;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.document.Playlist;
import com.example.demo.repository.PlaylistRepository;

import reactor.core.publisher.Flux;

@Component
public class DummyData implements CommandLineRunner{

	@Autowired
	private PlaylistRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll()
			.thenMany(
					Flux.just("Api rest", "deploy", "Java 8", "Rest", "Springboot")
						.map(name -> new Playlist(UUID.randomUUID().toString(), name))
						.flatMap(repository::save))
			.subscribe(System.out::println);
		
	}

}
