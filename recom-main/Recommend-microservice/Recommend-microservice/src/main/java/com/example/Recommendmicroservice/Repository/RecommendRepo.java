package com.example.Recommendmicroservice.Repository;

import com.example.Recommendmicroservice.Entity.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendRepo extends JpaRepository<Recommend,Long> {
}
