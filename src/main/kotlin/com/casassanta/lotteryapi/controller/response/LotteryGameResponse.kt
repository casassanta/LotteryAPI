package com.casassanta.lotteryapi.controller.response

import com.casassanta.lotteryapi.model.enums.Lotteries
import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonProperty

data class LotteryGameResponse(
    val lottery: Lotteries,

    @JsonProperty("amount_numbers")
    val amountNumbers: Int,

    @JsonProperty("amount_games")
    val amountGames: Int,

    val games: List<List<Int>>
)