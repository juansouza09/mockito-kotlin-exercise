package com.example.projeto_teste_unitario_mockito


import android.content.Context
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock

private const val FAKE_STRING = "HELLO WORLD"

@RunWith(MockitoJUnitRunner::class)
class ExampleUnitTest {

    @Mock
    private lateinit var mockContext: Context

    @Test
    fun readStringFromContext_LocalizedString() {
        // Given a mocked Context injected into the object under test...
        val mockContext = mock<Context> {
            on { getString(R.string.hello_world) } doReturn FAKE_STRING
        }

        val myObjectUnderTest = ContextWrapper(mockContext)

        // ...when the string is returned from the object under test...
        val result: String = myObjectUnderTest.getTitle()

        // ...then the result should be the expected one.
        assertEquals(result, FAKE_STRING)
    }
}