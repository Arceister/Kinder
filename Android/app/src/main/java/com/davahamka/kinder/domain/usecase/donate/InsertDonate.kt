package com.davahamka.kinder.domain.usecase.donate

import com.davahamka.kinder.domain.repository.DonateRepository

class InsertDonate (private val repository: DonateRepository) {
    suspend operator fun invoke() {
        repository.insertDonate()
    }
}