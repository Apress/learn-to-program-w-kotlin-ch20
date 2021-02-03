package lpk.imaging

import java.awt.Color
import java.io.File

class DigitFinder(val input: Picture) {
    val blackWhitRedThresholder: ((Color) -> (Color)) = {
        if (it.red < 96 && it.green < 96 && it.blue < 96) {
            Color.BLACK
        } else if (it.red > 128 && it.green < 96 && it.blue < 96) {
            Color.RED
        } else {
            Color.WHITE
        }
    }

    val sizeAtLeast20: ((Picture) -> (Boolean)) = {
        it.width() > 20 && it.height() > 20
    }

    val sizeAtLeast10: ((Picture) -> (Boolean)) = {
        it.width() > 10 && it.height() > 10
    }

    fun digits(): List<Picture> {
        val blackWhitRedVersion = input.transform(blackWhitRedThresholder)

        val slicesH = blackWhitRedVersion.sliceHorizontallyIntoPicturesContaining(Color.RED)
        val signSlice = slicesH.first()

        val slicesV = signSlice.sliceVerticallyIntoPicturesContaining(Color.RED)
        val sign = slicesV.first()

        val slices2H = sign.sliceHorizontallyIntoPicturesContaining(Color.BLACK).filter(sizeAtLeast20)
        val digitsSlice = slices2H.first()

        return digitsSlice.sliceVerticallyIntoPicturesContaining(Color.BLACK).filter(sizeAtLeast10)
    }
}