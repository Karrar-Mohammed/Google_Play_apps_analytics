import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.time.LocalDate

internal class MainKtTest {

    //apps developed by google
    @Test
    fun should_returnNumberOfApp_whenCorrectListGiven() {
        //Given
        val appsList = listOf(
            App(
                appName = "youtube" ,
                company = "Google LLC" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            ) ,
            App(
                appName = "gallery" ,
                company = "Google LLC" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            ),
            App(
                appName = "facebook" ,
                company = "meta" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            ),
            App(
                appName = "instagram" ,
                company = "meta" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            )
        )
        //When
        val result = numberOfAppsDevelopedByGoogle(appsList)
        //Then
        assertEquals(2, result)
    }

    @Test
    fun should_return0_whenNoAppDevelopedByGoogleInTheList() {
        //Given
        val appsList = listOf(
            App(
                appName = "twitter" ,
                company = "twitter" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            ) ,
            App(
                appName = "opera" ,
                company = "opera" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            ),
            App(
                appName = "facebook" ,
                company = "meta" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            ),
            App(
                appName = "instagram" ,
                company = "meta" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            )
        )
        //When
        val result = numberOfAppsDevelopedByGoogle(appsList)
        //Then
        assertEquals(0, result)
    }


    //medical
    @Test
    fun should_returnNumberOfMedicalApps_whenCorrectListGiven() {
        //Given
        val appsList = listOf(
            App(
                appName = "google health" ,
                company = "Google LLC" ,
                category = "Medical" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            ) ,
            App(
                appName = "gallery" ,
                company = "Google LLC" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            ),
            App(
                appName = "facebook" ,
                company = "meta" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            ),
            App(
                appName = "instagram" ,
                company = "meta" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            )
        )
        //When
        val result = numberOfMedicalApps(appsList)
        //Then
        assertEquals(1, result)
    }

    @Test
    fun should_return0_whenNoMedicalAppsInTheList() {
        //Given
        val appsList = listOf(
            App(
                appName = "twitter" ,
                company = "twitter" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            ) ,
            App(
                appName = "opera" ,
                company = "opera" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            ),
            App(
                appName = "facebook" ,
                company = "meta" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            ),
            App(
                appName = "instagram" ,
                company = "meta" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            )
        )
        //When
        val result = numberOfMedicalApps(appsList)
        //Then
        assertEquals(0, result)
    }

    @Test
    fun should_return0_whenEmptyListGiven() {
        //Given
        val appsList = emptyList<App>()
        //When
        val result = numberOfMedicalApps(appsList)
        //Then
        assertEquals(0, result)
    }


    //oldest app
    @Test
    fun should_returnTheOldestAppDate_whenCorrectListGIven() {
        //Given
        val appsList = listOf(
            App(
                appName = "twitter" ,
                company = "twitter" ,
                category = "social" ,
                lastUpdated = convertStringDateToLocalDateObject("November 7 2019") ,
                size = Pair("2M",2097152) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            ) ,
            App(
                appName = "opera" ,
                company = "opera" ,
                category = "social" ,
                lastUpdated = convertStringDateToLocalDateObject("May 10 2016") ,
                size = Pair("2M",2097152) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            ),
            App(
                appName = "facebook" ,
                company = "meta" ,
                category = "social" ,
                lastUpdated = convertStringDateToLocalDateObject("April 26 2010") ,
                size = Pair("2M",2097152) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            ),
            App(
                appName = "instagram" ,
                company = "meta" ,
                category = "social" ,
                lastUpdated = convertStringDateToLocalDateObject("July 8 2015") ,
                size = Pair("2M",2097152) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            )
        )
        //When
        val result = oldestApp(appsList) as App

        //Then
        assertEquals(LocalDate.of(2010,4,26), result.lastUpdated)
    }

    @Test
    fun should_returnMinus1_whenEmptyListGiven() {
        //Given
        val appsList = emptyList<App>()
        //When
        val result = oldestApp(appsList)
        //Then
        assertEquals(-1, result)
    }


    //percentage of apps running on android 9 and up
    @Test
    fun should_returnPercentageOfAppsRunningOnAndroid9AndUp_whenCorrectListGiven() {
        //Given
        val appsList = listOf(
            App(
                appName = "youtube" ,
                company = "Google LLC" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            ) ,
            App(
                appName = "gallery" ,
                company = "Google LLC" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "9 and up"
            ),
            App(
                appName = "facebook" ,
                company = "meta" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "9 and up"
            ),
            App(
                appName = "instagram" ,
                company = "meta" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            ),
            App(
                appName = "LinkedIn" ,
                company = "LinkedIn" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "9 and up"
            )
        )
        //When
        val result = percentageOfAppsRunningOnAndroid9AndUp(appsList)
        //Then
        assertEquals(60.0, result)
    }

