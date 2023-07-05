package com.goesbernardo.api.controller;

import com.goesbernardo.api.dto.CarPostDTO;
import com.goesbernardo.api.message.KafkaProducerMessage;
import com.goesbernardo.api.service.CarPostStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/car")
public class CarPostController {

    @Autowired
    public CarPostStoreService service;

    @Autowired
    private KafkaProducerMessage kafkaProducerMessage;


    @PostMapping(value = "/post")
    public ResponseEntity postCarForSale(@RequestBody CarPostDTO dto) {
        kafkaProducerMessage.sendMessage(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/posts")
    public ResponseEntity<List<CarPostDTO>> getCarSales() {

        return ResponseEntity.status(HttpStatus.FOUND).body(service.getCarForSales());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity changeCarSale(@RequestBody CarPostDTO cardPostDTO, @PathVariable("id") String id) {

        service.changeCarForSale(cardPostDTO, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deleteCarForSale(@PathVariable("id") String id) {
        service.removeCarForSale(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
