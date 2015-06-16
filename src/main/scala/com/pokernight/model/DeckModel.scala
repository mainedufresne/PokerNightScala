package pokerNight.model

import Rank._
import Suit._
import scala.collection.Iterable
import scala.collection.Set
import scala.util.Random

class DeckModel {
    
    var _deck = Set[Card](new Card(new Suit(SuitEnum.Clubs), new Rank(RankEnum.Two)), new Card(new Suit(SuitEnum.Clubs),  new Rank(RankEnum.Three)), new Card(new Suit(SuitEnum.Clubs),  new Rank(RankEnum.Four)), new Card(new Suit(SuitEnum.Clubs),  new Rank(RankEnum.Five)), new Card(new Suit(SuitEnum.Clubs),  new Rank(RankEnum.Six)), new Card(new Suit(SuitEnum.Clubs),  new Rank(RankEnum.Seven)), new Card(new Suit(SuitEnum.Clubs),  new Rank(RankEnum.Eight)), new Card(new Suit(SuitEnum.Clubs),  new Rank(RankEnum.Nine)), new Card(new Suit(SuitEnum.Clubs),  new Rank(RankEnum.Ten)), new Card(new Suit(SuitEnum.Clubs),  new Rank(RankEnum.Jack)), new Card(new Suit(SuitEnum.Clubs),  new Rank(RankEnum.Queen)), new Card(new Suit(SuitEnum.Clubs),  new Rank(RankEnum.King)), new Card(new Suit(SuitEnum.Clubs),  new Rank(RankEnum.Ace)),
                                new Card(new Suit(SuitEnum.Diamonds), new Rank(RankEnum.Two)), new Card(new Suit(SuitEnum.Diamonds), new Rank(RankEnum.Three)), new Card(new Suit(SuitEnum.Diamonds),  new Rank(RankEnum.Four)), new Card(new Suit(SuitEnum.Diamonds),  new Rank(RankEnum.Five)), new Card(new Suit(SuitEnum.Diamonds),  new Rank(RankEnum.Six)), new Card(new Suit(SuitEnum.Diamonds),  new Rank(RankEnum.Seven)), new Card(new Suit(SuitEnum.Diamonds),  new Rank(RankEnum.Eight)), new Card(new Suit(SuitEnum.Diamonds),  new Rank(RankEnum.Nine)), new Card(new Suit(SuitEnum.Diamonds),  new Rank(RankEnum.Ten)), new Card(new Suit(SuitEnum.Diamonds),  new Rank(RankEnum.Jack)), new Card(new Suit(SuitEnum.Diamonds),  new Rank(RankEnum.Queen)), new Card(new Suit(SuitEnum.Diamonds),  new Rank(RankEnum.King)), new Card(new Suit(SuitEnum.Diamonds),  new Rank(RankEnum.Ace)),
                                new Card(new Suit(SuitEnum.Hearts), new Rank(RankEnum.Two)), new Card(new Suit(SuitEnum.Hearts), new Rank(RankEnum.Three)), new Card(new Suit(SuitEnum.Hearts),  new Rank(RankEnum.Four)), new Card(new Suit(SuitEnum.Hearts),  new Rank(RankEnum.Five)), new Card(new Suit(SuitEnum.Hearts),  new Rank(RankEnum.Six)), new Card(new Suit(SuitEnum.Hearts),  new Rank(RankEnum.Seven)), new Card(new Suit(SuitEnum.Hearts),  new Rank(RankEnum.Eight)), new Card(new Suit(SuitEnum.Hearts),  new Rank(RankEnum.Nine)), new Card(new Suit(SuitEnum.Hearts),  new Rank(RankEnum.Ten)), new Card(new Suit(SuitEnum.Hearts),  new Rank(RankEnum.Jack)), new Card(new Suit(SuitEnum.Hearts),  new Rank(RankEnum.Queen)), new Card(new Suit(SuitEnum.Hearts),  new Rank(RankEnum.King)), new Card(new Suit(SuitEnum.Hearts),  new Rank(RankEnum.Ace)),
                                new Card(new Suit(SuitEnum.Spades), new Rank(RankEnum.Two)), new Card(new Suit(SuitEnum.Spades), new Rank(RankEnum.Three)), new Card(new Suit(SuitEnum.Spades),  new Rank(RankEnum.Four)), new Card(new Suit(SuitEnum.Spades),  new Rank(RankEnum.Five)), new Card(new Suit(SuitEnum.Spades),  new Rank(RankEnum.Six)), new Card(new Suit(SuitEnum.Spades),  new Rank(RankEnum.Seven)), new Card(new Suit(SuitEnum.Spades),  new Rank(RankEnum.Eight)), new Card(new Suit(SuitEnum.Spades),  new Rank(RankEnum.Nine)), new Card(new Suit(SuitEnum.Spades),  new Rank(RankEnum.Ten)), new Card(new Suit(SuitEnum.Spades),  new Rank(RankEnum.Jack)), new Card(new Suit(SuitEnum.Spades),  new Rank(RankEnum.Queen)), new Card(new Suit(SuitEnum.Spades),  new Rank(RankEnum.King)), new Card(new Suit(SuitEnum.Spades),  new Rank(RankEnum.Ace)))
                                
    def shuffle() = {
        Random.setSeed(System.currentTimeMillis)
        _deck = Random.shuffle(_deck)
    }
    
    def drawCard(): Card = {
        Random.setSeed(System.currentTimeMillis)
        val numCards: Int = _deck.size
        var drawnCard: Card = null
        
        if(numCards > 0)
        {
            
            drawnCard = (_deck.toList)(Random.nextInt(numCards))//_deck.head
            _deck -= drawnCard
        }
            
        return drawnCard
        
    }
    
    def returnCard(card: Card) = {
        _deck += card
    }
    
    def returnCards(cards: Iterable[Card]) = {
        for (card <- cards)
        {
            _deck += card
        }
    }
    
    def addJoker(suit: Suit) = {
        _deck += new Card(suit, new Rank(RankEnum.Joker))
    }
    
    def removeJokers(suit: Suit) = {
        for(card <- _deck)
            if(card.getRank == new Rank(RankEnum.Joker))
                _deck -= card
    }
        
                                
}