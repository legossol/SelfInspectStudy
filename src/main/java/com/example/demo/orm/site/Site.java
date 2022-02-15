package com.example.demo.orm.site;

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
@Table(name = "site")
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

//    @OneToMany(mappedBy = "site")
//    private List<Telephone> telephoneList;

//    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
//    @JoinTable(name = "site_telephone",
//    joinColumns = @JoinColumn(name = "site_id"),
//    inverseJoinColumns = @JoinColumn(name = "telephone_id"))
//    private List<Telephone> telephoneList = new ArrayList<>();
//    private Telephone telephone;
}
