import kotlin.test.Test
import kotlin.test.assertEquals

class MathTests {
    @Test
    fun `two ints can be added together correctly`() {
        assertEquals(add(1, 2), 3)
    }
}
