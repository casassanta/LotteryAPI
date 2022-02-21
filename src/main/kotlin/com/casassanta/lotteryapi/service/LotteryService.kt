package com.casassanta.lotteryapi.service

import com.casassanta.lotteryapi.controller.request.LotteryGameRequest
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class LotteryService {

    fun generateLotteryGames(lotteryGameRequest: LotteryGameRequest): List<Int>{

        if(lotteryGameRequest.lottery == "MEGASENA"){
            return generateMegaSena(lotteryGameRequest.amountNumbers)
        }

        return emptyList()
    }


    private fun generateMegaSena(amountNumbers: Int): List<Int> {
        return List(amountNumbers) { Random.nextInt(1,60)}
    }

}