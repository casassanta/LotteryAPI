package com.casassanta.lotteryapi.service

import com.casassanta.lotteryapi.controller.request.LotteryGameRequest
import com.casassanta.lotteryapi.controller.response.LotteryGameResponse
import com.casassanta.lotteryapi.exception.InvalidAmountGamesException
import com.casassanta.lotteryapi.exception.InvalidAmountNumbersLotoFacilException
import com.casassanta.lotteryapi.exception.InvalidAmountNumbersMegaSenaException
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class LotteryService {

    fun generateLotteryGames(lotteryGameRequest: LotteryGameRequest): LotteryGameResponse {

        if(lotteryGameRequest.lottery == "MEGASENA"){
            if(isValidMegaSena(lotteryGameRequest.amountNumbers, lotteryGameRequest.amountGames))
                return lotteryGameRequest.toLotteryGameResponse(
                    generateGames(
                        lotteryGameRequest.amountNumbers,
                        lotteryGameRequest.amountGames,
                        1,
                        60
                    )
                )
        }
        if(lotteryGameRequest.lottery == "LOTOFACIL"){
            if(isValidLotoFacil(lotteryGameRequest.amountNumbers, lotteryGameRequest.amountGames))
                return lotteryGameRequest.toLotteryGameResponse(
                    generateGames(
                        lotteryGameRequest.amountNumbers,
                        lotteryGameRequest.amountGames,
                        1,
                        26
                    )
                )
        }

        return lotteryGameRequest.toLotteryGameResponse(emptyList())
    }

    private fun isValidMegaSena(amountNumbers: Int, amountGames: Int): Boolean{
        if(amountNumbers in 6..15)
            if(amountGames > 0)
                return true
            else
                throw InvalidAmountGamesException()
        else
            throw InvalidAmountNumbersMegaSenaException()

        return false
    }

    private fun isValidLotoFacil(amountNumbers: Int, amountGames: Int): Boolean{
        if(amountNumbers in 15..18)
            if(amountGames > 0)
                return true
            else
                throw InvalidAmountGamesException()
        else
            throw InvalidAmountNumbersLotoFacilException()

        return false
    }

    private fun generateGames(amountNumbers: Int, amountGames: Int, rangeMin: Int, rangeMax: Int): ArrayList<List<Int>> {
        val games = ArrayList<List<Int>>()

        for (i in 1..amountGames) {
            games.add(List(amountNumbers) { Random.nextInt(rangeMin, rangeMax) })
        }
        return games
    }

}