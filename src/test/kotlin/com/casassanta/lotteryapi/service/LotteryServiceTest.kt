package com.casassanta.lotteryapi.service

import com.casassanta.lotteryapi.controller.request.LotteryGameRequest
import com.casassanta.lotteryapi.exception.InvalidAmountGamesException
import com.casassanta.lotteryapi.exception.InvalidAmountNumbersMegaSenaException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class LotteryServiceTest{

    private val lotteryService = LotteryService()

    @Nested
    inner class MegaSena {

        @Test
        fun `should return megasena numbers properly`() {

            val lotteryGameRequest = LotteryGameRequest(
                "MEGASENA",
                6,
                2
            )

            val results = lotteryService.generateLotteryGames(lotteryGameRequest)

            assertThat(results.games.size).isEqualTo(lotteryGameRequest.amountGames)
            results.games.forEach { game ->
                assertThat(game.size).isEqualTo(lotteryGameRequest.amountNumbers)
                game.map { number ->
                    assertThat(number).isBetween(0, 60)
                }
            }
        }

        @Test
        fun `should return exception if megasena numbers are invalid`() {
            val lotteryGameRequest = LotteryGameRequest(
                "MEGASENA",
                5,
                2
            )

            assertThrows(InvalidAmountNumbersMegaSenaException::class.java) {
                lotteryService.generateLotteryGames(
                    lotteryGameRequest
                )
            }
        }

        @Test
        fun `should return exception if megasena games are invalid`() {
            val lotteryGameRequest = LotteryGameRequest(
                "MEGASENA",
                6,
                0
            )

            assertThrows(InvalidAmountGamesException::class.java) {
                lotteryService.generateLotteryGames(
                    lotteryGameRequest
                )
            }
        }

    }

}