package com.davahamka.kinder.domain.repository

interface PredictRepository {
    suspend fun predictImage()
}