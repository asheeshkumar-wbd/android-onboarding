package com.example.fauxcast.katas

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class PlaybackStateTest {

    // positionOf
    @Test
    fun `positionOf returns position for Playing`() {
        assertEquals(5000L, positionOf(PlaybackState.Playing(5000L)))
    }

    @Test
    fun `positionOf returns position for Paused`() {
        assertEquals(10L, positionOf(PlaybackState.Paused(10L)))
    }

    @Test
    fun `positionOf is null for non-positional states`() {
        assertNull(positionOf(PlaybackState.Idle))
        assertNull(positionOf(PlaybackState.Buffering))
        assertNull(positionOf(PlaybackState.Ended))
        assertNull(positionOf(PlaybackState.Error("x")))
    }

    // isActive
    @Test
    fun `isActive is true while buffering or playing or paused`() {
        assertTrue(isActive(PlaybackState.Buffering))
        assertTrue(isActive(PlaybackState.Playing(1L)))
        assertTrue(isActive(PlaybackState.Paused(1L)))
    }

    @Test
    fun `isActive is false when idle ended or error`() {
        assertFalse(isActive(PlaybackState.Idle))
        assertFalse(isActive(PlaybackState.Ended))
        assertFalse(isActive(PlaybackState.Error("x")))
    }

    // label
    @Test
    fun `label describes each state`() {
        assertEquals("Idle", label(PlaybackState.Idle))
        assertEquals("Buffering", label(PlaybackState.Buffering))
        assertEquals("Ended", label(PlaybackState.Ended))
        assertEquals("Error: network lost", label(PlaybackState.Error("network lost")))
        assertEquals("Playing at 5000", label(PlaybackState.Playing(5000L)))
        assertEquals("Paused at 10", label(PlaybackState.Paused(10L)))
    }

    // advance
    @Test
    fun `advance moves position forward for Playing and Paused`() {
        assertEquals(PlaybackState.Playing(1500L), advance(PlaybackState.Playing(1000L), 500L))
        assertEquals(PlaybackState.Paused(1500L), advance(PlaybackState.Paused(1000L), 500L))
    }

    @Test
    fun `advance leaves other states unchanged`() {
        assertEquals(PlaybackState.Idle, advance(PlaybackState.Idle, 500L))
        assertEquals(PlaybackState.Ended, advance(PlaybackState.Ended, 500L))
        assertEquals(PlaybackState.Error("x"), advance(PlaybackState.Error("x"), 500L))
    }
}
