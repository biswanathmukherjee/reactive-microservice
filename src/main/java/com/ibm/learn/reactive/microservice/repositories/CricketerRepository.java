package com.ibm.learn.reactive.microservice.repositories;

import com.ibm.learn.reactive.microservice.entities.Cricketer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CricketerRepository extends ReactiveMongoRepository<Cricketer,Integer> {

}
