package com.example.centralapplication.controller;


import com.example.centralapplication.entity.CentralEntity;
import com.example.centralapplication.repo.CentralRepo;
import com.example.centralapplication.service.CentralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

@RestController

public class CentralController {
    @Autowired
    private CentralService centralService;

    @Autowired
    private CentralRepo centralRepo;
    public CentralController(WebClient webClient, CentralRepo centralEntityRepository) {

    }




    @GetMapping("/audit")
    public String getAudit(){
        return "audited the api";
    }

    @PostMapping("/api/data")
    public void saveAuditData(@RequestBody CentralEntity centralEntity) {
//        centralService.saveEntity(centralEntity);
        centralRepo.save(centralEntity);

    }


}
