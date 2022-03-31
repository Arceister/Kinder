package com.davahamka.kinder.static

data class Message(
    val image: String,
    val name: String,
    val text: String,
)

object messageDataStatic {
    val dataCard = listOf(
        Message("https://images.unsplash.com/photo-1597223557154-721c1cecc4b0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8ZmFjZXN8ZW58MHx8MHx8&w=1000&q=80", "Yuli", "Sama-sama mas"),
        Message("https://images.unsplash.com/photo-1597223557154-721c1cecc4b0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8ZmFjZXN8ZW58MHx8MHx8&w=1000&q=80", "Dea", "Oke mas"),
        Message("https://images.unsplash.com/photo-1597223557154-721c1cecc4b0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8ZmFjZXN8ZW58MHx8MHx8&w=1000&q=80", "Alvita", "Hello!"),
    )
}