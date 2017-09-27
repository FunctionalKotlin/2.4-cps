// Copyright © FunctionalKotlin.com 2017. All rights reserved.

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch
import java.util.*

class Model {
    fun count(f: (Int) -> Unit) {
        async {
            f(Random().nextInt(10))
        }
    }
}

fun main(args: Array<String>) {
    val model = Model()

    model.count { count ->
        if (count == 0) {
            println("We don't have data")
        } else {
            println("We have $count items")
        }
    }

    Thread.sleep(1000)
}

fun async(completion: () -> Unit) {
    launch(CommonPool) {
        completion()
    }
}