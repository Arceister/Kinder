package com.davahamka.kinder.domain.model


data class GetAllDonateResponse(
    val id: Int,
    val User: String?,
    val judul: String,
    val gambar: String,
    val deskripsi: String,
    val jenisProduk: String,
    val kuantitas: Int,
    val aktivitas: Boolean,
    val createdAt: String,
    val lat: Double,
    val lng: Double
)
