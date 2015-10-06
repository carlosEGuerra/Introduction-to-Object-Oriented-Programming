package cs1410;

import java.util.*;

/**
 * A collection of methods for the second assignment of CS 1410.
 * 
 * @author Carlos Guerra(u0847821)
 *         The instructions and test cases were done by the Instructor(Joe Zachary) and the methods were implemented by myself.
 */
public class MethodLibrary
{
    /**
     * You can use this main method for experimenting with your methods if you like, but it is not part of the
     * assignment.
     */
    public static void main (String[] args)
    {
    }

    /**
     * Reports whether or not the first character of word is a capital letter, where word is required to have at least
     * one character. For example, isCapitalized("hello") is false and isCapitalized("Jack") is true.
     * 
     * IMPLEMENTATION NOTE: The static method Character.isUpperCase() will be helpful. The method s.charAt() [where s is
     * a String] will also be helpful.
     */
    public static boolean isCapitalized (String word)
    {
        return Character.isUpperCase(word.charAt(0));
    }

    /**
     * Returns the string that results from capitalizing the first character of word, which is required to have at least
     * one character. For example, capitalize("hello") is "Hello" and capitalize("Jack") is "Jack".
     * 
     * IMPLEMENTATION NOTE: The static method Character.toUpperCase() will be helpful. The methods s.charAt() and
     * s.substring() [where s is a String] will also be helpful.
     */
    public static String capitalize (String word)
    {
        return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }

    /**
     * Returns the life stage of a person, given his or her age. The possible return values are "baby" (age is less than
     * 2), "child" (age is between 2 and 12 inclusive), "teen" (age is between 13 and 17 inclusive), "adult" (age is
     * between 18 and 64 inclusive), and "senior" (age is greater than 64).
     * 
     * @param age Must be non-negative
     * 
     *            IMPLEMENTATION NOTE: This will require a conditional
     */
    public static String getLifeStage (int age)
    {
        if (age < 2)
        {
            return "baby";
        }
        else if (age >= 2 && age <= 12)
        {
            return "child";
        }
        else if (age >= 13 && age <= 17)
        {
            return "teen";
        }
        else if (age >= 18 && age <= 64)
        {
            return "adult";
        }
        else
        {
            return "senior";
        }
    }

