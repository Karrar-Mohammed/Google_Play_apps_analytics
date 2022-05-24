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
            val number = numberOfAppsDevelopedByGoogle(listOfApps)
            println("number of apps developed by google : $number")
        }

        "2" -> {
            val numberOfMedicalApps = numberOfMedicalApps(listOfApps)
            println("number of medical app : $numberOfMedicalApps")
        }

        "3" -> {
            val oldest = oldestApp(listOfApps)
            println("oldest app is : ${oldest.appName} ${oldest.lastUpdated}")
        }

        "4" -> {
            val percentageOfAppsRunningOnAndroid9AndUp = percentageOfAppsRunningOnAndroid9AndUp(listOfApps)
            println("percentage of apps running of android 9 and up $percentageOfAppsRunningOnAndroid9AndUp%")
        }

        "5" -> {
            val largestApps = getLargest10Apps(listOfApps)
            largestApps.forEach {
                println("${it.appName} ${it.size.first}")
            }
        }

        "6" -> {
            val top10= top10InstalledApp(listOfApps)
            top10.forEach {
                println("${it.appName} ${it.installs}")
            }
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


fun numberOfAppsDevelopedByGoogle(list: List<App>): Int {
    return list.count { it.company == "Google LLC" }

}

fun numberOfMedicalApps(list: List<App>): Int {
    return list.count { it.category == "Medical" }
}

fun oldestApp(list: List<App>): App {
    var oldestApp = list[0]
    list.forEach {
        if (it.lastUpdated < oldestApp.lastUpdated) {
            oldestApp = it
        }
    }
    return oldestApp
}

fun percentageOfAppsRunningOnAndroid9AndUp(list: List<App>): Double {
    return (list.count { it.requiresAndroid == "9 and up" }.toDouble() / list.size.toDouble() * 100).roundTo1Digit()
}

fun top10InstalledApp(list: List<App>): List<App> {
    return list.sortedByDescending { it.installs }.take(10)
}

fun convertStringDateToLocalDateObject(date: String): LocalDate {
    val formatter = DateTimeFormatter.ofPattern("MMMM d yyyy")
    return LocalDate.parse(date, formatter)
}

fun getLargest10Apps(list: List<App>): List<App> {
    return list.sortedByDescending { it.size.second }.take(10)
}


fun sizeConverter(size: String): Long {
    return when(size.last()) {
        'G' -> ((size.take(size.length -1)).toDouble() * 1073741824).toLong()
        'M' -> ((size.take(size.length -1)).toDouble() * 1048576).toLong()
        'k' -> ((size.take(size.length -1)).toDouble() * 1024).toLong()
        'e' -> 0
        else -> throw Exception("fuck you")
    }
}



fun Double.roundTo1Digit(): Double = round(this * 10) / 10