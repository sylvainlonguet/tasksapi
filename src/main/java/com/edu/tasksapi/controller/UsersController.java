package com.edu.tasksapi.controller;

import org.springframework.web.bind.annotation.RestController;

import com.edu.tasksapi.entity.User;
import com.edu.tasksapi.repository.UserRepository;
import com.edu.tasksapi.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("users")

public class UsersController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService svc;

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id) {

        return userRepository.findByIduser(id).block();

    }

    @GetMapping("/random")
    public User getUser() {

        return svc.getRandomUser();

    }

    @Value("#{ systemProperties['user.region'] ?:'fr'}")
    private String defaultLocale = "FR";

    @GetMapping("/greetings")
    /**
     * Tester du langage SpEl avec les classes Expression et ExpressionParser
     * 
     * @return
     */
    public String greet() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World ! '.concat(' to you')");

        return (String) exp.getValue() + " your default locale is " + defaultLocale;

    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public User createUser(@RequestBody User user) throws Exception {

        if (user == null) {
            throw new Exception("user non renseigné");
        }
        return userRepository.save(user).blockOptional().orElseThrow();
    }

}
