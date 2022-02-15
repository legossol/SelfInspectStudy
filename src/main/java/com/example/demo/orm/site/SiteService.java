package com.example.demo.orm.site;

import lombok.RequiredArgsConstructor;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class SiteService {
    private final SiteRepository repository;

    public void save(Site site){
        repository.saveAndFlush(site);
    }
    public void delete(Long id){
        repository.deleteById(id);
    }


}
