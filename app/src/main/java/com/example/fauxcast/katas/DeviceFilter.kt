package com.example.fauxcast.katas

/*
 * Kata — Filtering by name   (Phase 0: collections & lambdas)
 *
 * Uses a generic Item type defined here — no app dependencies.
 *
 * PART A — filterByName(items, query):
 *   1. blank query (empty or only whitespace) -> return ALL items.
 *   2. otherwise -> items whose name CONTAINS query, case-insensitive.
 *   3. trim the query before matching (so " an " behaves like "an").
 *   4. return a new list; never mutate the input.
 *
 *   Scenarios to cover:
 *     - "an"  -> [Banana]
 *     - "A"   -> [Apple, Banana]        (case-insensitive)
 *     - "z"   -> []                     (no match)
 *     - ""    -> all items
 *     - "   " -> all items              (blank)
 *     - " an "-> [Banana]               (query trimmed)
 *     - empty input list -> []
 *
 * PART B (stretch) — namesSorted(items): List<String>
 *   - return just the names, sorted A..Z (practice map + sortedBy).
 *     Scenario: [Banana, Apple] -> ["Apple", "Banana"]
 *
 * Hints: list.filter { }, String.contains(other, ignoreCase = true), query.isBlank(), query.trim()
 * Then write tests in katas/DeviceFilterTest.kt.
 */
data class Item(val id: String, val name: String)

fun filterByName(items: List<Item>, query: String): List<Item> {
    if(query.isNotBlank()) {
        val q = query.trim()
       val result = items.filter {
           it.name.contains(q, ignoreCase = true)
       }
        return result
    }
    return items
}
fun namesSorted(items: List<Item>): List<String> {
    return items.map { it.name }.sorted()
}

