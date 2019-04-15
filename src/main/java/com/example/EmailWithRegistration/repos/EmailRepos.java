package com.example.EmailWithRegistration.repos;

import com.example.EmailWithRegistration.domain.EmailRegistration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepos extends MongoRepository<EmailRegistration,String> {
}
