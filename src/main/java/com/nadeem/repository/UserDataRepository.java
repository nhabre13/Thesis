package com.nadeem.repository;

import com.nadeem.domain.UserData;
import org.springframework.data.repository.CrudRepository;

public interface UserDataRepository extends CrudRepository<UserData, String> {

}
