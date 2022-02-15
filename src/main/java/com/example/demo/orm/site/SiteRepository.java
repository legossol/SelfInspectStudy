package com.example.demo.orm.site;

import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface SiteRepository extends JpaRepository<Site,Long> {


}
