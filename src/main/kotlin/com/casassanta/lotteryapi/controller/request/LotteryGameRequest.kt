package com.casassanta.lotteryapi.controller.request

import com.fasterxml.jackson.annotation.JsonAlias

data class LotteryGameRequest(
    val lottery: String,

    @JsonAlias("amount_numbers")
    val amountNumbers: Int,

    @JsonAlias("amount_games")
    val amountGames: Int
)

