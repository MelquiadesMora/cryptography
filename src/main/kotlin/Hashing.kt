package com.mel

import java.security.MessageDigest

class Hashing {
    private val digestAlgorithm = "SHA-256"

    fun sha256(input: String): String {
        val messageDigest = MessageDigest.getInstance(digestAlgorithm)
        val hashedInput = messageDigest.digest(input.toByteArray())

        val encodedHash = StringBuilder()
        hashedInput.forEach { hashedElement ->
            val hex = Integer.toHexString(0xff and hashedElement.toInt())
            if (hex.length == 1) {
                encodedHash.append('0')
            }
            encodedHash.append(hex)
        }
        return encodedHash.toString()
    }
}