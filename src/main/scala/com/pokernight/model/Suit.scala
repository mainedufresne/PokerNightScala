package pokerNight.model

object SuitEnum extends Enumeration {
	  val Clubs = Value("Clubs", 0x8000)
	  val Diamonds = Value("Diamonds", 0x4000)
	  val Hearts = Value("Hearts", 0x2000)
	  val Spades = Value("Spades", 0x1000)
	  class SuitValue(name: String, value: Int) extends Val(value, name)
	   protected final def Value(name: String, value: Int): SuitValue = new SuitValue(name, value)
	  
}

//These constructors are what I would consider backwards because of the way Jackson deserializes
//The default constructor cannot take an Enumeration or Jackson will choke
case class Suit(suit: String)
{
    val suitValue = SuitEnum.withName(suit)
    def this(suitEnum: SuitEnum.SuitValue) = {this(suitEnum.toString)}
    def getValue() : SuitEnum.Value = {return suitValue}    
}
