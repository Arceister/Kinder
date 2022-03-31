package com.davahamka.kinder.data.repository

import com.davahamka.kinder.data.api.KinderApi
import com.davahamka.kinder.domain.repository.DonateRepository
import javax.inject.Inject

class DonateRepositoryImpl @Inject constructor(
    private val api: KinderApi
): DonateRepository {

    override suspend fun insertDonate() {
        return api.insertDonate()
    }

    override suspend fun getDonateById() {
        return api.getDonateById()
    }

    override suspend fun getAllDonate() {
        return api.getAllDonate()
    }

    override suspend fun updateDonate() {
        return api.updateDonate()
    }

}