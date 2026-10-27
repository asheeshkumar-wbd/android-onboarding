package com.example.fauxcast.katas

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class DurationFormatterTest {

    @Test
    fun `formats minutes under an hour`() {
        assertEquals("45m", formatDuration(45))
    }

    @Test
    fun `formats hours and minutes`() {
        assertEquals("2h 8m", formatDuration(128))
    }

    @Test
    fun `formats an exact hour`() {
        assertEquals("1h 0m", formatDuration(60))
    }

    @Test
    fun `zero minutes is allowed`() {
        assertEquals("0m", formatDuration(0))
    }

    @Test
    fun `negative duration is rejected`() {
        assertThrows(IllegalArgumentException::class.java) { formatDuration(-5) }
    }
}
