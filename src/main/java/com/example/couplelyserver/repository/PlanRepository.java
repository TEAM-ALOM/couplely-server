package com.example.couplelyserver.repository;

import com.example.couplelyserver.model.Entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan,String> {
}