    @Test
    fun should_return0_whenNoAppsRunningOnAndroid9InTheList() {
        //Given
        val appsList = listOf(
            App(
                appName = "youtube" ,
                company = "Google LLC" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            ) ,
            App(
                appName = "gallery" ,
                company = "Google LLC" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            ),
            App(
                appName = "facebook" ,
                company = "meta" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "5 and up"
            ),
            App(
                appName = "instagram" ,
                company = "meta" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            ),
            App(
                appName = "LinkedIn" ,
                company = "LinkedIn" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            )
        )
        //When
        val result = percentageOfAppsRunningOnAndroid9AndUp(appsList)
        //Then
        assertEquals(0.0, result)
    }

    @Test
    fun should_returnMinus1_whenEmptyListOFAppsGiven() {
        //Given
        val appsList = emptyList<App>()
        //When
        val result = percentageOfAppsRunningOnAndroid9AndUp(appsList)
        //Then
        assertEquals(-1.0, result)
    }


    //top 10 installed app
    @Test
    fun should_returnTop10InstalledApps_whenCorrectListGiven() {
        //Given
        val appsList = listOf(
            App(
                appName = "youtube" ,
                company = "Google LLC" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 100 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            ) ,
            App(
                appName = "gallery" ,
                company = "Google LLC" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 50 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            ),
            App(
                appName = "facebook" ,
                company = "meta" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 90 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            ),
            App(
                appName = "instagram" ,
                company = "meta" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 80 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            )
        )
        //When
        val result = top10InstalledApp(appsList)
        //Then
        val expected = listOf(
            App(
                appName = "youtube" ,
                company = "Google LLC" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 100 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            ) ,
            App(
                appName = "facebook" ,
                company = "meta" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 90 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            ),
            App(
                appName = "instagram" ,
                company = "meta" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 80 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            ),
            App(
                appName = "gallery" ,
                company = "Google LLC" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 50 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            )
        )
        assertEquals(expected, result)
    }

    @Test
    fun should_return0_whenCorrectListGiven() {
        //Given
        val appsList = emptyList<App>()
        //When
        val result = top10InstalledApp(appsList)
        //Then
        assertEquals(-1, result)
    }


    //largest 10 apps
    @Test
    fun should_returnLargest10Apps_whenCorrectListGiven() {
        //Given
        val appsList = listOf(
            App(
                appName = "youtube" ,
                company = "Google LLC" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            ) ,
            App(
                appName = "gallery" ,
                company = "Google LLC" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("5M",5242880) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            ),
            App(
                appName = "facebook" ,
                company = "meta" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("6M",6291456) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            ),
            App(
                appName = "instagram" ,
                company = "meta" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("3M",3145728) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            )
        )
        //When
        val expected = listOf(
            App(
                appName = "facebook" ,
                company = "meta" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("6M",6291456) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            ),
            App(
                appName = "gallery" ,
                company = "Google LLC" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("5M",5242880) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            ),
            App(
                appName = "instagram" ,
                company = "meta" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("3M",3145728) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            ),
            App(
                appName = "youtube" ,
                company = "Google LLC" ,
                category = "social" ,
                lastUpdated = LocalDate.now() ,
                size = Pair("2M",2097152) ,
                installs = 10000000000 ,
                currentVersion = "3" ,
                requiresAndroid = "6 and up"
            )
        )
        val result = getLargest10Apps(appsList)
        //Then
        assertEquals(expected, result)
    }

    @Test
    fun should_returnMinus1_whenEmptyListOfLargestAppsGiven() {
        //Given
        val appsList = emptyList<App>()
        //When
        val result = getLargest10Apps(appsList)
        //Then
        assertEquals(-1, result)
    }


    //size converter
    @Test
    fun should_returnSizeInBytes_whenSizeInGigaByteGiven() {
        //Given
        val sizeInMB = "2.1G"
        //When
        val result = sizeConverter(sizeInMB)
        //Then
        assertEquals(2254857830,result)
    }

    @Test
    fun should_returnSizeInBytes_whenSizeInMegaByteGiven() {
        //Given
        val sizeInMB = "2.3M"
        //When
        val result = sizeConverter(sizeInMB)
        //Then
        assertEquals(2411724,result)
    }

    @Test
    fun should_returnSizeInBytes_whenSizeInKiloByteGiven() {
        //Given
        val sizeInMB = "4k"
        //When
        val result = sizeConverter(sizeInMB)
        //Then
        assertEquals(4096,result)
    }

    @Test
    fun should_returnNull_whenWrongSizeGiven() {
        //Given
        val sizeInMB = "Varies with device"
        //When
        val result = sizeConverter(sizeInMB)
        //Then
        assertNull(result)
    }
}