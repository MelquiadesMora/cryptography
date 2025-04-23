import com.mel.DiffieHellman
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.HexFormat

class DiffieHellmanTest {
    private val alice = DiffieHellman()
    private val bob = DiffieHellman()

    @Test
    fun test() {
        alice.executeLastPhase(bob.getPublicKey())
        bob.executeLastPhase(alice.getPublicKey())

        val aliceSecret = HexFormat.of().formatHex(alice.getSecret())
        println(aliceSecret)
        val bobSecret = HexFormat.of().formatHex(bob.getSecret())
        println(bobSecret)

        assertEquals(aliceSecret, bobSecret)
    }
}