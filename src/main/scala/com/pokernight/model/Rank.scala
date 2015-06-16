package pokerNight.model

object RankEnum extends Enumeration {
    //TODO: Insert explanation of rank values here
    val Two = Value("Two", 0x10002)
    val Three = Value("Three", 0x20003)
    val Four = Value("Four", 0x40005)
    val Five = Value("Five", 0x80007)
    val Six = Value("Six", 0x10000B)
    val Seven = Value("Seven", 0x20000D)
    val Eight = Value("Eight", 0x400011)
    val Nine = Value("Nine", 0x800013)
    val Ten = Value("Ten", 0x1000017)
    val Jack = Value("Jack", 0x200001D)
    val Queen = Value("Queen", 0x400001F)
    val King = Value("King", 0x8000025)
    val Ace = Value("Ace", 0x10000029)
    val Joker = Value("Joker", 1)
    class RankValue(name: String, val value: Int) extends Val(value, name)
        protected final def Value(name: String, value: Int): RankValue = new RankValue(name, value)

  }

//These constructors are what I would consider backwards because of the way Jackson deserializes
//The default constructor cannot take an Enumeration or Jackson will choke
case class Rank(rank: String) {
    val rankValue = RankEnum.withName(rank)
    def this(rankEnum: RankEnum.Value) = {this(rankEnum.toString)}
    def getValue() : RankEnum.Value = {return rankValue}
}
