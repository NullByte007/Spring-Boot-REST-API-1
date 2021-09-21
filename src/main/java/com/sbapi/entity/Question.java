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
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long  qid;

    @NonNull
    private String qTitle;

    @NonNull
    private String qDescription;
    private String tags;
    private int qUpVoteValue=0;
    private int qDownVoteValue=0;


}
