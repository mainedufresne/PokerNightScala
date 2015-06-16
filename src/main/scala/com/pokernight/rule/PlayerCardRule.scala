package pokerNight.rule

case class PlayerCardRule(val numberOfCardsPerDeal : Seq[String], val numberOfCardsDrawnPerDeal : Option[Seq[String]], val numberOfCardsDroppedPerDeal : Option[Seq[Int]]) {

    /**
     * Returns a two element array where first element is how many down cards to deal, and second element is how many up cards to deal
     */
    def getNumberToDealForRound(round : Int) : Seq[Int] =
    {
        var numToDeal : Array[Int] = Array(0, 0)
        if(round < numberOfCardsPerDeal.length)
        {
            var tokens = numberOfCardsPerDeal(round).split(",")
            for (roundTokens <- tokens)
            {
                var dealTokens : Array[String] = roundTokens.split("-")
                
                var number = dealTokens(0).toInt
                if(number != 0)
                {
                    var condition : String = dealTokens(1)
                    if(condition == "d")
                        numToDeal(0) += number.toInt
                    else if(condition == "u")
                        numToDeal(1) += number.toInt
                    else
                        println("A condtion other than 'd' or 'u' found in player Rules!")
                }
            }
        }
        return numToDeal
    }
    
}