package com.jmhreif.neo4jjavamicroservice;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Data
@Node
class Review {
    @Id
    @GeneratedValue
    private Long neoId;
    @NonNull
    private String review_id;

    private String book_id, review_text, date_added, date_updated, started_at, read_at;
    private Integer rating, n_comments, n_votes;
}
