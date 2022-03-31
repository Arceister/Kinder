package com.davahamka.kinder.domain.model

data class InsertDonateRequest(
    val judul: String,
    val deskripsi: String,
    val jenisProduk: String,
    val kuantitas: Int,
    val aktivitas: Boolean,
    val distribusi: Boolean,
    val lat: Double,
    val lng: Double
    )