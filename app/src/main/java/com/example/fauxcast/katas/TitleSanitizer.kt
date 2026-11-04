package com.example.fauxcast.katas

/*
 * Kata — Title sanitizer   (Phase 0: extension functions)
 *
 * Teaches EXTENSION FUNCTIONS: `String.` before the name means you're adding a function
 * onto String; inside the body `this` is the string it was called on.
 *
 * PART A — String.sanitizeTitle():
 *   - trim leading/trailing whitespace
 *   - collapse any run of whitespace (spaces, tabs, newlines) into a single space
 *   - if the result is empty -> "Untitled"
 *
 *   Scenarios to cover:
 *     - "  The   Last  Signal " -> "The Last Signal"
 *     - "   "                    -> "Untitled"
 *     - ""                       -> "Untitled"
 *     - "Clean"                  -> "Clean"      (already clean, unchanged)
 *     - "a\t\tb\nc"              -> "a b c"      (tabs/newlines are whitespace)
 *
 * PART B (stretch) — String.truncate(maxLen):
 *   - if length <= maxLen -> unchanged
 *   - else cut and append "…" so the TOTAL length == maxLen.
 *   Scenarios: "Hello World".truncate(8) -> "Hello W…" ; "Hi".truncate(8) -> "Hi"
 *
 * Hints: this.trim() ; Regex("\\s+").replace(text, " ") ; result.ifEmpty { "Untitled" } ;
 *        this.take(n) ; string length via this.length
 */
fun String.sanitizeTitle(): String {
    val collapsed = Regex("\\s+").replace(this.trim(), " ")
    return collapsed.ifEmpty { "Untitled" }
}

fun String.truncate(maxLen: Int): String =
    if (length <= maxLen) this else take(maxLen - 1) + "…"