package com.casassanta.lotteryapi.service

import com.casassanta.lotteryapi.controller.request.LotteryGameRequest
import com.casassanta.lotteryapi.exception.InvalidAmountGamesException
import com.casassanta.lotteryapi.exception.InvalidAmountNumbersMegaSenaException
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class LotteryService {

    fun generateLotteryGames(lotteryGameRequest: LotteryGameRequest): ArrayList<List<Int>>{

        if(lotteryGameRequest.lottery == "MEGASENA"){
            return generateMegaSena(lotteryGameRequest.amountNumbers, lotteryGameRequest.amountGames)
        }

        return ArrayList()
    }


    private fun generateMegaSena(amountNumbers: Int, amountGames: Int): ArrayList<List<Int>> {
        val games = ArrayList<List<Int>>()

        println(amountNumbers)
        println(amountGames)

        if(amountNumbers in 6..15){
            if(amountGames > 0) {
                for (i in 1..amountGames) {
                    games.add(List(amountNumbers) { Random.nextInt(1, 60) })
                }
                return games
            }
            else throw InvalidAmountGamesException()
        }
        else throw InvalidAmountNumbersMegaSenaException()
    }

}