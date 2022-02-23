package com.casassanta.lotteryapi.exception

import org.apache.coyote.Response
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalHandlerException {

    private val logger = LoggerFactory.getLogger(GlobalHandlerException::class.java)

    @ExceptionHandler(InvalidAmountNumbersMegaSenaException::class)
    fun handleInvalidAmountNumbersMegaSenaException(e: InvalidAmountNumbersMegaSenaException): ResponseEntity<String>{
        logger.info("Handling Invalid Amount of Numbers for MegaSena", e)

        return ResponseEntity<String>(
            e.message,
            HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(InvalidAmountGamesException::class)
    fun handleInvalidAmountGamesException(e: InvalidAmountGamesException): ResponseEntity<String>{
        logger.info("Handling Invalid Amount of Games for the Lottery", e)

        return ResponseEntity<String>(
            e.message,
            HttpStatus.BAD_REQUEST
        )
    }

}