package com.codecool.controller;

import com.codecool.model.Excavation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AbstractController {

    ResponseEntity<Excavation> getResponseEntity(boolean isSuccess) {
        if (isSuccess) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
