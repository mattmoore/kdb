package kdb

import kotlin.test.Test
import kotlin.test.assertEquals

class KDBTest {
    @Test
    fun helloGreetsUser() {
        assertEquals("Hello Matt!", hello("Matt"))
    }
}
