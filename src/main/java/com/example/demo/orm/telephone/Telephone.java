package com.example.demo.orm.telephone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "telephone")
public class Telephone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private int number;

//    @ManyToOne(fetch = FetchType.LAZY,optional = false)
//    @JoinTable(name = "site_telephone",
//        joinColumns = @JoinColumn(name = "telephone_id",referencedColumnName = "id"),
//        inverseJoinColumns = @JoinColumn(name = "site_id"))
//
//    private Site site;
}
