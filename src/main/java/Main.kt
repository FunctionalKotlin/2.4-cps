// Copyright © FunctionalKotlin.com 2017. All rights reserved.

import java.util.*

class Model {
    fun count(): Int = Random().nextInt(10)
}

fun main(args: Array<String>) {
    val model = Model()

    if (model.count() == 0) {
        println("We don't have data")
    } else {
        println("We have ${model.count()} items")
    }
}