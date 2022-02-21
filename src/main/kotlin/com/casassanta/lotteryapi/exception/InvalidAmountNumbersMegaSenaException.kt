package com.casassanta.lotteryapi.exception

class InvalidAmountNumbersMegaSenaException(override val message: String = "Invalid amount of numbers for MegaSena games"): RuntimeException(message)