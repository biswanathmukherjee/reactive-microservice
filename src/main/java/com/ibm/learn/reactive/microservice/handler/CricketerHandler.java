package com.ibm.learn.reactive.microservice.handler;

import com.ibm.learn.reactive.microservice.models.CricketerDTO;
import com.ibm.learn.reactive.microservice.repositories.CricketerDAO;
import com.ibm.learn.reactive.microservice.services.CricketerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CricketerHandler {

    @Autowired
    private CricketerDAO cricketerDAO;

    @Autowired
    private CricketerService cricketerService;

    public Mono<ServerResponse> getAllCricketersStream(ServerRequest request) {
        Flux<CricketerDTO> allCricketsStream = cricketerDAO.getAllCricketsStream();
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(allCricketsStream, CricketerDTO.class);
    }

    public Mono<ServerResponse> getCricketersDetails(ServerRequest request) {
        String firstName = request.pathVariable("firstName");
        Flux<CricketerDTO> allCricketsStream = cricketerDAO.getAllCricketsStream();

//        Mono<Cricketer> cricketerMono = cricketerService.getCricketersStream()
//                .filter(c -> firstName.equalsIgnoreCase(c.getFirstName())).take(1).single();

        Mono<CricketerDTO> cricketerMono = cricketerService.getCricketersStream()
                .filter(c -> firstName.equalsIgnoreCase(c.getFirstName())).next();
        return ServerResponse.ok()
                .body(cricketerMono, CricketerDTO.class);
    }

    public Mono<ServerResponse> saveCricketersDetails(ServerRequest request) {

        Mono<CricketerDTO> cricketerMono = request.bodyToMono(CricketerDTO.class);

        Mono<String> response = cricketerMono.map(c -> c.getFirstName() + " " + c.getLastName());


//        response.subscribe(
//                value -> System.out.println(value),
//                error -> error.printStackTrace(),
//                () -> System.out.println("completed without a value")
//        );
//
////        response.subscribe(System.out::println);
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response, String.class);
    }

    public Mono<ServerResponse> updateCricketersDetails(ServerRequest serverRequest) {

        Mono<CricketerDTO> cricketerMono = serverRequest.bodyToMono(CricketerDTO.class);

        int id = Integer.valueOf(serverRequest.pathVariable("id"));

        // Get the list of crickets
        // for loop - iterate over it to find a match
        //if found
            // update that object
            // create a response with the new object
        // else i.e. not found
            // create response empty object

        return cricketerMono.flatMap(cricketer -> {
            Mono<CricketerDTO> cricketToUpdate = cricketerService.getCricketersStream()
                    .filter(c -> id == c.getId())
                    .next();
            return ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(cricketToUpdate.flatMap( ctu -> cricketerService.updateCricketersDetails(cricketer))
                                .switchIfEmpty(Mono.just(new CricketerDTO()))
                                , CricketerDTO.class);
        });


    }

    public Mono<ServerResponse> saveCricketerMongo(ServerRequest serverRequest) {
        Mono<CricketerDTO> cricketerDTOMono = serverRequest.bodyToMono(CricketerDTO.class);

        return ServerResponse.accepted().body(cricketerService.saveCricketerMongo(cricketerDTOMono), CricketerDTO.class);
    }

    public Mono<ServerResponse> getAllCricketersMongo(ServerRequest serverRequest) {

        return ServerResponse.ok().body(cricketerService.getAllCricketersMongo(), CricketerDTO.class);
    }

    public Mono<ServerResponse> getCricketerDetailsMongo(ServerRequest serverRequest) {
        Integer id = Integer.valueOf(serverRequest.pathVariable("id"));

        return ServerResponse.ok().body(cricketerService.getCricketerDetailsMongo(id), CricketerDTO.class);
    }

    public Mono<ServerResponse> updateCricketerMongo(ServerRequest serverRequest) {
        Integer id = Integer.valueOf(serverRequest.pathVariable("id"));
        Mono<CricketerDTO> cricketerDTOMono = serverRequest.bodyToMono(CricketerDTO.class);

        return ServerResponse.ok().body(cricketerService.updateCricketerMongo(cricketerDTOMono, id)
                .onErrorResume(e -> Mono.error(new Exception(e.getMessage())))
                , CricketerDTO.class);
    }
}
