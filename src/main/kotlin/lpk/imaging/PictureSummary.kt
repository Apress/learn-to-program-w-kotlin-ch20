package lpk.imaging

import java.awt.Color

class PictureSummary(picture: Picture) {
    val heightToWidth: Float
    val hasBottomBar : Boolean
    val proportionBlackRight : Float

    init {
        heightToWidth = picture.height().toFloat() / picture.width()
        val regions = Regions(picture.height(), picture.width())
        var rightQuarterBlack = 0
        var bottomBarBlack = 0
        var black = 0
        for (row in 0..picture.height() - 1) {
            for (column in 0..picture.width() - 1) {
                val isBlack = picture.pixelByRowColumn(row, column) == Color.BLACK
                if (isBlack) {
                    black = black + 1
                    if (regions.isInBottomBar(row)) bottomBarBlack++
                    if (regions.isInRightQuarter(column)) rightQuarterBlack++
                }
            }
        }
        proportionBlackRight = rightQuarterBlack.toFloat() / black.toFloat()
        val bottomBarRatio = bottomBarBlack.toFloat() / regions.bottomBarArea().toFloat()
        hasBottomBar = bottomBarRatio > .75
    }
}