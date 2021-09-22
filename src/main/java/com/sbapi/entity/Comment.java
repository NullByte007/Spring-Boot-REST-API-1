package com.sbapi.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cid;

    @NonNull
    private String commentValue;

    private int cUpVoteValue=0;
    private int cDownVoteValue=0;

    // If you want to use fetch Type as LAZY, add the below property in application.properties
    // spring.jackson.serialization.FAIL_ON_EMPTY_BEANS=false
    // else it will throw a serializer exception
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "qid", referencedColumnName = "qid")
    private Question question;

}
