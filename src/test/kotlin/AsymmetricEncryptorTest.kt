import com.mel.AsymmetricEncryptor
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AsymmetricEncryptorTest {
    private val asymmetricEncryptor = AsymmetricEncryptor()

    @Test
    fun test() {
        val plainText = "Hello, world!"
        val cipherText = asymmetricEncryptor.encrypt(plainText)
        assertEquals(plainText, asymmetricEncryptor.decrypt(cipherText))
    }
}