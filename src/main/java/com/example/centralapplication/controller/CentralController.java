package com.example.centralapplication.controller;


import com.example.centralapplication.converter.DtoConverter;
import com.example.centralapplication.dto.CentralDto;
import com.example.centralapplication.entity.CentralEntity;
import com.example.centralapplication.repo.CentralRepo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController

public class CentralController {

    private static final Logger logger = LoggerFactory.getLogger(CentralController.class);

    @Autowired
    private CentralRepo centralRepo;

    @Autowired
    private DtoConverter dtoConverter;

    public CentralController(CentralRepo centralRepo, DtoConverter dtoConverter) {
        this.centralRepo = centralRepo;
        this.dtoConverter = dtoConverter;
    }

    @PostMapping("/api/data")
    public void saveAuditData(@RequestBody CentralEntity centralEntity) {
        logger.info("Inside the /api/data API ");
        centralRepo.save(centralEntity);
    }

    @GetMapping("/findAll")
    public List<CentralDto> getall() {
        List<CentralEntity> findAll = centralRepo.findAll();
        return dtoConverter.entitiesToDtos(findAll);
    }
}
