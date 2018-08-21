package ch.streamly.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReplayValueImplTest {

    @Test
    @DisplayName("test equals and hashcode")
    void testDataClass() {
        String value = "testValue";
        ReplayValue<String> first = new ReplayValueImpl<>(true, value);
        ReplayValue<String> second = new ReplayValueImpl<>(true, value);
        ReplayValue<String> third = new ReplayValueImpl<>(false, value);
        assertEquals(first, second);
        assertEquals(first, first);
        assertNotEquals(first, value);
        assertNotEquals(first, third);
        assertEquals(first.hashCode(), second.hashCode());
    }

    @Test
    @DisplayName("test equals and hashcode with null value")
    void testDataClassWithNullValue() {
        ReplayValue<String> first = new ReplayValueImpl<>(true, null);
        ReplayValue<String> second = new ReplayValueImpl<>(true, null);
        ReplayValue<String> third = new ReplayValueImpl<>(false, null);
        assertEquals(first, second);
        assertEquals(first, first);
        assertNotEquals(first, third);
        assertEquals(first.hashCode(), second.hashCode());
    }

    @Test
    @DisplayName("test default constructors")
    void testDefaultConstructors() {
        String val = "test";
        ReplayValue replayValue = ReplayValue.newValue(val);
        assertEquals(val, replayValue.value());
        assertFalse(replayValue.isLoopRestart());

        replayValue = ReplayValue.newLoopRestartValue(val);
        assertEquals(val, replayValue.value());
        assertTrue(replayValue.isLoopRestart());
    }

}