package pokerNight.test

import com.codahale.jerkson.Json._
import pokerNight.rule._
import pokerNight.model._
import scala.io._
import scala.Exception
import pokerNight.model.RankEnum$
import pokerNight.model.RankEnum

object GameModelTester {
  def main(args: Array[String]) {

       var deck = new DeckModel()
       var players = new Array[PlayerModel](2)
       players(0) = new PlayerModel("Jon", 50)
       players(1) = new PlayerModel("Busby", 50)
       var ruleFile = "simple.json"
       var gameModel = new GameModel(deck, players, ruleFile)
       
       for(i <- 1 to gameModel.numberOfRounds)
       {
           gameModel.dealRoundCards()
           print(gameModel.state)
       }
       
       var winningPlayer = gameModel.showdown()
       println(winningPlayer._name + " wins with a " + HandNameTable.handNames(gameModel._winningHand -1) + "!")
       
       

  }
}