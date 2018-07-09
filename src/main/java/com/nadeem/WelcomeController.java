package com.nadeem;

import com.nadeem.domain.UserData;
import com.nadeem.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Controller
public class WelcomeController {

    @Autowired
    private UserDataRepository repository;

    // POST method takes values from the put method below and saves them in the database
    // UserData class is called - all the variables needed are found there

    @RequestMapping(value = "/put", method = RequestMethod.POST)
    public @ResponseBody
    UserData put(@RequestBody final UserData userData) {
        // .save inserts the data into the database
        return repository.save(userData.hashData());

    }

}
