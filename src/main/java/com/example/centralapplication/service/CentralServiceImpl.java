package com.example.centralapplication.service;

import com.example.centralapplication.entity.CentralEntity;
import com.example.centralapplication.repo.CentralRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CentralServiceImpl implements CentralService{


    @Autowired
     public CentralRepo centralRepo;
    @Override
    public CentralEntity saveEntity(CentralEntity centralEntity) {
        return centralRepo.save(centralEntity);
    }
}
