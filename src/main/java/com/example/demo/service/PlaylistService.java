package com.example.demo.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.demo.document.Playlist;
import com.example.demo.repository.PlaylistRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlaylistService {
	
	@Autowired
	private PlaylistRepository repository;
	
	public Flux<Playlist> findAll(){
		return repository.findAll();
	}
	
	public Mono<Playlist> findById(String id){
		return this.repository.findById(id).switchIfEmpty(Mono.error(NotFoundException::new));
	}
	
	public Mono<Playlist> save(Playlist playlist){
		return repository.save(playlist);
	}
	
	public Mono<Void> delete(Playlist playlist){
		return repository.delete(playlist);
	}
	
	public Mono<Void> deleteById(String id){
		return repository.deleteById(id);
	}

	public Mono<Playlist> update(String id, Playlist playlist) {
		Playlist entity = this.findById(id).block();
		BeanUtils.copyProperties(playlist, entity, "id");
		return this.save(entity);
	}

	public Flux<Playlist> findByName(String name) {
		Playlist p = new Playlist();
		p.setName(name);
		return repository.findAll(Example.of(p));
	}

}
