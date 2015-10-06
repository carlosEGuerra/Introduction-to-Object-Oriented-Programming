package files;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 * @author Carlos Guerra (u0847821)
 * 
 * This method was implemented entirely by myself.
 */
public class FileManipulations
{
    public static void main (String[] args)
    {
        SwingUtilities.invokeLater( () -> runGUI());
    }

    /**
     * runs the main program's choices and returns the respected messages/error messages
     * 
     * @throws NumberFormatException
     */
    @SuppressWarnings("resource")
    public static void runGUI ()
    {
        // gets the fie
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showDialog(null, "Open File");
        Scanner scan = null;

        // tests for NullPointerException, FileNotFoundException and NoSuchElement exception
        try
        {
            scan = new Scanner(fileChooser.getSelectedFile());
        }
        catch (FileNotFoundException e)
        {
            JOptionPane.showMessageDialog(null, "The file you desire was not found");
            return;
        }
        catch (NullPointerException e)
        {
            return;
        }
        catch (NoSuchElementException e)
        {
            return;
        }
        String option = null;
        try
        {
            option = JOptionPane.showInputDialog("Which option would you like to do? Type either 1, 2, 3 or 4." + '\n'
                    + "1. Find the longest line in the file?" + '\n' + "2. Find the longest token in the file?" + '\n'
                    + "3. Find out how many times a specific token occurs in the file?" + '\n'
                    + "4. Find the number of lines with those tokens.");
            // checks for the close button, empty entree, and cancel
            if (option == null)
            {
                return;
            }
        }
        catch (HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, "Sorry, but I'm not supported there! Try again!");
            return;
        }
        catch (NoSuchElementException e)
        {
            JOptionPane.showMessageDialog(null, "Sorry, but we couldn't find that. Try Again!");
            return;
        }
        int choiceInt = 0;
        try
        {
            choiceInt = Integer.parseInt(option);
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Sorry but that wasn't a number. Try again!");
            return;
        }
        // uses the user input to choose which case to run.
        try
        {
            switch (choiceInt)
            {
                case 1:
                    choiceInt = 1;
                    JOptionPane.showMessageDialog(null, "Your longest string was: " + longestLine(scan));
                    break;
                case 2:
                    choiceInt = 2;
                    JOptionPane.showMessageDialog(null, "The longest token in your file was: " + longestToken(scan));
                    break;
                case 3:
                    choiceInt = 3;
                    String t = JOptionPane.showInputDialog("What token would you like to find?");
                    if(t == null)
                    {
                        break;
                    }
                    JOptionPane.showMessageDialog(null, "Your token was found: " + tokenOccurence(scan, t) + " times.");
                    break;
                case 4:
                    choiceInt = 4;
                    int n = Integer.parseInt(JOptionPane.showInputDialog("What is the length of the string you desire?"));
                    JOptionPane.showMessageDialog(null, "Your string length was found: " + lineOfSize(scan, n) + " times in the file");
                    break;
                default:
                    break;
            }
        }
        catch (NullPointerException e)
        {
            return;
        }
        catch (NoSuchElementException e)
        {
            JOptionPane.showMessageDialog(null, "Sorry, you might have opened a wrong file. Let's try again!");
            return;
        }
        catch (IllegalArgumentException e)
        {
            return;
        }
    }

    /**
     * Finds the longest line in the file.
     */
    public static String longestLine (Scanner scan)
    {
        String returnString = scan.nextLine();
        //checks for another line
        if (!scan.hasNextLine())
        {
            if (!scan.hasNext())
            {
                return null;
            }
            //if there is a word and prints out the string
            else
            {
                return scan.toString();
            }
        }
        //if there is another line, runs through this method
        else
        {
            while (scan.hasNextLine())
            {
                String temp = scan.nextLine();
                if (temp.length() > returnString.length())
                {
                    returnString = temp;
                }
            }
        }
        scan.close();
        return returnString;
    }

    /**
     * finds the longest token in the file.
     */
    public static String longestToken (Scanner scan)
    {
        String returnString = "";
        if (!scan.hasNext())
        {
            return null;
        }
        else
        {
            while (scan.hasNext())
            {
                String temp = scan.next();
                if (temp.length() > returnString.length())
                {
                    returnString = temp;
                }
            }
        }
        scan.close();
        return returnString;
    }

    /**
     * finds the number of times a specific token occurs in the file. Inputs: Scanner scan and String token
     */
    public static int tokenOccurence (Scanner scan, String t)
    {
        int count = 0;
        if (!scan.hasNext())
        {
            return count;
        }
        else
        {
            while (scan.hasNext())
            {
                String temp = scan.next();
                if (t.equals(temp))
                {
                    count++;
                }
            }
        }
        scan.close();
        return count;
    }

    /**
     * Finds the number of lines that are extactly n tokens long
     */
    public static int lineOfSize (Scanner scan, int n)
    {
        int count = 0;
        if (!scan.hasNextLine())
        {
            return 0;
        }
        else
        {
            while (scan.hasNextLine())
            {
                int temp = scan.nextLine().length();
                if (temp == n)
                {
                    count++;
                }
            }
        }
        scan.close();
        return count;
    }
}