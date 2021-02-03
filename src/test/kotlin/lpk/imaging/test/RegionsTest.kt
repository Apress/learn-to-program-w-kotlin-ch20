package lpk.imaging.test

import org.junit.Assert
import org.junit.Test
import lpk.imaging.Regions

class RegionsTest {
    @Test
    fun isInRightQuarterTest() {
        val regions = Regions(40, 60)
        for (i in 0..44) {
            Assert.assertFalse(regions.isInRightQuarter(i))
        }
        for (i in 45..59) {
            Assert.assertTrue(regions.isInRightQuarter(i))
        }
    }

    @Test
    fun isInBottomBarTest() {
        val regions = Regions(70, 60)
        for (i in 0..59) {
            Assert.assertFalse(regions.isInBottomBar(i))
        }
        for (i in 60..69) {
            Assert.assertTrue(regions.isInBottomBar(i))
        }
    }

    @Test
    fun bottomBarAreaTest() {
        val regions = Regions(70, 60)
        Assert.assertEquals(600, regions.bottomBarArea())
    }
}