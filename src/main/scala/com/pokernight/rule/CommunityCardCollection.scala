package pokerNight.rule

import java.awt.geom.Point2D

case class CommunityCardCollection(val name: String, val cardGridLocations: Seq[String]) {

    var curIndex = 0
    def getNextGridLocation() : Point2D = 
    {
        var curPoint = ""
        var returnPoint :Point2D.Float = null
        if(curIndex < cardGridLocations.length)
        {
            curPoint = cardGridLocations(curIndex)
            var tokens = curPoint.split("-")
            returnPoint = new Point2D.Float(tokens(0).toInt, tokens(1).toInt)
        }
        curIndex = curIndex + 1
        returnPoint
    }
    
    def hasNext = curIndex < cardGridLocations.length
    def resetNext = curIndex = 0
}