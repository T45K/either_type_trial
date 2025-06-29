package io.github.t45k.either_trial

import arrow.core.EitherNel
import arrow.core.Nel
import arrow.core.left
import arrow.core.nonEmptyListOf
import arrow.core.raise.either
import arrow.core.raise.zipOrAccumulate

fun main() {
    println(incorrectBehavior()) // Either.Left(NonEmptyList(1))
    println(correctBehavior()) // Either.Left(NonEmptyList(NonEmptyList(1), NonEmptyList(1)))
}

fun incorrectBehavior(): EitherNel<String, Unit> = either {
    zipOrAccumulate(
        { validateList().bind() }, // this bind is dispatched to `Raise` of not `zipOrAccumulate` but `either`
        { validateList().bind() },
    ) { _, _ -> }
}

fun correctBehavior(): EitherNel<Nel<String>, Unit> = either {
    zipOrAccumulate(
        { validateList().bind() },
        { validateList().bind() }
    ) { _, _ -> }
}

fun validateList(): EitherNel<String, Unit> = nonEmptyListOf("1").left()
