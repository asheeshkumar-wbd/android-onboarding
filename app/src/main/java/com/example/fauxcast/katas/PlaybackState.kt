package com.example.fauxcast.katas

/*
 * Kata — Playback state model   (Phase 0: sealed classes & when)
 *
 * The sealed class below models playback. Read it with an EXHAUSTIVE `when (state)`
 * and NO else branch (the whole point of sealed classes).
 *
 * PART A — positionOf(state): Long?  -> positionMs for Playing/Paused, else null.
 *   Scenarios: Playing(5000)->5000 ; Paused(10)->10 ; Idle->null ; Buffering->null ;
 *              Ended->null ; Error("x")->null
 *
 * PART B — isActive(state): Boolean  -> true for Buffering/Playing/Paused, false otherwise.
 *   Scenarios: Buffering->true ; Playing(1)->true ; Paused(1)->true ;
 *              Idle->false ; Ended->false ; Error("x")->false
 *
 * PART C (stretch) — label(state): String  -> human-readable:
 *   Idle->"Idle", Buffering->"Buffering", Playing->"Playing", Paused->"Paused",
 *   Ended->"Ended", Error(r)->"Error: $r"
 *
 * PART D (stretch) — advance(state, deltaMs): PlaybackState
 *   - for Playing/Paused: return a NEW state with positionMs + deltaMs (use copy()).
 *   - every other state: return it unchanged.
 *   Scenario: advance(Playing(1000), 500) -> Playing(1500) ; advance(Idle, 500) -> Idle
 *
 * Then write tests in katas/PlaybackStateTest.kt covering each state.
 */
sealed class PlaybackState {
    data object Idle : PlaybackState()
    data object Buffering : PlaybackState()
    data class Playing(val positionMs: Long) : PlaybackState()
    data class Paused(val positionMs: Long) : PlaybackState()
    data object Ended : PlaybackState()
    data class Error(val reason: String) : PlaybackState()
}

fun positionOf(state: PlaybackState): Long? = when(state) {
    is PlaybackState.Playing -> state.positionMs
    is PlaybackState.Paused -> state.positionMs
    is PlaybackState.Error -> null
    is PlaybackState.Idle -> null
    is PlaybackState.Buffering -> null
    is PlaybackState.Ended -> null
}
fun isActive(state: PlaybackState): Boolean = when(state) {
    is PlaybackState.Playing -> true
    is PlaybackState.Buffering -> true
    is PlaybackState.Paused -> true
    else -> false
}

fun label(state: PlaybackState): String = when(state) {
    is PlaybackState.Playing -> "Playing at ${state.positionMs}"
    is PlaybackState.Paused -> "Paused at ${state.positionMs}"
    is PlaybackState.Error -> "Error: ${state.reason}"
    is PlaybackState.Idle -> "Idle"
    is PlaybackState.Buffering -> "Buffering"
    is PlaybackState.Ended -> "Ended"
}

fun advance(state: PlaybackState, deltaMs: Long): PlaybackState = when (state) {
    is PlaybackState.Playing -> state.copy(positionMs = state.positionMs + deltaMs)
    is PlaybackState.Paused  -> state.copy(positionMs = state.positionMs + deltaMs)
    else -> state
}