package pokerNight.model
	
class Card(suit: Suit, rank: Rank) extends scala.math.Ordered[Card] {
	
	var _suit: Suit = suit
	var _rank: Rank = rank
	var _up : Boolean = true
	var value = rank.rankValue.id | suit.suitValue.id
	
	def getSuit: Suit = { return suit }
	def getRank: Rank = { return rank }
	
	override def toString = _rank + "-" + _suit + "-" + value + "-" + (if(_up) "up" else "down")
	override def compare(that: Card) : Int= 
	{
	    if(this.rank.getValue > that.getRank.getValue)
	        return 1
	    else if(this.rank.getValue < that.getRank.getValue)
	        return -1
        else
        {
            if(this.suit.getValue > that.getSuit.getValue)
                return 1
            else if(this.suit.getValue < that.getSuit.getValue)
                return -1
            else
                return 0    
        }
	       
	}
}