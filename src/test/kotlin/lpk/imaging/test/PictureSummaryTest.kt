package lpk.imaging.test

import org.junit.Assert
import org.junit.Test
import lpk.imaging.PictureSummary
import lpk.imaging.loadPictureFromFile
import lpk.imaging.read
import java.nio.file.Paths

val SUMMARY = "src/test/resources/images/summary/"

class PictureSummaryTest {
    @Test
    fun proportionBlackRightTest() {
        Assert.assertEquals(0.0F, summary("bwbw_v.png").proportionBlackRight)
        Assert.assertEquals(0.5F, summary("wbwb_v.png").proportionBlackRight)
        Assert.assertEquals(0.25F, summary("bwbw_h.png").proportionBlackRight)
        Assert.assertEquals(0.25F, summary("wbwb_h.png").proportionBlackRight)
    }

    @Test
    fun hasBottomBarTest() {
        Assert.assertTrue(summary("wbwb_h.png").hasBottomBar)
        Assert.assertTrue(summary("bottombar.png").hasBottomBar)
        Assert.assertFalse(summary("bwbw_h.png").hasBottomBar)
        Assert.assertFalse(summary("nobottombar.png").hasBottomBar)
    }

    @Test
    fun heightToWidthTest() {
        Assert.assertEquals(1.0F, summary("bwbw_v.png").heightToWidth)
        Assert.assertEquals(0.7F, summary("bottombar.png").heightToWidth)
    }

    fun summary(name: String): PictureSummary {
        val file = Paths.get(SUMMARY + name).toFile()
        return PictureSummary(loadPictureFromFile(file))
    }
}