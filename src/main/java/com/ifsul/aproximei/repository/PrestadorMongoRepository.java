package com.ifsul.aproximei.repository;

import com.ifsul.aproximei.entity.PrestadorMongoDB;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PrestadorMongoRepository extends MongoRepository<PrestadorMongoDB, String> {
}
