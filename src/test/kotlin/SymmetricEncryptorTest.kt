import com.mel.SymmetricEncryptor
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SymmetricEncryptorTest {
    private val symmetricEncryptor = SymmetricEncryptor()

    @Test
    fun test() {
        val plainText = "Hello, world!"
        val cipherText = symmetricEncryptor.encrypt(plainText)
        assertEquals(plainText, symmetricEncryptor.decrypt(cipherText))
    }
}