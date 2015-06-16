package pokerNight.rule

import java.lang.IndexOutOfBoundsException

case class CommunityCardRule(val name: String, val dealRule: Seq[String], val gridDealOrder: Seq[String], val communityCardCollection: Seq[CommunityCardCollection]) {

    def getNumberToDealForRound(round: Int) : Seq[Int] = 
    {
        var cardsToDeal : Array[Int] = null
        try
        {
            var tokens = dealRule(round).split(",")
            cardsToDeal = new Array[Int](tokens.length)
            println("numDeal round length: " + tokens.length)
            for(i <- 0 to tokens.length - 1)
            {
                println("cardsToDeal length: " + cardsToDeal.length)
                println("tokens length: " + tokens.length)
                cardsToDeal(i) = tokens(i).split("-")(0).toInt
            }
        }
        catch        
        {
            //No more rounds defined so nothing to deal
            case e: IndexOutOfBoundsException =>
                cardsToDeal = new Array[Int](1)
                cardsToDeal(0) = 0;
        }
        return cardsToDeal
    }
    
    def getConditionToDealForRound(round: Int) : Seq[Boolean] =
    {
        var howToDeal : Array[Boolean] = null
        try
        {
             var tokens = dealRule(round).split(",")
             howToDeal = new Array[Boolean](tokens.length)
             println("cond round length: " + tokens.length)
             for(i <- 0 to tokens.length - 1)
             {
                 if(tokens(i).split("-").length > 1)
                 {
                     var conditionIndicator = tokens(i).split("-")(1)
                     howToDeal(i) = (conditionIndicator == "u")
                 }
                 else
                     howToDeal(i) = false
             }
        }
        catch
        {
            case e: IndexOutOfBoundsException =>
                howToDeal = new Array[Boolean](1)
                howToDeal(0) = false
        }
         return howToDeal
    }
    
    var cardNumber = 0;
    def getNextDealLocation() : Seq[Int] =
    {
        try
        {
           var nextLocationTokens = gridDealOrder(cardNumber).split("-")
           var x = nextLocationTokens(0).toInt
           var y = nextLocationTokens(1).toInt
           cardNumber = cardNumber + 1
           return Array(x,y)
        }
        catch 
        {
        case e: IndexOutOfBoundsException => 
            return null
        }
    }
    
}