package com.example.centralapplication.repo;

import com.example.centralapplication.entity.CentralEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CentralRepo extends JpaRepository<CentralEntity,Long> {
}
