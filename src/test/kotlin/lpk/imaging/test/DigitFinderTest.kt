package lpk.imaging.test

import lpk.imaging.DigitFinder
import lpk.imaging.loadPictureFromFile
import java.io.File
import java.io.FileFilter

val SIGNS = "src/test/resources/images/signs/"

class DigitFinderTest {
    //This is not really a test, it is a function
    //that analyses each of the files in the
    //signs directory and saves the extracted
    //images as files in the temp directory.
    //To run it, uncomment the @org.junit.Test
    //annotation below so that IntelliJ
    //recognises it as a runnable test.
    //@org.junit.Test
    fun analyse() {
        val tempDir = File("temp")
        tempDir.mkdirs()
        val signsDir = File(SIGNS)
        val pngFileFilter = FileFilter { it.extension == "png" }
        signsDir.listFiles(pngFileFilter).forEach {
            file ->
            val fileName = file.nameWithoutExtension
            val finder = DigitFinder(loadPictureFromFile(file))
            val digitPics = finder.digits()
            var count = 0
            digitPics.forEach {
                pic ->
                val saveName = "${fileName}_$count.png"
                val saveFile = File(tempDir, saveName)
                pic.saveTo(saveFile)
                count++
            }
        }
    }
}