package pokerNight.model

object HandEvaluator {

    private def findFast(value: Int) : Int =
    {
    
        //println("ValuePassed: " +  (/* 0xFFFFFFFF ^*/ value) )
    var u : Int = (value + 0x00000000e91aaa35);
    //println("u1: " + u)
    printIntBinary(0x00000000e91aaa35)
    printIntBinary(u)
    //println("u >>>> 16: " + (u >>> 16))
    u =  u ^ (u >>> 16) ;
    //println("u2: " + u)
    u = u + (u << 8);
    //println("u3: " + u)
    u = u ^ (u >>> 4);
    //println("u4: " + u)
    var b : Int = ((u >>> 8) & 0x1ff);
    //println("b: " + b)
    var a : Int = (u + (u << 2)) >>> 19;
    //println("a: " + a)
    //println("HashAdjust[b]: " + HandHashTable.hashAdjust(b.toInt))
    var r : Int = (a ^ HandHashTable.hashAdjust(b.toInt));
    //println("r: " + r)
    return r;
    }
    
    private def evaluate5HandFast(hand: Array[Int]) : Int =
    {
        var c1 : Int = hand(0)
        //println("C1:")
        printIntBinary(c1)
        var c2 : Int= hand(1)
        //println("C2:")
        printIntBinary(c2)
        var c3 : Int= hand(2)
        //println("C3:")
        printIntBinary(c3)
        var c4 : Int= hand(3)
        //println("C4:")
        printIntBinary(c4)
        var c5 : Int= hand(4)
        //println("C5:")
        printIntBinary(c5)
        var q  : Int = (c1 | c2 | c3 | c4 | c5) >>> 16
        //println("OR: " + (c1 | c2 | c3 | c4 | c5))
        printIntBinary((c1 | c2 | c3 | c4 | c5))
        //println("Shifted: " + q)
        var s = UniqueArray.unique5(q)
        //println("s: " + s)
        var handValue : Int = c1 & c2 & c3 & c4 & c5 & 0xf000
        //println("HandValue: " + handValue)
        if (handValue != 0)   return FlushArray.flushes(q.toInt); // check for flushes and straight flushes
        if (s != 0) return s;          // check for straights and high card hands
        //println("Card Values: " + (c1 & 0xff) + " " +  (c2 & 0xff)  + " " +   (c3 & 0xff)  + " " +   (c4 & 0xff)  + " " +   (c5 & 0xff) + " = " + ((c1 & 0xff) * (c2 & 0xff) * (c3 & 0xff) * (c4 & 0xff) * (c5 & 0xff)))
        var handHashIndex = findFast( (((c1 & 0xff) * (c2 & 0xff) * (c3 & 0xff) * (c4 & 0xff) * (c5 & 0xff))))
        //println("handHashIndex: " + handHashIndex)
        //println("hashValuesLength: " + HashValueTable.hashValues.length)
        var totalValue : Int = HashValueTable.hashValues(handHashIndex);
        //println("Total Value: " + totalValue)
        return totalValue
    }

    val ROYAL_FLUSH : Int =  1
    val STRAIGHT_FLUSH : Int =  2
    val FOUR_OF_A_KIND : Int = 3
    val FULL_HOUSE : Int = 4
    val FLUSH      : Int = 5
    val STRAIGHT   : Int = 6
    val THREE_OF_A_KIND : Int = 7
    val TWO_PAIR   : Int  = 8
    val ONE_PAIR   : Int  = 9
    val HIGH_CARD  : Int  = 10

    def getHandRank(value: Int) : Int = 
    {
        if (value > 6185) return(HIGH_CARD);        // 1277 high card
        if (value > 3325) return(ONE_PAIR);         // 2860 one pair
        if (value > 2467) return(TWO_PAIR);         //  858 two pair
        if (value > 1609) return(THREE_OF_A_KIND);  //  858 three-kind
        if (value > 1599) return(STRAIGHT);         //   10 straights
        if (value > 322)  return(FLUSH);            // 1277 flushes
        if (value > 166)  return(FULL_HOUSE);       //  156 full house
        if (value > 10)   return(FOUR_OF_A_KIND);   //  156 four-kind
        if (value > 1)   return(STRAIGHT_FLUSH);   //  10 straight-flushes
        return(ROYAL_FLUSH);                   //   1 royal-flushes
    }
    
    def getHandRankAsString(index: Int) : String =
    {
        index match  
        {
            case ROYAL_FLUSH => return "royal flush"
            case STRAIGHT_FLUSH  => return "straight flush"
            case FOUR_OF_A_KIND => return "four of a kind"
            case FULL_HOUSE => return "full house"
            case FLUSH      => return "flush"
            case STRAIGHT   => return "stright"
            case THREE_OF_A_KIND => return "three of a kind"
            case TWO_PAIR    => return "two pair"
            case ONE_PAIR    => return "one pair"
            case HIGH_CARD   => return "high card"
        }
        
        return ""
    }
    /*
    def getCombinations(cards: Array[Card]) : List[List[Card]] =
    {
            var size = cards.length
            for(startIndex <- 0 to size - 5)
            {
                
            }
                
    }
    */
    
    def evaluateBestFiveCardHand(hand: Array[Card]) : Int =
    {
        //Get all possible 5 card hands
        //println("Hand length: " + hand.length)
        var cardValues : Array[Int] = new Array[Int](5)
        var bestHandValue = 8000 //worst than worst
        for(i <- 0 to hand.length - 5)
            for(j <- i+1 to hand.length - 4)
                for(k <- j+1 to hand.length - 3)
                    for(l <- k+1 to hand.length - 2)
                        for(m <- l+1 to hand.length -1 )
                        {
                            cardValues(0) = hand(i).value
                            cardValues(1) = hand(j).value
                            cardValues(2) = hand(k).value
                            cardValues(3) = hand(l).value
                            cardValues(4) = hand(m).value
                            var returnedValue = evaluate5HandFast(cardValues)
                            //println("Returned Value: " + returnedValue)
                            if(returnedValue < bestHandValue)
                                bestHandValue = returnedValue
                        }
        //println("BestHandValue: " + bestHandValue)
        return bestHandValue
    }
    
    def printIntBinary(value : Long) =
    {
        //println("binValue: " + value)
        var binString: String = ""
            if(value < 0)
                binString += "1"
            else
                binString += "0"
        for(place <- 1 to 31)
        {
            var digit = scala.math.pow(2, 31 - place).toInt
            var oneOrZero = (value & digit) >>> (31 - place)
            binString += oneOrZero
        }
        //println(binString)
    }
}