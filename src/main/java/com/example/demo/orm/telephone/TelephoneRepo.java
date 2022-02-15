package com.example.demo.orm.telephone;

import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface TelephoneRepo extends JpaRepository<Telephone,Long> {

}
