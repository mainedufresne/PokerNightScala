package com.pokernight.rule

/**
 * Created by chris on 6/22/15.
 */
case object BettingScheme extends Enumeration {
  type Basis = Value
  val Rotating, Standard = Value
}
