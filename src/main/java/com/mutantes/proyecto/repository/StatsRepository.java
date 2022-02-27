package com.mutantes.proyecto.repository;

import java.util.List;

import com.mutantes.proyecto.model.Stats;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StatsRepository extends JpaRepository<Stats, Long>{
    
    long countByResultType(String resultType);

    List<Stats> findByResultType(String resultType);
}
