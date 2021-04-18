package com.eCommerce.dream.resources;

import com.eCommerce.dream.domain.User;
import com.eCommerce.dream.repository.UserRepository;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value="/ecommerce/user")
public class UserResources {

    @Autowired
    UserRepository repository;

    @GetMapping(value="/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) throws ObjectNotFoundException {
        Optional<User> user = repository.findById(id);
        User userDTo = user.get();

        return (userDTo != null) ?
                ResponseEntity.ok().body(userDTo) :
                ResponseEntity.notFound().build();
    }

}