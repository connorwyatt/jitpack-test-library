import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MathTests {
    @Test
    fun `two ints can be added together correctly`() {
        assertEquals(add(1, 2), 3)
    }
}
