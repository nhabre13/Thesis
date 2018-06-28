package com.nadeem;

import com.nadeem.domain.UserData;
import com.nadeem.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

    @Autowired
    private UserDataRepository repository;

    @RequestMapping(value = "/put", method = RequestMethod.POST)
    public @ResponseBody
    UserData put(@RequestBody final UserData userData) {

        return repository.save(userData);

    }

}
