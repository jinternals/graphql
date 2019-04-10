package com.jinternals.graphql.configuration;

import com.jinternals.graphql.fetchers.AuthorDataFetcher;
import com.jinternals.graphql.fetchers.AuthorsDataFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

import static graphql.GraphQL.newGraphQL;
import static graphql.schema.idl.RuntimeWiring.newRuntimeWiring;

@Component
public class GraphqlConfiguration {

    @Value("classpath:graphql/author.graphqls")
    private Resource schemaResource;
    private AuthorDataFetcher authorDataFetcher;
    private AuthorsDataFetcher authorsDataFetcher;

    @Autowired
    GraphqlConfiguration(AuthorDataFetcher authorDataFetcher, AuthorsDataFetcher authorsDataFetcher) {
        this.authorDataFetcher = authorDataFetcher;
        this.authorsDataFetcher = authorsDataFetcher;
    }

    @PostConstruct
    public GraphQL createGraphQlObject() throws IOException {
        File schemas = schemaResource.getFile();
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemas);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        return newGraphQL(schema).build();
    }

    public RuntimeWiring buildRuntimeWiring() {
        return newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("authors", authorsDataFetcher)
                        .dataFetcher("author", authorDataFetcher))
                .build();
    }
}
