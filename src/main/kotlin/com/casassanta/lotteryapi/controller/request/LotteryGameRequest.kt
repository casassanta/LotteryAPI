package com.casassanta.lotteryapi.controller.request

import com.casassanta.lotteryapi.controller.response.LotteryGameResponse
import com.casassanta.lotteryapi.model.enums.Lotteries
import com.fasterxml.jackson.annotation.JsonAlias

data class LotteryGameRequest(
    val lottery: String,

    @JsonAlias("amount_numbers")
    val amountNumbers: Int,

    @JsonAlias("amount_games")
    val amountGames: Int
){
    fun toLotteryGameResponse(games: List<List<Int>>): LotteryGameResponse {
        return LotteryGameResponse(
            lottery = Lotteries.valueOf(this.lottery),
            amountNumbers = this.amountNumbers,
            amountGames = this.amountGames,
            games = games
        )
    }
}

