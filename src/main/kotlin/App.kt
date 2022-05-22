import java.time.LocalDate

data class App(
    val appName: String,
    val company: String,
    val category: String,
    val lastUpdated: LocalDate,
    val size: String,
    val installs: Long,
    val currentVersion: String,
    val requiresAndroid: String
)