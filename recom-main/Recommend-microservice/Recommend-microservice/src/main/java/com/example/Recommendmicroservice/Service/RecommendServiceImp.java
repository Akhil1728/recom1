package com.example.Recommendmicroservice.Service;

import com.example.Recommendmicroservice.Entity.Recommend;
import com.example.Recommendmicroservice.Repository.RecommendRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecommendServiceImp implements RecommendService {

    @Autowired
    public final RecommendRepo recommendRepo;

    public RecommendServiceImp(RecommendRepo recommendRepo) {
        this.recommendRepo = recommendRepo;
    }

    @Override
    public Recommend addRecommend(Recommend recommend)
    {
        return recommendRepo.save(recommend);
    }

    @Override
    public Optional<Recommend> getRecommendById(long recommendationId)
    {
        return recommendRepo.findById(recommendationId);
    }

    @Override
    public Recommend updateRecommend(Recommend recommend,long recommendationId)
    {
        Recommend recommendDB = new Recommend();
        recommendDB.setAuthor(recommend.getAuthor());
        recommendDB.setRate(recommend.getRate());
        recommendDB.setDestId(recommend.getDestId());
        recommendDB.setContent(recommend.getContent());
        return recommendRepo.save(recommendDB);
    }

    @Override
    public String deleteRecommendById(long recommendationId)
    {
         recommendRepo.deleteById(recommendationId);
        return recommendationId+"deleted";
    }

    @Override
    public List<Recommend> getAllRecommend()
    {
        return (List<Recommend>) recommendRepo.findAll();
    }



}
