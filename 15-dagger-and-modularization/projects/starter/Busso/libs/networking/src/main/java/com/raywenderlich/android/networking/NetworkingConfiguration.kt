package com.raywenderlich.android.networking

interface NetworkingConfiguration {
    val cacheSize: Long
    val serverBaseUrl: String
    val dateFormat: String
}