package com.davahamka.kinder.domain.repository

interface DonateRepository {

    suspend fun insertDonate()

    suspend fun getDonateById()

    suspend fun getAllDonate()

    suspend fun updateDonate()
}