package com.example.centralapplication.controller;


import com.example.centralapplication.entity.CentralEntity;
import com.example.centralapplication.repo.CentralRepo;
import com.example.centralapplication.service.CentralService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;


@Slf4j
@RestController

public class CentralController {

    private static final Logger logger = LoggerFactory.getLogger(CentralController.class);

    @Autowired
    private CentralRepo centralRepo;


    @PostMapping("/api/data")
    public void saveAuditData(@RequestBody CentralEntity centralEntity) {
        logger.info("inside the /api/data API ");
//        centralService.saveEntity(centralEntity);
        centralRepo.save(centralEntity);

    }


}
