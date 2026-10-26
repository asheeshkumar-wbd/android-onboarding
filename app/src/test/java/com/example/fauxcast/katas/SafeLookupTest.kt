package com.example.fauxcast.katas

import org.junit.Assert.assertEquals
import org.junit.Test

class SafeLookupTest {
    @Test fun `returns value when key present`() {
        assertEquals("English", lookupOrDefault(mapOf("en" to "English"), "en", "Unknown"))
    }
    @Test fun `returns default when key absent`() {
        assertEquals("Unknown", lookupOrDefault(mapOf("en" to "English"), "fr", "Unknown"))
    }
    @Test fun `returns default for empty map`() {
        assertEquals("Unknown", lookupOrDefault(emptyMap(), "en", "Unknown"))
    }
}