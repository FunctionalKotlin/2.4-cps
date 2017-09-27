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

fun whenEmpty(model: Model, onTrue: () -> Unit, otherwise: (Int) -> Unit) {
    model.count { count ->
        if (count == 0) {
            onTrue()
        } else {
            otherwise(count)
        }
    }
}

fun main(args: Array<String>) {
    val model = Model()

    whenEmpty(model, { println("We don't have data") }, otherwise = { println("We have $it items") })

    Thread.sleep(1000)
}

fun async(completion: () -> Unit) {
    launch(CommonPool) {
        completion()
    }
}