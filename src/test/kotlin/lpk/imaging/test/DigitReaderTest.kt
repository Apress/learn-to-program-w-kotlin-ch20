package lpk.imaging.test

import org.junit.Assert
import org.junit.Test
import lpk.imaging.PictureSummary
import lpk.imaging.loadPictureFromFile
import lpk.imaging.read
import java.nio.file.Paths

val DIGITS = "src/test/resources/images/digits"

class DigitReaderTest {
    @Test
    fun readTest() {
        Assert.assertEquals(1, read(loadSummary("1.png")))
    }

    fun loadSummary(name: String): PictureSummary {
        val file = Paths.get(DIGITS + "/" + name).toFile()
        return PictureSummary(loadPictureFromFile(file))
    }
}