package com.goesbernardo.api.controller;

import com.goesbernardo.api.dto.OwnerPostDTO;
import com.goesbernardo.api.service.OwnerPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/owner")
public class OwnerPostController {


    @Autowired
    private OwnerPostService service;

    @PostMapping
    public ResponseEntity createOwnerCar(@RequestBody OwnerPostDTO dto) {

        service.createOwner(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
