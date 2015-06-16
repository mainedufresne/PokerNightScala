package pokerNight.model

import scala.io._
import scala.collection.mutable.ArrayBuffer
import pokerNight.rule._
import com.codahale.jerkson.Json._

class GameModel(deck: DeckModel, players: Array[PlayerModel], ruleFile: String) {

    private var _wilds: Array[Card] = null
    
    //Parse com.pokernight.rule file
    val gameRules = parse[GameRules](Source.fromFile(ruleFile).mkString);
    println("Game Rules Parsed Successfully")
    
    val playerRules = gameRules.playerCardRule
    val communityRules = if(gameRules.communityCardRule.isDefined) gameRules.communityCardRule.get else null
    val specialRules =  if(gameRules.specialCardRules.isDefined) gameRules.specialCardRules.get else null
    
    //Initialize Card Grid
    
    private var _cardGrid = new CardGridModel(7,7)
    
    def numberOfRounds = gameRules.rounds 
    var playerState : String = ""
    def state = _cardGrid.toString + "\n" + playerState
    private var _round = 0
    
    def dealRoundCards() = 
    {
        //Refer to com.pokernight.rule for next card location

        println("gameRule.rounds i: " + _round)
        
        //deal cards to players
        //down cards
        for(deals <- 0 to (playerRules.getNumberToDealForRound(_round))(0) - 1)
        {
            for(j <- 0 to players.length - 1)
            {
                var card = deck.drawCard
                card._up = false
                println("Dealing " + card + " to " + players(j)._name)
                players(j).receiveCard(card)

                for(rule <- specialRules)
                {
                    if(rule.card == card)
                        players(j).applyAction(rule.cardActiionValue)
                }
                
            }
        }
        //Up cards
        for(deals <- 0 to (playerRules.getNumberToDealForRound(_round))(1) - 1)
        {
            for(j <- 0 to players.length - 1)
            {
                var card = deck.drawCard
                card._up = true
                println("Dealing " + card + " to " + players(j)._name)
                players(j).receiveCard(card)
            }
        }
        
        if(communityRules != null)
        {
            var numberToDeal = communityRules.getNumberToDealForRound(_round)
            println("numberToDeal: " + numberToDeal)
            var dealUp = communityRules.getConditionToDealForRound(_round)
            println("dealUp: " + dealUp)
            for(k <- 0 to numberToDeal.length - 1)
            {
                for(l <- 1 to numberToDeal(k) )
                {
                    var dealLocation = communityRules.getNextDealLocation()
                    if(dealLocation != null)
                    {
                        var x = dealLocation(0)
                        var y = dealLocation(1)
                        var up = dealUp(k)
                        _cardGrid.dealCardToGrid(x, y, deck.drawCard, up)
                    }
                }
            }
        }
        playerState = ""
        for(player <- players){playerState += player._name + " has " + player.getHandAsString + "\n"}
        
       
        //Deal card
        
        //Any special action?
        
        //Prompt for bets (Rotating, Standard)
        
        //Showdown?
        _round = _round + 1
        
    }
    
    private def getBestHand(hand : Array[Card]) : Int =
    {
        var totalHand : ArrayBuffer[Card] = new ArrayBuffer[Card](7)
        for(card <- hand)
            totalHand += card
        var bestHandValue = 8000;
        for(cardCollection <- communityRules.communityCardCollection)
            {
                cardCollection.resetNext
                while(cardCollection.hasNext)
                {
                    var cardGridLocation = cardCollection.getNextGridLocation()
                    var currentCard = _cardGrid.getCardFromGrid(cardGridLocation.getX().toInt, cardGridLocation.getY().toInt)
                    totalHand += currentCard
                }
                var handValue = HandEvaluator.evaluateBestFiveCardHand(totalHand.toArray)
                if(handValue < bestHandValue)
                    bestHandValue = handValue
            }
        
        return bestHandValue
        
    }
    
    var _winningPlayer : PlayerModel = null
    var _winningHand : Int = 8000
    
    def showdown() : PlayerModel =
    {
        var winningPlayer : PlayerModel = players(0)
        var winningHandValue = 8000
        for(player <- players)
        {
            var curHandValue = getBestHand(player.getHand())
            if(curHandValue < winningHandValue)
            {
                winningHandValue = curHandValue
                winningPlayer = player
            }
        }
        _winningPlayer = winningPlayer
        _winningHand = winningHandValue
        return winningPlayer
    }
 
     
    
}