import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class MainKtTest {

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