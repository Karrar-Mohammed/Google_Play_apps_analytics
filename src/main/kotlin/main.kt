import java.io.File
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.math.round

fun main() {

    val file = File("src/google_play.csv")
    val listOfApps = mutableListOf<App>()
    file.forEachLine {
        val mlist = it.split(",")
        listOfApps.add(
            App(
                appName = mlist[0],
                company = mlist[1],
                category = mlist[2],
                lastUpdated = dateParser(mlist[3]),
                size = mlist[4],
                installs = mlist[5].toLong(),
                currentVersion = mlist[6],
                requiresAndroid = mlist[7]
            )
        )
    }
    val number = numberOfAppsDevelopedByGoogle(listOfApps)
    println("number of apps developed by google : $number")

    val numberOfMedicalApps = numberOfMedicalApps(listOfApps)
    println("number of medical app : $numberOfMedicalApps")

    val oldest = oldestApp(listOfApps)
    println("oldest app is : ${oldest.appName} ${oldest.lastUpdated}")

    val percentageOfAppsRunningOnAndroid9AndUp = percentageOfAppsRunningOnAndroid9AndUp(listOfApps)
    println("percentage of apps running of android 9 and up $percentageOfAppsRunningOnAndroid9AndUp%")

    val top10= top10InstalledApp(listOfApps)
    top10.forEach {
        println(it)
    }
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

fun dateParser(date:String): LocalDate {
    val formatter = DateTimeFormatter.ofPattern("MMMM d yyyy", Locale.ENGLISH)
    return LocalDate.parse(date, formatter)
}

fun Double.roundTo1Digit(): Double = round(this * 10) / 10