package com.casassanta.lotteryapi.controller

import com.casassanta.lotteryapi.controller.request.LotteryGameRequest
import com.casassanta.lotteryapi.service.LotteryService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class LotteryController(
    private val lotteryService: LotteryService
) {

    @PostMapping("/api/lotteries")
    fun generateLotteryGames(@RequestBody lotteryGameRequest: LotteryGameRequest): ArrayList<List<Int>>{
        return lotteryService.generateLotteryGames(lotteryGameRequest)
    }
}