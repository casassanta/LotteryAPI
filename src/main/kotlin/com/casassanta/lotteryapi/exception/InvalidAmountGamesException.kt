package com.casassanta.lotteryapi.exception

class InvalidAmountGamesException(override val message: String = "Invalid amount of games for the lottery"): RuntimeException(message)