package com.davahamka.kinder.data.repository

import com.davahamka.kinder.data.api.KinderApi
import com.davahamka.kinder.domain.repository.PredictRepository
import javax.inject.Inject

class PredictRepositoryImpl @Inject constructor(
    val api: KinderApi
): PredictRepository {
    override suspend fun predictImage() {
        return api.predictImage()
    }
}