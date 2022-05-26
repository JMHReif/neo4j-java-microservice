package com.jmhreif.neo4jjavamicroservice;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/neo")
@AllArgsConstructor
class ReviewController {
    private final ReviewRepository reviewRepo;

    @GetMapping
    String liveCheck() {
        return "Neo4j Java Microservice is up";
    }

    @GetMapping("/reviews")
    Flux<Review> getReviews() {
        return reviewRepo.findFirst1000By();
    }

    @GetMapping("/reviews/{book_id}")
    Flux<Review> getBookReviews(@PathVariable String book_id) {
        return reviewRepo.findReviewsByBook(book_id);
    }
}
