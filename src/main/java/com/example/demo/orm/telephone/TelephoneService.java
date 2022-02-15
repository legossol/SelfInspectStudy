package com.example.demo.orm.telephone;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@org.springframework.stereotype.Service
@Transactional
@RequiredArgsConstructor
public class TelephoneService {
    private final TelephoneRepo repository;

    public void delete(Long id){
        repository.deleteById(id);
    }

}
