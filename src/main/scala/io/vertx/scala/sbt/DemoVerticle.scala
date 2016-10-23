package io.vertx.scala.sbt

import io.vertx.lang.scala.ScalaVerticle

class DemoVerticle extends ScalaVerticle {

  override def start(): Unit = {
    vertx
      .createHttpServer()
      .requestHandler(_.response().end("Hello World"))
      .listen(8666)

    vertx.eventBus().consumer("hallo", a => println(a.body())).completionFuture()
  }
}
