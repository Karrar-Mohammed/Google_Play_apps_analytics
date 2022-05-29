import java.io.File
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.math.round

fun main() {

    val file = File("src/google_play.csv")
    val listOfApps = createListOfAppsFromFile(file)
    readInput(listOfApps)

}

fun readInput(listOfApps: List<App>): Int {
    val analyzer = Analyzer()
    println(
        "\nenter the number of operation you want to execute:\n" +
                "\n1- number of apps developed by google\n" +
                "2- number of medical apps\n" +
                "3- oldest app in the google play\n" +
                "4- percentage of apps running on android 9 and up\n" +
                "5- largest 10 apps in google play\n" +
                "6- top 10 most installed apps\n" +
                "enter exit to end the program.\n"
    )
    print("your input: ")
    val stringInput = readLine()

    when (stringInput) {
        "1" -> {
            val number = analyzer.numberOfAppsDevelopedByGoogle(listOfApps)
            println("number of apps developed by google : $number")
        }

        "2" -> {
            val numberOfMedicalApps = analyzer.numberOfMedicalApps(listOfApps)
            println("number of medical app : $numberOfMedicalApps")
        }

        "3" -> {
            val oldest = analyzer.oldestApp(listOfApps)
            if (oldest is App) {
                println("oldest app is : ${oldest.appName} ${oldest.lastUpdated}")
            } else println("it's empty list")
        }

        "4" -> {
            val percentageOfAppsRunningOnAndroid9AndUp = analyzer.percentageOfAppsRunningOnAndroid9AndUp(listOfApps)
            println("percentage of apps running of android 9 and up $percentageOfAppsRunningOnAndroid9AndUp%")
        }

        "5" -> {
            val largestApps = analyzer.getLargest10Apps(listOfApps)
            if ( largestApps is List<*>) {
                largestApps.forEach { it as App
                    println("${it.appName} ${it.size.first}")
                }
            }
        }

        "6" -> {
            val top10= analyzer.top10InstalledApp(listOfApps)
            if(top10 is List<*>){
                top10.forEach {it as App
                    println("${it.appName} ${it.installs}")
                }
            } else println("empty list")
        }

    }
    return if (stringInput == "exit") 0 else readInput(listOfApps)
}

fun createListOfAppsFromFile(file: File): List<App> {
    val listOfApps = mutableListOf<App>()
    file.forEachLine {
        val mList = it.split(",")
        listOfApps.add(
            App(
                appName = mList[0],
                company = mList[1],
                category = mList[2],
                lastUpdated = convertStringDateToLocalDateObject(mList[3]),
                size = Pair(mList[4], sizeConverter(mList[4])),
                installs = mList[5].toLong(),
                currentVersion = mList[6],
                requiresAndroid = mList[7]
            )
        )
    }
    return listOfApps
}

fun convertStringDateToLocalDateObject(date: String): LocalDate {
    val formatter = DateTimeFormatter.ofPattern("MMMM d yyyy")
    return LocalDate.parse(date, formatter)
}

fun sizeConverter(size: String): Long? {
    return when(size.last()) {
        'G' -> ((size.take(size.length -1)).toDouble() * 1073741824).toLong()
        'M' -> ((size.take(size.length -1)).toDouble() * 1048576).toLong()
        'k' -> ((size.take(size.length -1)).toDouble() * 1024).toLong()
        else -> null
    }
}



fun Double.roundTo1Digit(): Double = round(this * 10) / 10