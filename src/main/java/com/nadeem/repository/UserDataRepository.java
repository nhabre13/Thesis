package com.nadeem.repository;

import com.nadeem.domain.UserData;
import org.springframework.data.mongodb.repository.MongoRepository;


// interface is needed to implement the functions in the Mongo Repository / CRUD Repository
public interface UserDataRepository extends MongoRepository<UserData, String> {

}
