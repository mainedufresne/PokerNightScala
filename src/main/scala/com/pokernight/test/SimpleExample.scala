package pokerNight.test

import scala.io._

case class Simple(val foo: String, val bar: List[String], val baz: Map[String,Int])

object SimpleExample {
  def main(args: Array[String]) {
    import com.codahale.jerkson.Json._
    val simpleJson = """{"foo":42, "bar":["a","b","c"], "baz":{"x":1,"y":2}}"""
    val simpleObject = parse[Simple](Source.fromFile("otherSimple.json"))
    println(simpleObject)
  }
}
