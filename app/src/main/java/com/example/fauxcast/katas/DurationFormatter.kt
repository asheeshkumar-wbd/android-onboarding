package com.example.fauxcast.katas

fun formatDuration(totalMinutes: Int): String {
    require(totalMinutes >= 0) { "Duration cannot be negative: $totalMinutes" }
    val hours = totalMinutes / 60
    val minutes = totalMinutes % 60
    return if (hours > 0) "${hours}h ${minutes}m" else "${minutes}m"
}
