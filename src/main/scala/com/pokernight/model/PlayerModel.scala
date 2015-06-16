package pokerNight.model

import scala.collection.mutable.ArrayBuffer
import pokerNight.exception.IllegalBetException
import pokerNight.rule.CardActionEnum

class PlayerModel(name: String, chips: Float) {

    var _name = name
    private var _chips = chips;
    private var _hand: ArrayBuffer[Card] = new ArrayBuffer[Card](2)
    
    def receiveCard(card: Card) =
    {
        if(card != null)
            _hand += card
    }
    
    def bet(amount: Float) =
    {
        if(_chips - amount < 0)
            throw new IllegalBetException("Insufficient Chips!")
        else
            _chips -= amount
    }
    
    def getChipsLeft(): Float = {return _chips}
    
    def getHand() : Array[Card] =
    {
        return _hand.toArray
    }
    
    def getHandAsString() : String =
    {
        var hand : String = ""
        for(card <- _hand)
            hand += card + " "
        return hand
    }
    
    def applyAction(action : CardActionEnum.Value) = 
    {

    }
    
    override def toString = "Name: " + name + " has " + _chips
}