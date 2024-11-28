package com.example.tuto7

//val rockPlanets = arrayOf<String>("Mercury", "Venus", "Earth", "Mars")
//
//val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")
//
//val solarSystem = rockPlanets + gasPlanets

fun main() {

//    val solarSystem = mutableSetOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    val solarSystem = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    solarSystem.add("Pluto")
    solarSystem.add(3, "Theia")

    println(solarSystem.get(3))

    solarSystem.removeAt(9)
    solarSystem.remove("Neptune")
//    solarSystem.remove("Venus")

    for (planet in solarSystem) {
        println(planet)
    }

    println(solarSystem.size)

    println(solarSystem.contains("Pluto"))
    println("Future Moon" in solarSystem)

    println("########")

    val solarSystem2 = mutableMapOf(
        "Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2,
        "Jupiter" to 79,
        "Saturn" to 82,
        "Uranus" to 27,
        "Neptune" to 14
    )

    println(solarSystem2.size)

    solarSystem2["Pluto"] = 5
    println(solarSystem2.size)

    println(solarSystem2["Pluto"])
    println(solarSystem2.get("Theia"))

    solarSystem2.remove("Pluto")

    solarSystem2["Jupiter"] = 78
    println(solarSystem2["Jupiter"])
}