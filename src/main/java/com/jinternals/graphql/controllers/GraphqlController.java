package com.jinternals.graphql.controllers;

import com.jinternals.graphql.configuration.GraphqlConfiguration;
import graphql.ExecutionResult;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class GraphqlController {

    private GraphQL graphQL;
    private GraphqlConfiguration graphqlConfiguration;

    @Autowired
    public GraphqlController(GraphqlConfiguration graphqlConfiguration) throws IOException {
        this.graphqlConfiguration = graphqlConfiguration;
        graphQL = graphqlConfiguration.createGraphQlObject();
    }

    @PostMapping(value = "/query")
    public ResponseEntity query(@RequestBody String query) {
        ExecutionResult result = graphQL.execute(query);
        System.out.println("errors: " + result.getErrors());
        return ok(result.getData());
    }
}


