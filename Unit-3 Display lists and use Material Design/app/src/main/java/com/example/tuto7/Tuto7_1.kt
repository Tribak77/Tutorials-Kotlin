package com.example.tuto7

//Generics in Kotlin allow you to create classes, methods, and interfaces
// that work with any type while ensuring type safety at compile time.
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

enum class Difficulty {
    EASY, MEDIUM, HARD
}

//class Quiz {
//    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
//    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
//    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)


////    In Kotlin, object is used to create a singleton
////    or an anonymous object. It ensures a class has only one instance.

//    companion object StudentProgress {
//        var total: Int = 10
//        var answered: Int = 3
//    }
//}


////Kotlin provides a way to add new functionalities to existing
//// classes using extensions without modifying their source code.

//val Quiz.StudentProgress.progressText: String
//    get() = "${answered} of ${total} answered"
//
//fun Quiz.StudentProgress.printProgressBar(){
//    repeat(Quiz.answered) { print("▓") }
//    repeat(Quiz.total - Quiz.answered) { print("▒") }
//    println()
//    println(Quiz.progressText)
//}


//Interfaces allow for variation in the behavior of classes
// that extend them. It's up to each class to provide the implementation.

interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

class Quiz : ProgressPrintable {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }

    override val progressText: String
        get() = "${answered} of ${total} answered"

    override fun printProgressBar() {
        repeat(Quiz.answered) { print("▓") }
        repeat(Quiz.total - Quiz.answered) { print("▒") }
        println()
        println(progressText)
    }
      companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }
}

fun main() {
//    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
//    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
//    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

//    println(question1)
//    println(question2)
//    println(question3)

//    println("${Quiz.answered} of ${Quiz.total} answered.")

//    println(Quiz.progressText)

//    Quiz.printProgressBar()

//    Quiz().printProgressBar()

    val quiz = Quiz()
    quiz.printQuiz()
}