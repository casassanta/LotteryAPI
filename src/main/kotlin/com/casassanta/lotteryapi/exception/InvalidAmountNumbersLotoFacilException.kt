package com.casassanta.lotteryapi.exception

class InvalidAmountNumbersLotoFacilException(override val message: String = "Invalid amount of numbers for LotoFacil games"): RuntimeException(message)