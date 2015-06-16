package pokerNight.rule

import pokerNight.model.Card

case object CardActionEnum extends Enumeration {
      type CardActionValue = Value
      val Wild, Kill, Buy = Value
    
}

case class SpecialCardRule(cardAction: String, card: Card) {
    val cardActiionValue = CardActionEnum.withName(cardAction)

    def this(cardAction: CardActionEnum.CardActionValue, card: Card) =
    {
        this(cardAction.toString, card)
    }
}