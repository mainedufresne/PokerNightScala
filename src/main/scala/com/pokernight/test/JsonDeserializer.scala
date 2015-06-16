package pokerNight.test

import com.codahale.jerkson.Json._
import pokerNight.rule._

import scala.io._
import scala.Exception

object CommunityCardRuledDeserializer {
   def main(args: Array[String]) {
       /*
       try
       {
       */
       val gameRules = parse[GameRules](Source.fromFile("simple.json").mkString);
       println(gameRules)
       println(generate(gameRules))
       /*
       }
       catch
       {
           case e: Exception => {
               var stackTrace = e.getStackTrace
               for(i <- 0 to stackTrace.length - 1) {println(stackTrace(i))}   
           }
       }
       */
   }
}