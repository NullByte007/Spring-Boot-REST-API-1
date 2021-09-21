package com.sbapi.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cid;

    private String commentValue;

    private int cUpVoteValue=0;
    private int cDownVOteValue=0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "qid", referencedColumnName = "qid")
    private Question question;

}
