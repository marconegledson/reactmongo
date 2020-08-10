package com.example.demo.web;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.document.Playlist;
import com.example.demo.service.PlaylistService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
@RequestMapping("/playlist")
public class PlaylistRestController {
	
	@Autowired
	private PlaylistService service;
	
	@GetMapping("/")
	public Flux<Playlist> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Mono<Playlist> findById(@PathVariable(name = "id", required = true) String id){
		return service.findById(id);
	}
	
	@PostMapping("/")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Mono<Playlist> create(@RequestBody Playlist playlist){
		return service.save(playlist);
	}
	
	@PutMapping("/{id}")
	public Mono<Playlist> update(@PathVariable(name = "id", required = true) String id, @RequestBody Playlist playlist){
		return service.update(id, playlist);
	}
	
	@DeleteMapping("/{id}")
	public Mono<Void> deleteById(@PathVariable(name = "id", required = true) String id){
		return service.deleteById(id);
	}
	
	@GetMapping(value ="/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Tuple2<Long, Playlist>> events(){
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(5));
		Flux<Playlist> events = service.findAll();
		return Flux.zip(interval, events);
	}
	
	@GetMapping("/search")
	public Flux<Playlist> findByName(@RequestParam("name") String name){
		return service.findByName(name);
	}

}
