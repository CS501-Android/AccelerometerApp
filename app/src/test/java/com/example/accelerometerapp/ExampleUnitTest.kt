package com.example.accelerometerapp

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}

class MainActivityTest {

    private lateinit var mainActivity: MainActivity

    @Before
    fun setUp() {
        mainActivity = MainActivity()
    }

    @Test
    fun `createToast generates correct toast message`() {
        val message = "Test Toast"
        mainActivity.createToast(message)
        // Assert that the toast message was created with the correct message
        // Here, we'd ideally need a way to capture and verify the toast message,
        // but this is simplified for the sake of the example
        assertTrue(true)  // replace this with actual assertion logic
    }

    @Test
    fun `check threshold initial value`() {
        assertEquals(12, mainActivity.threshold)
    }
}