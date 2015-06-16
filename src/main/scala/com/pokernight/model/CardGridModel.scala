package pokerNight.model

import pokerNight.exception.IllegalGridLocationException

class CardGridModel(width: Int, height: Int) {

    private var _cardGrid: Array[Array[Card]] = new Array[Array[Card]](width)
    for(i <- 0 to width - 1)
    {
        _cardGrid(i) = new Array[Card](height)
    }
     
    /*
    private var _conditionGrid: Array[Array[Boolean]] = new Array[Array[Boolean]](width)
    for(i <- 0 to width - 1)
    {
        _conditionGrid(i) = new Array[Boolean](height)
    }
    */
     
    def isValidLocation(x: Int, y: Int) : Boolean =
    {
        if(x < 0 || x > width || y < 0 || y > height)
            false
        else
            true
    }
    def dealCardToGrid(x: Int, y: Int, card: Card, up: Boolean) =
    {
        if(!isValidLocation(x, y))
            throw new IllegalGridLocationException("Illegal Grid Position")
        
        _cardGrid(x)(y) = card
         _cardGrid(x)(y)._up = up
    }
    
    def flipCard(x: Int, y: Int)
    {
        if(!isValidLocation(x, y))
            throw new IllegalGridLocationException("Illegal Grid Position")
        if( _cardGrid(x)(y) != null)
        _cardGrid(x)(y)._up = !_cardGrid(x)(y)._up
    }
    
    def getCurrentCards(): Array[Array[Card]] = {return _cardGrid}
    //def getCurrentConditions(): Array[Array[Boolean]] = {return _conditionGrid}
    
    override def toString = getCurrentStateAsString
        
    def getCurrentStateAsString: String =    
    {
        var currentGridState: String = ""
        
        for(x <- 0 to width - 1)
        {
            for(y <- 0 to height - 1)
            {
                var card = if(_cardGrid(x)(y) != null) (_cardGrid(x)(y)).toString else "Empty"
                var tabs = if(_cardGrid(x)(y) != null) "\t" else "\t\t\t"
                currentGridState = currentGridState + card  /*+ "(" + (if(_conditionGrid(x)(y)) "up" else "down") + ")"*/ + tabs
            }
            currentGridState = currentGridState + "\n"
        }
        
        return currentGridState
    }
    
    def getCardFromGrid(x: Int, y: Int) : Card =
    {
        if(isValidLocation(x,y)) _cardGrid(x)(y) else throw new IllegalGridLocationException("Illegal Grid Position")
    }
}