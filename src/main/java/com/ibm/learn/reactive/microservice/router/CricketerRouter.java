package com.ibm.learn.reactive.microservice.router;

import com.ibm.learn.reactive.microservice.handler.CricketerHandler;
import com.ibm.learn.reactive.microservice.models.CricketerDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class CricketerRouter {

    @Autowired
    private CricketerHandler cricketerHandler;

    @Bean
    @RouterOperations(
            {
                    @RouterOperation(
                            path = "/router/cricketers",
                            produces = {
                                MediaType.APPLICATION_JSON_VALUE
                            },
                            method = RequestMethod.GET,
                            beanClass = CricketerHandler.class,
                            beanMethod = "getAllCricketersStream",
                            operation = @Operation(
                                    operationId = "getAllCricketersStream",
                                    responses = {
                                            @ApiResponse(
                                                    responseCode = "200",
                                                    description = "Successful Operation",
                                                    content = @Content(schema = @Schema(
                                                            implementation = CricketerDTO.class
                                                    )

                                                    )
                                            )
                                    }
                            )
                    )
                    ,
                    @RouterOperation(
                            path = "/router/cricketer/{firstName}",
                            produces = {
                                    MediaType.APPLICATION_JSON_VALUE
                            },
                            method = RequestMethod.GET,
                            beanClass = CricketerHandler.class,
                            beanMethod = "getCricketersDetails",
                            operation = @Operation(
                                    operationId = "getCricketersDetails",
                                    responses = {
                                            @ApiResponse(
                                                    responseCode = "200",
                                                    description = "Successful Operation",
                                                    content = @Content(schema = @Schema(
                                                            implementation = CricketerDTO.class
                                                    )

                                                    )
                                            ),
                                            @ApiResponse(
                                                    responseCode = "404",
                                                    description = "Cricketer Not Found"

                                            )

                                    },
                                    parameters = {
                                            @Parameter(in = ParameterIn.PATH, name = "firstName")
                                    }
                            )
                    ),
                    @RouterOperation(
                            path = "/router/cricketer",
                            produces = {
                                    MediaType.APPLICATION_JSON_VALUE
                            },
                            method = RequestMethod.POST,
                            beanClass = CricketerHandler.class,
                            beanMethod = "saveCricketersDetails",
                            operation = @Operation(
                                    operationId = "saveCricketersDetails",
                                    responses = {
                                            @ApiResponse(
                                                    responseCode = "200",
                                                    description = "Successful Operation",
                                                    content = @Content(schema = @Schema(
                                                            implementation = String.class
                                                    )

                                                    )
                                            ),
                                    },
                                    requestBody = @RequestBody(
                                            content = @Content(schema = @Schema(
                                                    implementation = CricketerDTO.class
                                            )

                                            )
                                    )
                            )
                    )
            }
    )
    public RouterFunction<ServerResponse> route() {


        return RouterFunctions.route()
                .GET("/router/cricketers", cricketerHandler::getAllCricketersStream)
                .GET("/router/cricketers-mongo", cricketerHandler::getAllCricketersMongo)
                .GET("/router/cricketer/{firstName}", cricketerHandler::getCricketersDetails)
                .GET("/router/cricketer-mongo/{id}", cricketerHandler::getCricketerDetailsMongo)
                .POST("/router/cricketer", cricketerHandler::saveCricketersDetails)
                .POST("/router/cricketer-mongo", cricketerHandler::saveCricketerMongo)
                .PUT("/router/cricketer/{id}", cricketerHandler::updateCricketersDetails)
                .PUT("/router/cricketer-mongo/{id}", cricketerHandler::updateCricketerMongo)
                .build();

    }
}
