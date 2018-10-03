package com.codecool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

abstract class AbstractController<E> {

    ResponseEntity<E> getResponseEntity(boolean isSuccess) {
        if (isSuccess) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