    /**
     * Reports whether or not c is a vowel ('a', 'e', 'i', 'o', 'u' or an upper-case version).
     */
    public static boolean isVowel (char c)
    {
        if (Character.isUpperCase(c))
        {
            c = Character.toLowerCase(c);
        }
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    /**
     * Returns the index within s of the first vowel ('a', 'e', 'i', 'o', 'u' or an upper-case version) that occurs in
     * s. If there is no vowel in s, returns -1.
     * 
     * For example, the method should return 0 for "Apple", 1 for "hello", 2 for "slope", 3 for "strength", and -1 for
     * "xyzzy".
     * 
     * IMPLEMENTATION NOTE: This method is already completely implemented. There is no need for you to change anything.
     */
    public static int firstVowelIndex (String s)
    {
        for (int i = 0; i < s.length(); i++)
        {
            if (isVowel(s.charAt(i)))
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the result of converting s to "Pig Latin". Convert a string s to Pig Latin by using the following rules:
     * 
     * (1) If s contains no vowels, do nothing to it.
     * 
     * (2) Otherwise, if s starts with a vowel, append "way" to the end.
     * 
     * (3) Otherwise, move everything up to (but not including) the first vowel to the end and add "ay".
     * 
     * For example, "hello" converts to "ellohay", "small" converts to "allsmay", "eat" converts to "eatway", and "nth"
     * converts to "nth".
     * 
     * IMPLEMENTATION NOTE: This will require a three-way conditional that extracts pieces of Strings and recombines
     * them into new Strings. For full credit (and an easier implementation), use the firstVowelIndex method provided
     * above in your method's implementation. You will also find the methods s.substring() and s.charAt() (where s is a
     * String), as well as the + operator that concatenates Strings, very useful.
     */
    public static String toPigLatin (String s)
    {
        String sFinal = new String(s); // initializes a new String for return use
        if (isVowel(s.charAt(0)))
        {
            return sFinal += "way"; // returns for option 2
        }
        else
        {
            for (int i = 1; i < s.length(); i++)
            {
                if (isVowel(s.charAt(i)))
                {
                    return sFinal = s.substring(i) + s.substring(0, i) + "ay";
                }
            }
            return sFinal; // if all else fails, returns for option 1
        }
    }

    /**
     * Returns the result of converting each word from words into Pig Latin and then appending the results, with each
     * converted word followed by a single space character. A word is a sequence of characters separated from other
     * words by white space. If there are no words, returns the empty string.
     * 
     * For example, "" converts to "" and "This is a test" converts to "isThay isway away esttay ".
     * 
     * IMPLEMENTATION NOTE: This will require a while loop. Use a Scanner to split the string into individual words by
     * using the s.hasNext() and s.next() methods (where s is a Scanner).
     */
    public static String convertToPigLatin (String words)
    {
        Scanner scan = new Scanner(words);
        String rString = new String("");
        while (scan.hasNext())
        {
            rString += toPigLatin(scan.next()) + " ";
        }
        scan.close();
        return rString;
    }

    /**
     * Returns a String of length width that begins and ends with the character edge and contains width-2 copies of the
     * character inner in between. For example, if edge is '+', inner is '-', and width is 8, the method should return
     * "+------+".
     * 
     * The method does not print anything. The parameter width must be greater than or equal to 2.
     * 
     * IMPLEMENTATION NOTE: This method is already completely implemented. There is no need for you to change anything.
     */
    public static String makeLine (char edge, char inner, int width)
    {
        String line = "";
        for (int i = 0; i < width - 2; i++)
        {
            line += inner;
        }
        return edge + line + edge;
    }

    /**
     * Returns a string which, when printed out, will be a rectangle shaped like this:
     * 
     * <pre>
     * +----------+
     * |          |
     * |          |
     * |          |
     * |          |
     * |          |
     * +----------+
     * </pre>
     * 
     * The returned string should consist of height lines, each ending with a newline. In addition to the newline, the
     * first and last lines should begin and end with '+' and should contain width-2 '-' symbols. In addition to the
     * newline, the other lines should begin and end with '|' and should contain width-2 spaces.
     * 
     * The method does not print anything. Both parameters must be greater than or equal to 2.
     * 
     * IMPLEMENTATION NOTE: For full credit (and for easier implementation), make use of the makeLine method in your
     * implementation of makeRectangle. You'll need to use a loop to call makeLine the correct number of times.
     * 
     */
    public static String makeRectangle (int height, int width)
    {
        String rectangle = new String(makeLine('+', '-', width) + '\n');
        if (height > 2 && width > 2)
        {
            for (int i = 0; i < height - 2; i++)
            {
                rectangle += "|";
                for (int j = 0; j < width - 2; j++)
                {
                    rectangle += " ";
                }
                rectangle += "|" + '\n';
            }
        }
        return rectangle + makeLine('+', '-', width) + '\n';
    }

    /**
     * Returns the integer that follows n in a Hailstone sequence. If n is 1, returns 1. Otherwise, returns either n/2
     * (if n is even) or 3n+1 (if n is odd). The parameter n must be positive.
     * 
     * IMPLEMENTATION NOTE: This one will require a three-way conditional
     */
    public static int nextHailstone (int n)
    {
        if (n < 0)
        {
            return 0;
        }
        else if (n == 1)
        {
            return 1;
        }
        else if (n % 2 == 0)
        {
            return n / 2;
        }
        else
        {
            return 3 * n + 1;
        }
    }

    /**
     * Returns a string consisting of a Hailstone sequence beginning with the positive integer n and ending with 1. The
     * string should consist of a sequence of numerals, with each numeral followed by a single space. When a numeral m
     * (other than 1) appears in the sequence, it should be followed by nextHailstone(m).
     * 
     * For example, nextHailstone(1) should return "1 " and nextHailstone(5) should return "5 16 8 4 2 1 ".
     * 
     * IMPLEMENTATION NOTE: Make use of your nextHailstone method. You'll need to use a loop to call it the right number
     * of times.
     */
    public static String hailstones (int n)
    {
        String s = new String(n + " ");
        while (n != 1)
        {
            n = nextHailstone(n);
            s += n + " ";
        }
        return s;
    }

    /**
     * Returns the number of tokens (as identified by the s.next() method on Scanners s) that appears in the parameter
     * words. For example, countTokens("this is a test") should return 4, and countTokens("") should return 0.
     * 
     * IMPLEMENTATION NOTE: This will require a while loop. Use a Scanner to split the string into individual words.
     */
    public static int countTokens (String words)
    {
        Scanner scan = new Scanner(words);
        int count = 0;
        while (scan.hasNext())
        {
            count++;
            scan.next();
        }
        scan.close();
        return count;
    }
}
