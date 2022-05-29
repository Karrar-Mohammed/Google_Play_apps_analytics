class Analyzer {

    fun numberOfAppsDevelopedByGoogle(list: List<App>): Int {
        return list.count { it.company == "Google LLC" }

    }

    fun numberOfMedicalApps(list: List<App>): Int {
        return list.count { it.category == "Medical" }
    }

    fun oldestApp(list: List<App>): Any {
        return if (list.isNotEmpty()) {
            var oldestApp = list[0]
            list.forEach {
                if (it.lastUpdated < oldestApp.lastUpdated) {
                    oldestApp = it
                }
            }
            oldestApp
        } else -1
    }

    fun percentageOfAppsRunningOnAndroid9AndUp(list: List<App>): Double {
        return if (list.isNotEmpty()) {
            (list.count { it.requiresAndroid == "9 and up" }.toDouble() / list.size.toDouble() * 100).roundTo1Digit()
        } else -1.0
    }

    fun top10InstalledApp(list: List<App>): Any {
        return if (list.isNotEmpty()) {
            list.sortedByDescending { it.installs }.take(10)
        } else -1
    }

    fun getLargest10Apps(list: List<App>): Any {
        return if (list.isNotEmpty()) {
            return list.sortedByDescending { it.size.second }.take(10)
        } else -1
    }
}