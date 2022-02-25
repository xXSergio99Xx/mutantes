package com.mutantes.proyecto.repository;

import com.mutantes.proyecto.model.Stats;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StatsRepository extends JpaRepository<Stats, Long>{
    
    long countByResultType(String resultType);
}
