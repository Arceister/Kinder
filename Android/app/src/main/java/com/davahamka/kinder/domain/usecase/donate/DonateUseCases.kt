package com.davahamka.kinder.domain.usecase.donate

data class DonateUseCases(
    val insertDonate: InsertDonate,
    val getAllDonate: GetAllDonate,
    val getDonateById: GetDonateById,
)
