package pokerNight.rule

import com.fasterxml.jackson.annotation.JsonIgnore
import scala.io.Source

/*
 * {
    "GameRules" : 
    {
       "name" : "Texas Hold'em",
        "communityCardRule" :
        {
            "dealRule" : ["3,1|3,2|3,3","3,4","3,5"]
            "communityCardCollection" :
            {
                [
                    {
                        "collectionName" : "Community Cards",
                        "cardGridLocations" : "["3,1","3,2","3,3","3,4","3,5"]"
                    }
                ]
            }
        }
    }
}
 */
case class GameRules(val name: String, val basis : String, val rounds: Int,  val playerCardRule : PlayerCardRule, val communityCardRule : Option[CommunityCardRule], val winCondition : Seq[WinCondition], val specialCardRules : Option[Seq[SpecialCardRule]]) {
    
    @JsonIgnore
    val gameBasis = GameBasis.withName(basis)
}