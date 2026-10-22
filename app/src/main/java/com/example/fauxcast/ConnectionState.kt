package com.example.fauxcast

enum class CastDeviceType {
    TV,
    SPEAKER,
    DISPLAY,
}

data class CastDevice (
    val id: String,
    val name: String,
    val type: CastDeviceType
)

sealed class ConnectionState {
    data object Disconnected : ConnectionState()
    data object Discovering: ConnectionState()
    data class Connecting(val device: CastDevice): ConnectionState()
    data class Connected(val device: CastDevice): ConnectionState()
    data object Reconnecting: ConnectionState()
    data class Failed(val reason: String): ConnectionState()
}

fun isLegalTransition(from: ConnectionState, to: ConnectionState): Boolean =
    when (from) {
        is ConnectionState.Disconnected -> to is ConnectionState.Discovering
        is ConnectionState.Discovering -> to is ConnectionState.Disconnected || to is ConnectionState.Connecting
        is ConnectionState.Connecting -> to is ConnectionState.Connected || to is ConnectionState.Disconnected || to is ConnectionState.Failed
        is ConnectionState.Connected -> to is ConnectionState.Reconnecting || to is ConnectionState.Disconnected
        is ConnectionState.Reconnecting -> to is ConnectionState.Connected || to is ConnectionState.Failed || to is ConnectionState.Disconnected
        is ConnectionState.Failed -> to is ConnectionState.Discovering || to is ConnectionState.Disconnected
    }