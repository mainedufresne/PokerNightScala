import org.scalatest._
import pokerNight.model._

/**
 * Created by chris on 5/2/15.
 */
class HandEvaluatorSpec extends FlatSpec with Matchers {

  "A HandEvaluator" should "rank better hands higher than worse hands" in {
    val hand1 = new Array[Card](5)
    val hand2 = new Array[Card](5)

    hand1(0) = new Card(Suit("Clubs"), Rank("Two"))
    hand1(1) = new Card(Suit("Clubs"), Rank("Three"))
    hand1(2) = new Card(Suit("Clubs"), Rank("Four"))
    hand1(3) = new Card(Suit("Clubs"), Rank("Five"))
    hand1(4) = new Card(Suit("Diamonds"), Rank("Seven"))

    hand2(0) = new Card(Suit("Spades"), Rank("Ace"))
    hand2(1) = new Card(Suit("Spades"), Rank("King"))
    hand2(2) = new Card(Suit("Spades"), Rank("Queen"))
    hand2(3) = new Card(Suit("Spades"), Rank("Jack"))
    hand2(4) = new Card(Suit("Spades"), Rank("Ten"))

    val hand1Value = HandEvaluator.evaluateBestFiveCardHand(hand1)
    val hand2Value = HandEvaluator.evaluateBestFiveCardHand(hand2)


    hand1Value should be (7462)
    hand2Value should be (1)
    hand1Value should be > hand2Value
  }

  it should "Return the proper string for a royal flush" in {

    val hand2 = new Array[Card](5)

    hand2(0) = new Card(Suit("Spades"), Rank("Ace"))
    hand2(1) = new Card(Suit("Spades"), Rank("King"))
    hand2(2) = new Card(Suit("Spades"), Rank("Queen"))
    hand2(3) = new Card(Suit("Spades"), Rank("Jack"))
    hand2(4) = new Card(Suit("Spades"), Rank("Ten"))

    var handString = HandEvaluator.getHandRankAsString(HandEvaluator.getHandRank(HandEvaluator.evaluateBestFiveCardHand(hand2)))

    handString should be ("royal flush")

    hand2(0) = new Card(Suit("Hearts"), Rank("Ace"))
    hand2(1) = new Card(Suit("Hearts"), Rank("King"))
    hand2(2) = new Card(Suit("Hearts"), Rank("Queen"))
    hand2(3) = new Card(Suit("Hearts"), Rank("Jack"))
    hand2(4) = new Card(Suit("Hearts"), Rank("Ten"))

    handString = HandEvaluator.getHandRankAsString(HandEvaluator.getHandRank(HandEvaluator.evaluateBestFiveCardHand(hand2)))

    handString should be ("royal flush")

    hand2(0) = new Card(Suit("Diamonds"), Rank("Ace"))
    hand2(1) = new Card(Suit("Diamonds"), Rank("King"))
    hand2(2) = new Card(Suit("Diamonds"), Rank("Queen"))
    hand2(3) = new Card(Suit("Diamonds"), Rank("Jack"))
    hand2(4) = new Card(Suit("Diamonds"), Rank("Ten"))

    handString = HandEvaluator.getHandRankAsString(HandEvaluator.getHandRank(HandEvaluator.evaluateBestFiveCardHand(hand2)))

    handString should be ("royal flush")

    hand2(0) = new Card(Suit("Clubs"), Rank("Ace"))
    hand2(1) = new Card(Suit("Clubs"), Rank("King"))
    hand2(2) = new Card(Suit("Clubs"), Rank("Queen"))
    hand2(3) = new Card(Suit("Clubs"), Rank("Jack"))
    hand2(4) = new Card(Suit("Clubs"), Rank("Ten"))

    handString = HandEvaluator.getHandRankAsString(HandEvaluator.getHandRank(HandEvaluator.evaluateBestFiveCardHand(hand2)))

    handString should be ("royal flush")

  }

  it should "Return the proper string for a straight flush" in {

    val hand2 = new Array[Card](5)

    hand2(0) = new Card(Suit("Spades"), Rank("Nine"))
    hand2(1) = new Card(Suit("Spades"), Rank("King"))
    hand2(2) = new Card(Suit("Spades"), Rank("Queen"))
    hand2(3) = new Card(Suit("Spades"), Rank("Jack"))
    hand2(4) = new Card(Suit("Spades"), Rank("Ten"))

    val handString = HandEvaluator.getHandRankAsString(HandEvaluator.getHandRank(HandEvaluator.evaluateBestFiveCardHand(hand2)))

    handString should be ("straight flush")
  }

  it should "Return the proper string for a high card" in {
    val hand1 = new Array[Card](5)

    hand1(0) = new Card(Suit("Clubs"), Rank("Two"))
    hand1(1) = new Card(Suit("Clubs"), Rank("Three"))
    hand1(2) = new Card(Suit("Clubs"), Rank("Four"))
    hand1(3) = new Card(Suit("Clubs"), Rank("Five"))
    hand1(4) = new Card(Suit("Diamonds"), Rank("Seven"))

    val handString = HandEvaluator.getHandRankAsString(HandEvaluator.getHandRank(HandEvaluator.evaluateBestFiveCardHand(hand1)))

    handString should be ("high card")
  }

}
