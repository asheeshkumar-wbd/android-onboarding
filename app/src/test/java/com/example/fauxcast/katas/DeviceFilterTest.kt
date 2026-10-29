package com.example.fauxcast.katas

import org.junit.Assert.assertEquals
import org.junit.Test

class DeviceFilterTest {

    private val apple = Item("1", "Apple")
    private val banana = Item("2", "Banana")
    private val items = listOf(apple, banana)

    @Test
    fun `matches a substring`() {
        assertEquals(listOf(banana), filterByName(items, "an"))
    }

    @Test
    fun `match is case-insensitive`() {
        assertEquals(listOf(apple, banana), filterByName(items, "A"))
    }

    @Test
    fun `no match returns empty list`() {
        assertEquals(emptyList<Item>(), filterByName(items, "z"))
    }

    @Test
    fun `empty query returns all items`() {
        assertEquals(items, filterByName(items, ""))
    }

    @Test
    fun `blank query returns all items`() {
        assertEquals(items, filterByName(items, "   "))
    }

    @Test
    fun `query is trimmed before matching`() {
        assertEquals(listOf(banana), filterByName(items, "  an  "))
    }

    @Test
    fun `filtering an empty list returns empty`() {
        assertEquals(emptyList<Item>(), filterByName(emptyList(), "a"))
    }

    @Test
    fun `namesSorted returns names A to Z`() {
        assertEquals(listOf("Apple", "Banana"), namesSorted(listOf(banana, apple)))
    }

    @Test
    fun `namesSorted of empty list is empty`() {
        assertEquals(emptyList<String>(), namesSorted(emptyList()))
    }
}
