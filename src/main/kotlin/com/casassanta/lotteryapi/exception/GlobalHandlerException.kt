package com.casassanta.lotteryapi.exception

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalHandlerException {

    private val logger = LoggerFactory.getLogger(GlobalHandlerException::class.java)

    @ExceptionHandler(InvalidAmountNumbersMegaSenaException::class)
    fun handleInvalidAmountNumbersMegaSenaException(): ResponseEntity<String>{
        return ResponseEntity<String>(
            "Invalid amount of numbers for MegaSena games",
            HttpStatus.BAD_REQUEST
        )
    }

}