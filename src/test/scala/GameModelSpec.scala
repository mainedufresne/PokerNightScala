import org.scalatest.{Matchers, FlatSpec}
import org.scalatest.matchers._
import pokerNight.model.{PlayerModel, DeckModel, GameModel}

/**
 * Created by chris on 6/15/15.
 */
class GameModelSpec extends FlatSpec with Matchers {

  "A GameModel" should "be able to create a Texas Holdem game" in {

    val player1 = new PlayerModel("Chris", 1000)
    val player2 = new PlayerModel("Jon", 1000)
    val player3 = new PlayerModel("Ross", 1000)
    val player4 = new PlayerModel("Bob", 1000)
    val players = Array(player1, player2,player3, player4)

    val gameModel = new GameModel(new DeckModel(), players, "/Users/chris/IdeaProjects/PokerNight/src/main/scala/com/pokernight/test/simple.json")

    gameModel.dealRoundCards()

    println(gameModel.state)

    player1.getHand() should not be empty
    player2.getHand() should not be empty
    player3.getHand() should not be empty
    player4.getHand() should not be empty



  }

}
