package com.example.fauxcast.katas

import org.junit.Assert.assertEquals
import org.junit.Test

class TitleSanitizerTest {

    // sanitizeTitle
    @Test
    fun `collapses internal whitespace and trims`() {
        assertEquals("The Last Signal", "  The   Last  Signal ".sanitizeTitle())
    }

    @Test
    fun `whitespace-only becomes Untitled`() {
        assertEquals("Untitled", "   ".sanitizeTitle())
    }

    @Test
    fun `empty string becomes Untitled`() {
        assertEquals("Untitled", "".sanitizeTitle())
    }

    @Test
    fun `already clean string is unchanged`() {
        assertEquals("Clean", "Clean".sanitizeTitle())
    }

    @Test
    fun `tabs and newlines count as whitespace`() {
        assertEquals("a b c", "a\t\tb\nc".sanitizeTitle())
    }

    // truncate
    @Test
    fun `truncate shortens long text with an ellipsis`() {
        assertEquals("Hello W…", "Hello World".truncate(8))
    }

    @Test
    fun `truncate leaves short text unchanged`() {
        assertEquals("Hi", "Hi".truncate(8))
    }

    @Test
    fun `truncate leaves exact-length text unchanged`() {
        assertEquals("12345678", "12345678".truncate(8))
    }
}
