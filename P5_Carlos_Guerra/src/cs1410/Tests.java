package cs1410;

import static cs1410.GraphingMethods.AVG;
import static cs1410.GraphingMethods.MAX;
import static cs1410.GraphingMethods.MIN;
import static cs1410.GraphingMethods.SUM;
import static cs1410.GraphingMethods.readTable;
import static cs1410.GraphingMethods.summarizeData;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import org.junit.Test;

/**
 * 
 * These test cases were implemented entirely by myself.
 * @author Carlos Guerra(u0847821)
 */
public class Tests
{
    // Initializes the testing ArrayLists
    private final ArrayList<String> names = new ArrayList<String>(Arrays.asList("Interstellar", "Dark", "Martian",
            "Interstellar"));
    private final ArrayList<Double> values = new ArrayList<Double>(Arrays.asList(165.5, 180.1, 108.2, 200.0));
    private final ArrayList<String> categories = new ArrayList<String>(Arrays.asList("Interstellar", "Dark", "Martian"));

    /**
     * This tests out the radTable methods for both values and names output
     */
    @Test
    public void readTableTestNames ()
    {
        // Creates 2 empty ArrayLists that will store the parsed scanner
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<Double> values = new ArrayList<Double>();

        // Test scanner
        Scanner scanTest = new Scanner("Interstellar\t165.5\nDark\t180.1\nMartian\t108.2\nInterstellar\t200.0\n");

        // Call the readTable method to run for this scanner and store the values in names and values
        // in respect to their position in the scanner
        readTable(scanTest, names, values);

        // Creation of an ArrayList that will be compared to the names output of readTable
        ArrayList<String> namesGoal = new ArrayList<String>(Arrays.asList("Interstellar", "Dark", "Martian",
                "Interstellar"));

        // checks the result
        assertEquals(namesGoal, names);
    }

    @Test
    public void readTableTestValues ()
    {
        // Creates 2 empty ArrayLists that will store the parsed scanner
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<Double> values = new ArrayList<Double>();

        // Test scanner
        Scanner scanTest = new Scanner("Interstellar\t165.5\nDark\t180.1\nMartian\t108.2\nInterstellar\t200.0\n");

        // Call the readTable method to run for this scanner and store the values in names and values
        // in respect to their position in the scanner
        readTable(scanTest, names, values);

        // Creation of an ArrayList that will be compared to the names output of readTable
        ArrayList<Double> valuesGoal = new ArrayList<Double>(Arrays.asList(165.5, 180.1, 108.2, 200.0));

        // checks the result
        assertEquals(valuesGoal, values);
    }

    /**
     * This part of the test tests out the summarizeData method and its helper methods for MIN, MAX, SUM, AVG.
     */
    @Test(expected = IllegalArgumentException.class)
    public void CatOutOfPlaceException()
    {
     // sets the resulting ArrayList
        ArrayList<Double> result = new ArrayList<Double>(Arrays.asList(200.0, 180.1, 108.2));

        // Test
        assertEquals(result, summarizeData(names, values, categories, 5));
    }
    @Test (expected = IllegalArgumentException.class)
    public void CatLengthZeroException()
    {
        ArrayList<String> categoriesTest = new ArrayList<>();
        // sets the resulting ArrayList
        ArrayList<Double> result = new ArrayList<Double>(Arrays.asList(200.0, 180.1, 108.2));

        // Test
        assertEquals(result, summarizeData(names, values, categoriesTest, 5));
        fail();
    }
    @Test (expected = IllegalArgumentException.class)
    public void CatDuplicateException()
    {
        ArrayList<String> categoriesTest = new ArrayList<>(Arrays.asList("Interstellar", "Interstellar", "Martian", "Dark"));
        // sets the resulting ArrayList
        ArrayList<Double> result = new ArrayList<Double>(Arrays.asList(200.0, 180.1, 108.2));

        // Test
        assertEquals(result, summarizeData(names, values, categoriesTest, 5));
    }
    
    @Test
    public void summarizeDataTestMAX ()
    {
        // sets the resulting ArrayList
        ArrayList<Double> result = new ArrayList<Double>(Arrays.asList(200.0, 180.1, 108.2));

        // Test
        assertEquals(result, summarizeData(names, values, categories, MAX));
    }

    @Test
    public void summarizeDataTestMIN ()
    {
        // sets the resulting ArrayList
        ArrayList<Double> result = new ArrayList<Double>(Arrays.asList(165.5, 180.1, 108.2));

        // Test
        assertEquals(result, summarizeData(names, values, categories, MIN));
    }

    @Test
    public void summarizeDataTestSUM ()
    {
        // sets the resulting ArrayList
        ArrayList<Double> result = new ArrayList<Double>(Arrays.asList(365.5, 180.1, 108.2));

        // Test
        assertEquals(result, summarizeData(names, values, categories, SUM));
    }

    @Test
    public void summarizeDataTestAVG ()
    {
        // sets the resulting ArrayList
        ArrayList<Double> result = new ArrayList<Double>(Arrays.asList(182.75, 180.1, 108.2));

        // Test
        assertEquals(result, summarizeData(names, values, categories, AVG));
    }
}