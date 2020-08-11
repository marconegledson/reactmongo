package com.example.demo.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.demo.document.Playlist;

import reactor.core.publisher.Flux;

public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String>{

	@Query("{'name' : ?0}")
	Flux<Playlist> findByName(String name);
	
	@Query(value = "{'name' : ?0}", fields = "{'description' : 0}")
	Flux<Playlist>  findByNameWithoutDescription(String name);

	@Query("{price : {$lt : ?0, $gt : ?1}}")
	Flux<Playlist> findByRangePrice(double max, double min);

	@Query("{price : {$lt : ?0, $gt : ?1}}")
	Flux<Playlist> findByRangePriceAndSort(double max, double min, Sort sort);

}
