package pokerNight.test

import pokerNight.model._

object HandEvaulatorTester {

    def main(args: Array[String]): Unit = 
    {
        var deck = new DeckModel()
        deck.shuffle
        var hand1 = new Array[Card](5)
        var hand2 = new Array[Card](5)
        
        var busbyCards = ""
        var rossCards = ""
            
        for(i <- 0 to 4)
        {
            hand1(i) = deck.drawCard();
            busbyCards += hand1(i) + " "
            hand2(i) = deck.drawCard();
            rossCards += hand2(i) + " "
        }
        
        var hand1Value = HandEvaluator.evaluateBestFiveCardHand(hand1)
        var hand2Value = HandEvaluator.evaluateBestFiveCardHand(hand2)
             
            
        println("Busby's Cards: " + busbyCards)
        println("Busby's Value: " + hand1Value)
        
        println("Ross' Cards:" + rossCards)
        println("Ross' Cards: " + hand2Value)
        
        if(hand1Value < hand2Value)
            println("Busby's " + HandEvaluator.getHandRankAsString(HandEvaluator.getHandRank(hand1Value)) + " beats Ross' "  + HandEvaluator.getHandRankAsString(HandEvaluator.getHandRank(hand2Value)) )
        else
            println("Ross' " +  HandEvaluator.getHandRankAsString(HandEvaluator.getHandRank(hand2Value))  + " beats Busby's " + HandEvaluator.getHandRankAsString(HandEvaluator.getHandRank(hand1Value)))
        
    }

}