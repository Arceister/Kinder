package com.davahamka.kinder.domain.usecase.donate

import com.davahamka.kinder.domain.repository.DonateRepository

class GetAllDonate(private val repository: DonateRepository) {
    suspend operator fun invoke() {
        repository.getAllDonate()
    }
}