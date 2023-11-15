import org.junit.jupiter.api.Test;
import pl.krysinski.Main;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void getSortedDistinctNumbersTest() {
        //given
        int[] inputArray = {1, 10, 20, 20, 2, 5};
        Set<Integer> expectedSet = new TreeSet<>(Arrays.asList(1, 2, 5, 10, 20));
        //when
        Set<Integer> result = Main.getSortedDistinctNumbers(inputArray);
        //then
        assertEquals(expectedSet, result);
    }

    @Test
    public void getIntegerArrayTest() {
        //given
        String[] inputStringArray = {"3", "1", "2", "2", "4", "3", "5"};
        int[] expectedArray = {3, 1, 2, 2, 4, 3, 5};
        //when
        int[] result = Main.getIntegerArray(inputStringArray);
        //then
        assertArrayEquals(expectedArray, result);
    }

    @Test
    public void mainTest() {
        //given
        String simulatedInput = "3 1 2 2 4 3 5";
        System.setIn(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));

        java.io.ByteArrayOutputStream outputStream = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outputStream));
        //when
        Main.main(new String[0]);
        //then
        String expectedOutput = "Enter numbers of integers seperated by a space: \r\n[1, 2, 3, 4, 5]\r\ncount: 7\r\ndistinct: 5\r\nmin: 1\r\nmax: 5\r\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void mainTestWithError() {
        //given
        String simulatedInput = "3 1 f 2 4 3 5";
        System.setIn(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));

        java.io.ByteArrayOutputStream outputStream = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outputStream));
        //when
        Main.main(new String[0]);
        //then
        String expectedOutput = "Enter numbers of integers seperated by a space: \r\nError: Only integers!\r\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}








