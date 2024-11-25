package com.example.myapplication

fun main() {
    println(birthdayGreeting("Ayoub"))
}

fun birthdayGreeting(name: String): String {
    val phrase1 = "happy birthday: $name"
    val phrase2 = "you are now 24 years old"
    return "$phrase1\n$phrase2"
}