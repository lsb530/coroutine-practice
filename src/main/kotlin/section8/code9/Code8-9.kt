package section8.code9

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
    println("[예외 발생] ${throwable}")
  }
  CoroutineScope(context = exceptionHandler).launch(CoroutineName("Coroutine1")) {
    launch(CoroutineName("Coroutine2")) {
      throw Exception("Coroutine2에 예외가 발생했습니다")
    }
  }
  delay(1000L)
}