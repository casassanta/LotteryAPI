package com.casassanta.lotteryapi.controller.response

import com.casassanta.lotteryapi.model.enums.Lotteries

data class LotteryGameResponse(
    val lottery: Lotteries,
    val amountNumbers: Int,
    val numbers: List<Int>
)