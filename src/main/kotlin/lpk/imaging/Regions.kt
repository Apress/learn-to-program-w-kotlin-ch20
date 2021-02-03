package lpk.imaging

data class Regions(val rows: Int, val columns: Int) {
    val seventhHeight: Int
    val sixSeventhsHeight: Int
    val quarterWidth: Int
    val threeQuarterWidth: Int
    val quarterHeight: Int
    val threeQuarterHeight: Int

    init {
        seventhHeight = rows / 7
        sixSeventhsHeight = rows - seventhHeight
        quarterWidth = columns / 4
        threeQuarterWidth = columns - quarterWidth
        quarterHeight = rows / 4
        threeQuarterHeight = rows - quarterHeight
    }

    fun isInRightQuarter(column: Int): Boolean {
        return column >= threeQuarterWidth
    }

    fun isInBottomBar(row: Int): Boolean {
        if (row >= sixSeventhsHeight) return true
        return false
    }

    fun bottomBarArea(): Int {
        return columns * seventhHeight
    }
}