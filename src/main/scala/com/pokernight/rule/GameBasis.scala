package pokerNight.rule

case object GameBasis extends Enumeration {
      type Basis = Value
      val HoldEm, Draw, Stud = Value  
}