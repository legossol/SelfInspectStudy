package com.example.demo.associationfakeobject.player;

import com.example.demo.associationfakeobject.team.Team;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
@Table
public class Player {

    protected Player(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "player_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "team")
    private Team team;
}
