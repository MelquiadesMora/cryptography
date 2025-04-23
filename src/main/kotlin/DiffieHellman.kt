package com.mel

import java.security.KeyPairGenerator
import java.security.PublicKey
import javax.crypto.KeyAgreement

class DiffieHellman {
    private val diffieHellmanAlgorithmName = "DiffieHellman"
    private val keyPair = KeyPairGenerator
        .getInstance(diffieHellmanAlgorithmName)
        .generateKeyPair()
    private val keyAgreement = KeyAgreement.getInstance(diffieHellmanAlgorithmName)

    init {
        keyAgreement.init(keyPair.private)
    }

    fun getPublicKey(): PublicKey {
        return keyPair.public
    }

    fun executeLastPhase(key: PublicKey) {
        keyAgreement.doPhase(key, true)
    }

    fun getSecret(): ByteArray {
        return keyAgreement.generateSecret()
    }
}