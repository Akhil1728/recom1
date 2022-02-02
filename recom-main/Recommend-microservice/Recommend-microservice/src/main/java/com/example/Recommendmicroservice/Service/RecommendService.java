package com.example.Recommendmicroservice.Service;

import com.example.Recommendmicroservice.Entity.Recommend;

import java.util.List;
import java.util.Optional;

public interface RecommendService {
    Recommend addRecommend(Recommend recommend);
    Optional<Recommend> getRecommendById(long recommendationId);
    Recommend updateRecommend(Recommend recommend,long recommendationId);
    String deleteRecommendById(long recommendationId);
    List<Recommend> getAllRecommend();

}
