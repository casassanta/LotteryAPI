package com.casassanta.lotteryapi.controller

import com.casassanta.lotteryapi.controller.request.LotteryGameRequest
import com.casassanta.lotteryapi.controller.response.LotteryGameResponse
import com.casassanta.lotteryapi.service.LotteryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class LotteryController(
    private val lotteryService: LotteryService
) {

    @PostMapping("/api/lotteries")
    fun generateLotteryGames(@RequestBody lotteryGameRequest: LotteryGameRequest): LotteryGameResponse{
        return lotteryService.generateLotteryGames(lotteryGameRequest)
    }

    @GetMapping("/api/hello")
    fun hello(): List<String>{
        return listOf("Oi","você")
    }

}