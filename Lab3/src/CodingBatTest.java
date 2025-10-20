import static org.junit.Assert.*;

public class CodingBatTest {

    @org.junit.Test
    public void sleepIn() {
        assertTrue(CodingBat.sleepIn(false,false));
        assertFalse(CodingBat.sleepIn(true,false));
        assertTrue(CodingBat.sleepIn(false,true));
        assertTrue(CodingBat.sleepIn(true,true));
    }

    @org.junit.Test
    public void monkeyTrouble() {
        assertTrue(CodingBat.monkeyTrouble(true,true));
        assertTrue(CodingBat.monkeyTrouble(false,false));
        assertFalse(CodingBat.monkeyTrouble(true,false));
        assertFalse(CodingBat.monkeyTrouble(false,true));
    }

    @org.junit.Test
    public void helloName() {
        assertEquals("Hello Bob!", CodingBat.helloName("Bob"));
        assertEquals("Hello Alice!", CodingBat.helloName("Alice"));
        assertEquals("Hello X!", CodingBat.helloName("X"));
        assertEquals("Hello xyz!!", CodingBat.helloName("xyz!"));
        assertEquals("Hello Hello!", CodingBat.helloName("Hello"));
    }

    @org.junit.Test
    public void countEvens() {
        assertEquals(3, CodingBat.countEvens(new int[]{2, 1, 2, 3, 4}));
        assertEquals(3, CodingBat.countEvens(new int[]{2, 2, 0}));
        assertEquals(0, CodingBat.countEvens(new int[]{1, 3, 5}));
        assertEquals(0, CodingBat.countEvens(new int[]{}));
        assertEquals(1, CodingBat.countEvens(new int[]{11,9,0,1}));
        assertEquals(2, CodingBat.countEvens(new int[]{2,11,9,0}));
    }
}