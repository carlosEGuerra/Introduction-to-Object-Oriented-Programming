package cs1410;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * In this assignment we were assigned to implement the methods and test cases so that it replicates what P5Demo.jar shows. 
 * We had to implement a method that reads into 2 ArrayLists a scanner and a method that manipulates said data. We also had to implement
 * a method to draw the graphs.
 * 
 * @author Carlos Guerra(u0847821) implemented the methods and test cases for this assignment
 * @author Joe Zachary made the JavaDocs and P5Demo.jar for the methods
 */
public class GraphingMethods
{
    /**
     * Constant used to request a max operation
     */
    public final static int MAX = 0;

    /**
     * Constant used to request a min operation
     */
    public final static int MIN = 1;

    /**
     * Constant used to request a sum operation
     */
    public final static int SUM = 2;

    /**
     * Constant used to request an average operation
     */
    public final static int AVG = 3;

    /**
     * If names and values have different lengths, throws an IllegalArgumentException.
     * 
     * If values contains any non-positive numbers, throws an IllegalAgumentException.
     * 
     * If categories is of length zero, throws an IllegalArgumentException.
     * 
     * If categories contains any duplicates, throws an IllegalArgumentException.
     * 
     * If operation is anything other than SUM, AVG, MAX, or MIN, throws an IllegalArgumentException.
     * 
     * Put side-by-side, the lists "names" and "values" represent a table of values, where each row contains a name and
     * a value. For example, here is the table of values that might give the number of people named Zebediah in
     * different parts of four states.
     * 
     * <pre>
     *  Utah          5
     *  Nevada        6
     *  California   12
     *  Oregon        8
     *  Utah          9
     *  California   10
     *  Nevada        4
     *  Nevada        4
     *  Oregon       17
     *  California    6
     * </pre>
     * 
     * We can make a table of summaries by pairing each string c from the list "categories" with either the sum,
     * average, maximum, or minimum of the numbers paired with c in the table above. For example, if "categories" is
     * 
     * <pre>
     *  Utah
     *  Nevada
     *  California
     * </pre>
     * 
     * then, assuming we are summing, the table of summaries would be
     *
     * <pre>
     *  Utah       14 
     *  Nevada     14 
     *  California 28
     * </pre>
     * 
     * The method should calculate and return, as an ArrayList<Double>, the second column of the table of summaries. It
     * should use the value of the "operation" parameter to determine whether the values are combined by summing,
     * averaging, max-ing, or min-ing. (If, for any category, there are no values to sum, average, min, or max, the
     * method should throw an IllegalArgumentException.)
     * 
     * The order of the numbers in the returned ArrayList<Double> should correspond to the order of the categories in
     * the "categories" list.
     */
    public static ArrayList<Double> summarizeData (ArrayList<String> names, ArrayList<Double> values,
            ArrayList<String> categories, int operation)
    {
        // checks the names and vales size
        try
        {
            if (names.size() != values.size())
            {
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Looks like you either need more names or values!");
            return null;
        }
        // checks the categories size
        try
        {
            if (categories.size() == 0)
            {
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Sorry, but you have no categories!");
            return null;
        }
        switch (operation)
        {
            case MAX:
                return maxCalc(names, values, categories);
            case MIN:
                return minCalc(names, values, categories);
            case SUM:
                return sumCalc(names, values, categories);
            case AVG:
                return avgCalc(names, values, categories);
            //if the operations above are not chosen do this
            default:
                throw new IllegalArgumentException();
        }
    }

    private static ArrayList<Double> avgCalc (ArrayList<String> names, ArrayList<Double> values,
            ArrayList<String> categories)
    {
        ArrayList<Double> result = new ArrayList<Double>(categories.size());
        // cycles through the categories list
        for (int i = 0; i < categories.size(); i++)
        {
            double count = 0.0;
            double sum = 0.0;
            // cycles through the names ArrayList
            for (int j = 0; j < names.size(); j++)
            {
                if (categories.get(i).equals(names.get(j)))
                {
                    sum += values.get(j);
                    count++;
                }
            }
            result.add(i, sum / count);
        }
        return result;
    }

    private static ArrayList<Double> sumCalc (ArrayList<String> names, ArrayList<Double> values,
            ArrayList<String> categories)
    {
        ArrayList<Double> result = new ArrayList<Double>();
        // cycles through the categories list
        for (int i = 0; i < categories.size(); i++)
        {
            double sum = 0.0;
            // cycles through the names ArrayList
            for (int j = 0; j < names.size(); j++)
            {
                if (categories.get(i).equals(names.get(j)))
                {
                    sum += values.get(j);
                }
            }
            result.add(i, sum);
        }
        return result;
    }

    private static ArrayList<Double> minCalc (ArrayList<String> names, ArrayList<Double> values,
            ArrayList<String> categories)
    {
        ArrayList<Double> result = new ArrayList<Double>(categories.size());
        // cycles through the categories list
        for (int i = 0; i < categories.size(); i++)
        {
            double temp = values.get(i);
            // cycles through the names ArrayList
            for (int j = 0; j < names.size(); j++)
            {
                if (categories.get(i).equals(names.get(j)) && values.get(j) < temp)
                {
                    temp = values.get(j);
                }
            }
            result.add(i, temp);
        }
        return result;
    }

    private static ArrayList<Double> maxCalc (ArrayList<String> names, ArrayList<Double> values,
            ArrayList<String> categories)
    {
        ArrayList<Double> result = new ArrayList<Double>();
        // cycles through the categories list
        for (int i = 0; i < categories.size(); i++)
        {
            double temp = 0;
            // cycles through the names list
            for (int j = 0; j < names.size(); j++)
            {
                if (categories.get(i).equals(names.get(j)) && values.get(j) > temp)
                {
                    temp = values.get(j);
                }
            }
            result.add(i, temp);
        }
        return result;
    }

    /**
     * If categories, summaries, or colors is empty, throws an IllegalArgumentException.
     * 
     * If categories, summaries, and colors don't have the same number of elements, throws an IllegalArgumentException.
     * 
     * If any of the numbers in summaries is non-positive, throws an IllegalArgumentException.
     * 
     * Otherwise, views the three lists as a table with a String, a double, and a Color in each column and displays the
     * data with either a pie chart (if usePieChart is true) or a bar graph (otherwise). Let SUM be the sum of all the
     * entries in summaries. The area of slice i (of a pie chart) and the length of bar i (in a bar graph) should be
     * proportional to categories[i]/SUM. The slice/bar should be labeled with categories[i] and summaries[i], and it
     * should be colored with colors[i].
     * 
     * For example, suppose we are given this data:
     * 
     * <pre>
     *  Utah       14    Color.RED
     *  Nevada     14    Color.BLUE
     *  California 28    Color.GREEN
     * </pre>
     * 
     * In a pie chart Utah and Nevada should each have a quarter of the pie and California should have half. In a bar
     * graph, California's line should be twice as long as Utah's and Nevada's.
     * 
     * The method should display the pie chart or bar graph by drawing on the g parameter. The example code below draws
     * both a pie chart and a bar graph for the situation described above.
     */
    public static void drawGraph (Graphics g, ArrayList<String> categories, ArrayList<Double> summaries,
            ArrayList<Color> colors, boolean usePieChart)
    {
        // checks if categories, summaries, and colors are empty
        try
        {
            if (categories.isEmpty() || summaries.isEmpty() || colors.isEmpty())
            {
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Sorry, but there is an empty ArrayList here!");
        }
        // checks if there is a difference in size for categories, summaries, and colors
        try
        {
            if (categories.size() != summaries.size() || summaries.size() != colors.size()
                    || categories.size() != colors.size())
            {
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Sorry, you have more in one ArrayList than the others!");
        }
        // if pie chart is selected it will run this part of the code
        if (usePieChart)
        {
            // finds the sum of the summaries
            double tableSum = 0;
            for (int i = 0; i < summaries.size(); i++)
            {
                tableSum += summaries.get(i);
            }
            // finds the percentage for each summary
            ArrayList<Double> percentages = new ArrayList<Double>();
            for (int i = 0; i < summaries.size(); i++)
            {
                percentages.add(summaries.get(i) / tableSum);
            }
            // sets the angle for each percentage
            for (int i = 0; i < percentages.size(); i++)
            {
                percentages.set(i, (double) Math.round(percentages.get(i) * 360));
            }
            // this draws each part of the graph
            int j = 0;
            int angle = (int) 0;
            int pastAngle = 0;
            for (int i = 0; i < categories.size(); i++)
            {
                Color colorSet = colors.get(j);// gets the color out of the array list
                g.setColor(colorSet);// Sets the color from the array list
                g.fillRect(330, 10 + (i * 15), 10, 10);
                angle = (int) Math.round(percentages.get(i)); // rounds the percentages
                g.fillArc(10, 10, 300, 300, pastAngle, angle + 1);// draws the graph
                pastAngle = (int) (angle + pastAngle);// sets the next starting angle
                g.setColor(Color.black);
                g.drawString(categories.get(j) + " " + summaries.get(j), 350, 20 + (15 * j));
                j++;// increments index value j
            }
        }
        // if pie chart is not selected, it will run this
        else
        {
            // finds the sum of the summaries
            double tableSum = 0;
            for (int i = 0; i < summaries.size(); i++)
            {
                tableSum += summaries.get(i);
            }
            // sets the percentage for each summary
            ArrayList<Double> percentages = new ArrayList<Double>();
            for (int i = 0; i < summaries.size(); i++)
            {
                percentages.add(summaries.get(i) / tableSum);
            }
            // sets the angle for each percentage
            for (int i = 0; i < percentages.size(); i++)
            {
                percentages.set(i, (double) Math.round(percentages.get(i) * 360));
            }
            // this draws each part of the graph
            for (int i = 0; i < categories.size(); i++)
            {
                Color colorSet = colors.get(i);// gets the color out of the array list
                g.setColor(colorSet);// Sets the color from the array list
                int length = (int) (percentages.get(i) - 10);// Gets the length at i, and converts it into an int
                g.fillRect(200, 10 + (30 * i), length, 20);// (Y, X length, width)
                g.setColor(Color.black);
                g.drawString(categories.get(i) + " " + summaries.get(i), 330, 25 + (30 * i));// Displays the name for the data
            }
        }
    }

    /**
     * The dataSource should consist of zero or more lines. Each line should consist of some text, followed by a tab
     * character, followed by a double literal, followed by a newline.
     * 
     * If any lines are encountered that don't meet this criteria, the method throws an IllegalArgumentException whose
     * message explains what is wrong.
     * 
     * Otherwise, for each line, the text before the tab is added to names, and the parsed double literal is added to
     * values.
     */
    public static void readTable (Scanner dataSource, ArrayList<String> names, ArrayList<Double> values)
    {
        try
        {
            // runs while there is another line
            while (dataSource.hasNext())
            {
                double temp = 0.0;  // Initialize a temporary variable
                names.add(dataSource.next().toString());    // Reads in the state
                try
                {
                    // checks to see if the second token is doubles
                    temp = Double.parseDouble(dataSource.next());
                }
                catch (IllegalArgumentException e)
                {
                    System.out.println("Sorry but that isn't a double!");
                    return;
                }
                values.add(temp);// Reads in the values
            }
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Sorry but you need more lines!");
            return;
        }
    }
}