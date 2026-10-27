package com.example.fauxcast.katas

/*
 * Kata — Safe lookup   (Phase 0: null safety)
 *
 * PART A — lookupOrDefault(values, key, default):
 *   - key present -> its value
 *   - key absent  -> default
 *   - use Elvis ?: ; no !!.
 *
 *   Scenarios to cover in tests:
 *     - present key           -> value
 *     - absent key            -> default
 *     - empty map             -> default
 *     - value is "" (empty)   -> returns "" , NOT default
 *                                (?: only fires on null, never on an empty string — key edge!)
 *     - keys are case-sensitive: lookup "EN" when only "en" exists -> default
 *
 * PART B (stretch) — lookupOrNull(values, key): String?
 *   - return the value, or null when absent (practice returning a nullable type).
 *     Scenarios: present -> value ; absent -> null ; empty map -> null.
 *
 * Examples:
 *   lookupOrDefault(mapOf("en" to "English"), "en", "Unknown") -> "English"
 *   lookupOrDefault(mapOf("x" to ""), "x", "Unknown")          -> ""     (empty, not default)
 *   lookupOrNull(mapOf("en" to "English"), "fr")               -> null
 */
fun lookupOrDefault(values: Map<String, String>, key: String, default: String): String {
    return values[key] ?: default
}

fun lookupOrNull(values: Map<String, String>, key: String): String? {
    return values[key]
}
