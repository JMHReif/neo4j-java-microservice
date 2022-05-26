package com.jmhreif.neo4jjavamicroservice;

import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

interface ReviewRepository extends ReactiveCrudRepository<Review, Long> {

    Flux<Review> findFirst1000By();

    @Query("MATCH (r:Review)-[rel:WRITTEN_FOR]->(b:Book {book_id: $book_id}) RETURN r;")
    Flux<Review> findReviewsByBook(String book_id);
}
