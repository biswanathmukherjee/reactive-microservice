package com.ibm.learn.reactive.microservice.services;

import com.ibm.learn.reactive.microservice.entities.Cricketer;
import com.ibm.learn.reactive.microservice.models.CricketerDTO;
import com.ibm.learn.reactive.microservice.repositories.CricketerDAO;
import com.ibm.learn.reactive.microservice.repositories.CricketerRepository;
import com.ibm.learn.reactive.microservice.utils.TransformationUtils;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CricketerService {
    @Autowired
    private CricketerDAO cricketerDAO;

    @Autowired
    private CricketerRepository cricketerRepository;

    public List<CricketerDTO> getAllCricketers(){
        long startTime = System.currentTimeMillis();

        List<CricketerDTO> cricketerDTOS = cricketerDAO.getAllCrickets();
        long endTime = System.currentTimeMillis();

        System.out.println("Traditional Execution time : " + (endTime-startTime));
        return cricketerDTOS;

    }

    public Flux<CricketerDTO> getAllCricketersStream() {
        long startTime = System.currentTimeMillis();

        Flux<CricketerDTO> cricketers = cricketerDAO.getAllCricketsStream();
        long endTime = System.currentTimeMillis();

        System.out.println("Reactive Execution time : " + (endTime-startTime));
        return cricketers;
    }

    public Flux<CricketerDTO> getCricketersStream(){
        return CricketerDAO.getCricketers();

    }

    public Mono<CricketerDTO> updateCricketersDetails(CricketerDTO c) {
        System.out.println("Inside Service " + c);
        return Mono.just(c);
    }

    public Mono<CricketerDTO> saveCricketerMongo(Mono<CricketerDTO> cricketerDTOMono) {
        System.out.println("Inside Service ");

        return  cricketerDTOMono.map(TransformationUtils::dtoToEntity)
                .flatMap(cricketerRepository::insert)
                .map(TransformationUtils::entityToDTO);
    }


    public Flux<CricketerDTO> getAllCricketersMongo() {
        System.out.println("Inside Service ");

        return cricketerRepository.findAll()
                .map(TransformationUtils::entityToDTO);
    }

    public Mono<CricketerDTO> getCricketerDetailsMongo(Integer id) {
        System.out.println("Inside Service ");

        return cricketerRepository.findById(id)
                .map(TransformationUtils::entityToDTO);
    }


    public Mono<CricketerDTO> updateCricketerMongo(Mono<CricketerDTO> cricketerDTOMono, Integer id){

        return cricketerRepository.findById(id)
                .flatMap(p->cricketerDTOMono.map(TransformationUtils::dtoToEntity)
                        .doOnNext(e->e.setId(id)))
                .flatMap(cricketerRepository::save)
                .map(TransformationUtils::entityToDTO);

    }
}
