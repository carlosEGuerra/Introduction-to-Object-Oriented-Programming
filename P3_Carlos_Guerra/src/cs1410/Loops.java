package cs1410;

import java.util.*;

/**
 * CS 1410
 * 
 * @author Carlos Guerra(u0847821)
 *         
 *         The Loops class was made by myself and the test cases were
 *         made by the Instructor(Joe Zachary).
 */

public class Loops
{

    public static void main (String[] args)
    {
    }

    /**
     * countFactors takes a positive integer n as its parameter, and returns an int. It returns the number of positive
     * factors of n. (Implementation note: This calls for an accumulation loop.)
     */
    public static int countFactors (int n)
    {
        if (n <= 0)
        {
            return 0;
        }
        int returnValue = 0;
        for (int divisor = n; divisor > 0; divisor--)
        {
            if (n % divisor == 0)
            {
                returnValue++;
            }
        }
        return returnValue;
    }

    /**
     * countWhitespace takes a String s as a parameter and returns an int. It returns the number of whitespace
     * characters contained in s. (Implementation note: The Java Character class has a helpful method you can use. This
     * method calls for an accumulation loop.)
     */
    public static int countWhitespace (String s)
    {
        int whitespaceCount = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (Character.isWhitespace(s.charAt(i)))
            {
                whitespaceCount++;
            }
        }
        return whitespaceCount;
    }

    /**
     * averageTokenLength takes a Scanner s as a parameter and returns a double. The Scanner is required to contain only
     * double literals separated by white space. If s contains no tokens, it returns 0. Otherwise, it returns the
     * average length of all the tokens in s. (Implementation note: This method calls for an accumulation loop, with a
     * twist.)
     */
    public static double averageTokenLength (Scanner s)
    {
        double countTokens = 0, countLetters = 0;
        if (!s.hasNext())
        {
            return 0;
        }
        while (s.hasNext())
        {
            countLetters += s.next().length();
            countTokens++;
        }
        return countLetters / countTokens;
    }

    /**
     * containsToken takes a String s and a String t as parameters, and returns a boolean. It returns true if t occurs
     * as a token within s, and returns false otherwise. (Implementation note: Use a Scanner to break s into tokens.
     * Compare strings with the .equals method, NOT with ==. This method calls for a searching loop.)
     */
    public static boolean containsToken (String s, String t)
    {
        Scanner scan = new Scanner(s);
        while (scan.hasNext())
        {
            if (scan.next().equals(t))
            {
                scan.close();
                return true;
            }
        }
        scan.close();
        return false;
    }

    /**
     * findLineWithToken takes a Scanner s and a String t as parameters, and returns a String. It returns a line from s
     * that contains t as a token (if such a line exists) and returns null otherwise. (Implementation note: You will
     * find the Scanner methods hasNextLine() and nextLine() helpful here. You'll find the containsToken specified above
     * helpful as well. This method calls for a searching loop.)
     */
    public static String findLineWithToken (Scanner s, String t)
    {
        String temp = "";
        // checks whether if there is a next line and runs the respected code
        if (s.hasNextLine())
        {
            while (s.hasNextLine())
            {
                temp = s.nextLine();
                if (containsToken(temp, t))
                {
                    // returns the string if it contains a desired token
                    return temp;
                }
            }
        }
        else
        {
            if (containsToken(s.toString(), t))
            {
                // returns the string if it contains a desired token
                return s.toString();
            }
        }
        // if the desired token is not present returns null
        return null;
    }

    /**
     * isPalindrome takes a String s as a parameter and returns a boolean. It returns true if s reads the same forwards
     * and backwards, and returns false otherwise. (Implementation note: This method calls for a searching loop, but
     * with several twists.)
     */
    public static boolean isPalindrome (String s)
    {
        String stringRev = "";
        for (int i = s.length() - 1; i >= 0; i--)
        {
            stringRev += s.charAt(i);
        }
        if (stringRev.equals(s))
        {
            return true;
        }
        return false;
    }

    /**
     * findSmallestFactor takes an integer n (which you may assume is greater than 1) and returns the smallest factor of
     * n that is greater than 1. (Implementation note: Despite its name, this method calls for a searching loop.)
     */
    public static int findSmallestFactor (int n)
    {
        int smallestFactor = 0;
        // runs through the loop while i > 1
        for (int i = n; i > 1; i--)
        {
            if (n % i == 0)
            {
                smallestFactor = i;
            }
        }
        return smallestFactor;
    }

    /**
     * findLongestPalindrome takes a Scanner s as its parameter and returns a String. It returns the longest token from
     * s that is a palindrome (if one exists) or the empty string (otherwise). (Implementation note: You'll find the
     * isPalindrome method helpful here. This method calls for an optimization loop.)
     */
    public static String findLongestPalindrome (Scanner s)
    {
        String longestPalindrome = "";
        String temp = "";
        while (s.hasNext())
        {
            temp = s.next();
            if (isPalindrome(temp))
            {
                if (temp.length() > longestPalindrome.length())
                {
                    longestPalindrome = temp;
                }
            }
        }
        return longestPalindrome;
    }

    /**
     * findLongestLine takes a Scanner s as its parameter and returns a String. It returns the longest line from s (if
     * one exists) or null (otherwise). (Implementation note: This method calls for an optimization loop.)
     */
    public static String findLongestLine (Scanner s)
    {
        String temp = "", returnString = "";
        int longestLineLength = 0;
        // checks whether s has another line
        if (!s.hasNextLine())
        {
            if (s.hasNext())
            {
                returnString = s.toString();
            }
            returnString = null;

        }
        // if s has another line runs this code
        else
        {
            while (s.hasNextLine())
            {
                // sets the temporary string to the next line converted to a string
                temp = s.nextLine();
                if (temp.length() > longestLineLength)
                {
                    // sets the return string to the temp string and the longest lines length to temp string length
                    returnString = temp;
                    longestLineLength = temp.length();
                }
            }
        }
        return returnString;
    }

    /**
     * findMostWhitespace takes a Scanner s as its parameter and returns a String. It returns the line from s that
     * contains the most whitespace (if one exists) or null (otherwise). (Implementation note: You'll find the
     * countWhitespace method specified above helpful. This method calls for an optimization loop.)
     */
    public static String findMostWhitespace (Scanner s)
    {
        String returnString = "", tempString = "";
        int whiteSpaceCount = 0, temp = 0;
        if (s.hasNextLine())
        {
            while (s.hasNextLine())
            {
                tempString = s.nextLine();
                temp = countWhitespace(tempString);
                if (temp > whiteSpaceCount)
                {
                    returnString = tempString;
                }
            }
        }
        else
        {
            returnString = null;
        }
        return returnString;
    }
}