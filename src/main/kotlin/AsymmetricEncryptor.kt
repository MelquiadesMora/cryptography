package com.mel

import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.PrivateKey
import java.security.PublicKey
import java.util.Base64
import javax.crypto.Cipher

class AsymmetricEncryptor {
    private val keyPair: KeyPair = KeyPairGenerator.getInstance("RSA").run {
        initialize(512)
        generateKeyPair()
    }
    private val privateKey: PrivateKey = keyPair.private
    private val publicKey: PublicKey = keyPair.public
    private val cipher = Cipher.getInstance("RSA")

    fun encrypt(textToEncrypt: String): String = cipher.run {
        init(Cipher.ENCRYPT_MODE, publicKey)
        update(textToEncrypt.toByteArray())
        Base64.getEncoder().encodeToString(doFinal())
    }

    fun decrypt(textToDecrypt: String): String = cipher.run {
        init(Cipher.DECRYPT_MODE, privateKey)
        update(Base64.getDecoder().decode(textToDecrypt))
        String(doFinal())
    }
}