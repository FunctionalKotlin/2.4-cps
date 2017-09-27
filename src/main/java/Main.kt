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

fun isEmpty(model: Model, onTrue: () -> Unit, onFalse: (Int) -> Unit) {
    model.count { count ->
        if (count == 0) {
            onTrue()
        } else {
            onFalse(count)
        }
    }
}

fun main(args: Array<String>) {
    val model = Model()

    isEmpty(model, { println("We don't have data") }, { println("We have $it items") })

    Thread.sleep(1000)
}

fun async(completion: () -> Unit) {
    launch(CommonPool) {
        completion()
    }
}