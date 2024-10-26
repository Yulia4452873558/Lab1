package com.example.marvel.data.constant

import java.math.BigInteger
import java.security.MessageDigest

class ApiConstants {
    companion object {
        const val BASE_URL = "https://gateway.marvel.com"
        val TIMESTAMP = "1"
        const val PUBLIC_API_KEY = "99974e4d9a61b8ea9aca76b44ea5e800"
        const val PRIVATE_API_KEY = "75d98de9513a5fb165ed213938d39aa3e1392a22"
        const val LIMIT = "3"

        fun generateHash(): String {
            val strToHash = "$TIMESTAMP$PRIVATE_API_KEY$PUBLIC_API_KEY"
            val md5 = MessageDigest.getInstance("MD5")

            return BigInteger(1, md5.digest(strToHash.toByteArray()))
                .toString(16)
                .padStart(32, '0')
        }
    }
}
