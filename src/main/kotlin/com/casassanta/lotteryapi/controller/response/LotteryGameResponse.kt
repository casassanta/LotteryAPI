package com.casassanta.lotteryapi.controller.response

import com.casassanta.lotteryapi.model.enums.Lotteries

data class LotteryGameResponse(
    val lottery: Lotteries,
    val amountNumbers: Int,
    val amountGames: Int,
    val numbers: List<List<Int>>
)