package com.example.fauxcast

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ConnectionStateTest {

    private val device = CastDevice(id = "1", name = "Living Room TV", type = CastDeviceType.TV)

    @Test
    fun `disconnected can start discovering`() {
        assertTrue(isLegalTransition(ConnectionState.Disconnected, ConnectionState.Discovering))
    }

    @Test
    fun `happy path - discovering connects then becomes connected`() {
        assertTrue(isLegalTransition(ConnectionState.Discovering, ConnectionState.Connecting(device)))
        assertTrue(isLegalTransition(ConnectionState.Connecting(device), ConnectionState.Connected(device)))
    }

    @Test
    fun `connected can reconnect`() {
        assertTrue(isLegalTransition(ConnectionState.Connected(device), ConnectionState.Reconnecting))
    }

    @Test
    fun `failed can retry discovery`() {
        assertTrue(isLegalTransition(ConnectionState.Failed("network error"), ConnectionState.Discovering))
    }

    @Test
    fun `cannot jump from disconnected straight to connected`() {
        assertFalse(isLegalTransition(ConnectionState.Disconnected, ConnectionState.Connected(device)))
    }

    @Test
    fun `cannot connect while still disconnected`() {
        assertFalse(isLegalTransition(ConnectionState.Disconnected, ConnectionState.Connecting(device)))
    }

    @Test
    fun `failed cannot go straight to connected`() {
        assertFalse(isLegalTransition(ConnectionState.Failed("network error"), ConnectionState.Connected(device)))
    }
}