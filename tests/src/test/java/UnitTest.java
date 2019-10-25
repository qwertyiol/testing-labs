import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnitTest {
    @DisplayName("1 Test")
    @Test
    void FirstUnitTest(){
        assertFalse(Triangle.Check(1, 2, 3));
    }

    @DisplayName("2 Test")
    @Test
    void SecondUnitTest(){
        assertTrue(Triangle.Check(2, 4, 4));
    }

    @DisplayName("3 Test")
    @Test
    void ThirdUnitTest(){
        assertTrue(Triangle.Check(4, 4, 2));
    }

    @DisplayName("4 Test")
    @Test
    void FourthUnitTest(){
        assertFalse(Triangle.Check(1, 0, 3));
    }

    @DisplayName("5 Test")
    @Test
    void FifthUnitTest(){
        assertFalse(Triangle.Check(1, -2, 0));
    }

    @DisplayName("6 Test")
    @Test
    void SixthUnitTest(){
        assertTrue(Triangle.Check(1, 1, 1));
    }

    @DisplayName("7 Test")
    @Test
    void SeventhUnitTest(){
        assertFalse(Triangle.Check(1, -1, 1));
    }

    @DisplayName("8 Test")
    @Test
    void EighthUnitTest(){
        assertFalse(Triangle.Check(0, 2, 0));
    }

    @DisplayName("9 Test")
    @Test
    void NinthUnitTest(){
        assertTrue(Triangle.Check(10, 2, 10));
    }

    @DisplayName("10 Test")
    @Test
    void TenthUnitTest(){
        assertFalse(Triangle.Check(3, 100, 2));
    }

}
