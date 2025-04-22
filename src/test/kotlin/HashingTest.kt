import com.mel.Hashing
import org.junit.jupiter.api.Test

class HashingTest {
    private val hashing = Hashing()

    @Test
    fun test() {
        val plainText = "Hello, world!"

        println(hashing.sha256(plainText))
    }
}