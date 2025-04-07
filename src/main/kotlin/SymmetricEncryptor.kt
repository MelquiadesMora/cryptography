package com.mel

import java.security.Key
import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.KeyGenerator

class SymmetricEncryptor {
    private val algorithm = "AES"
    private val key: Key = KeyGenerator
        .getInstance(algorithm)
        .run {
            init(256)
            generateKey()
        }
    private val cipher = Cipher.getInstance(algorithm)

    fun encrypt(textToEncrypt: String): String = cipher.run {
        init(Cipher.ENCRYPT_MODE, key)
        update(textToEncrypt.toByteArray())
        Base64.getEncoder().encodeToString(doFinal())
    }

    fun decrypt(textToDecrypt: String): String = cipher.run {
        init(Cipher.DECRYPT_MODE, key)
        update(Base64.getDecoder().decode(textToDecrypt))
        String(doFinal())
    }
}