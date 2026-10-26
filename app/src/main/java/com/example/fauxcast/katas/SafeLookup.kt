package com.example.fauxcast.katas

import android.util.Log

/*
 * Kata — Safe lookup   (Phase 0: null safety)
 *
 * Look up a value in a map by key, returning a default when the key is absent.
 *
 * lookupOrDefault(values, key, default):
 *   - key present -> return its value
 *   - key absent  -> return default
 *   - never crash; no !! allowed — use the Elvis operator ?:.
 *
 * Examples:
 *   lookupOrDefault(mapOf("en" to "English"), "en", "Unknown") -> "English"
 *   lookupOrDefault(mapOf("en" to "English"), "fr", "Unknown") -> "Unknown"
 *   lookupOrDefault(emptyMap(), "en", "Unknown")               -> "Unknown"
 *
 * Why this teaches null safety: map access `values[key]` returns a NULLABLE type (String?) —
 * it is null when the key is missing, so you must handle that null (with ?:).
 *
 */
fun lookupOrDefault(values: Map<String, String>, key: String, default: String): String {
    return values[key] ?: default
}

fun main() {
    println(lookupOrDefault(mapOf("en" to "English"), "en", "Unknown")) // English
    println(lookupOrDefault(mapOf("en" to "English"), "fr", "Unknown")) // Unknown
    println(lookupOrDefault(emptyMap(), "en", "Unknown"))               // Unknown
}