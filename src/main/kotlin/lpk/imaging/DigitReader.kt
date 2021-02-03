package lpk.imaging

fun read(summary : PictureSummary) : Int {
    if (summary.heightToWidth > 3.0) return 1
    return -1
}