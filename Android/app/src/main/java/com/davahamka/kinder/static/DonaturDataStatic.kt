package com.davahamka.kinder.static

data class Donatur(
    val no: Int,
    val name: String,
    val level: String,
    val image: String,
    val xp: Int
)

object DonaturDataStatic {
    val dataCard = listOf(
        Donatur(1, "Waluyo D Dragon", level = "Penyelamat Petani", xp = 10000 , image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSaXrFMnQrS3cdGFTB-UpG-5qMGMQyybPu7xg&usqp=CAU"),
        Donatur(2, "Andres Simanjutak", level = "Penyelamat Petani", xp = 10000 , image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRo3Ft30HIpU684AfuuHsIB4wXud5WauxkWwQ&usqp=CAU"),
        Donatur(3, "Caroline Cao", level = "Penyelamat Petani", xp = 10000 , image = "https://images.unsplash.com/photo-1597223557154-721c1cecc4b0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8ZmFjZXN8ZW58MHx8MHx8&w=1000&q=80"),

        Donatur(4, "Caroline Cao", level = "Penyelamat Petani", xp = 10000 , image = "https://images.unsplash.com/photo-1597223557154-721c1cecc4b0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8ZmFjZXN8ZW58MHx8MHx8&w=1000&q=80"),

        Donatur(5, "Caroline Cao", level = "Penyelamat Petani", xp = 10000 , image = "https://images.unsplash.com/photo-1597223557154-721c1cecc4b0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8ZmFjZXN8ZW58MHx8MHx8&w=1000&q=80"),

        Donatur(6, "Caroline Cao", level = "Penyelamat Petani", xp = 10000 , image = "https://images.unsplash.com/photo-1597223557154-721c1cecc4b0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8ZmFjZXN8ZW58MHx8MHx8&w=1000&q=80"),

        Donatur(7, "Caroline Cao", level = "Penyelamat Petani", xp = 10000 , image = "https://images.unsplash.com/photo-1597223557154-721c1cecc4b0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8ZmFjZXN8ZW58MHx8MHx8&w=1000&q=80"),
        Donatur(8, "Caroline Cao", level = "Penyelamat Petani", xp = 10000 , image = "https://images.unsplash.com/photo-1597223557154-721c1cecc4b0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8ZmFjZXN8ZW58MHx8MHx8&w=1000&q=80"),
    )
}