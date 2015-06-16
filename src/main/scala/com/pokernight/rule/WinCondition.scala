package pokerNight.rule

import pokerNight.model.Rank

case object Condition extends Enumeration {
      type Condition = Value
      val HighHand, LowBall, BackToBack, SuitHighCard, SuitLowCard = Value   
}
case class WinCondition (val condition: String, val potPercentage : Double, val rank : Option[Rank]/*Option[String]*/, val suit : Option[String], val requiredDown : Option[Boolean]){

    /*
    var cardRank : Rank = null
    if(rank.isDefined)
     cardRank = rank.get//Rank.withName(rank.get)
     */
}