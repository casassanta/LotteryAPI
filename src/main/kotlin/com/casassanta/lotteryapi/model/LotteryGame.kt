package com.casassanta.lotteryapi.model

import com.casassanta.lotteryapi.model.enums.Lotteries

data class LotteryGame(
    val lottery: Lotteries,
    val amountNumbers: Int,
    val numbers: List<Int>
)
