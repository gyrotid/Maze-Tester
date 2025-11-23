import jave.nio.file.*;
import java.io.*;

public class Maze
{
    char[][] aMaze = new char[20][20]; 
    boolean solveable = false;
    
    public Maze()
    {
        //the constructor for the Maze class
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("/workspaces/Maze-Tester/maze.dat"));
            String s = null;
            int currentRow = 0;
            while ((s = reader.readLine()) != null)
            {
                for (int i = 0; i < aMaze.length; i++)
                {
                    
                }
                currentRow++;
            }
            reader.close();
        }
        catch (IOexception e)
        {
            System.out.println(e);
        }
    }

    public String toString()
    {
        //toString method that returns either yes or no depending on the value of solveable
        if (solveable == true)
            return("Maze: YES");
        else
            return("Maze: NO")
    }

    public static void main(String[] args)
    {
        //this function calls the maze object (Maze newMaze) that i decalared globally
        Maze newMaze = new Maze();

    }
}

/* 
Need to treat each line of the file as a sequence of characters
Each character in the that line belongs in one column of the same row
I need to index the characters of the line directly
Then fill the row and column into variables
Afterwards move on to the next row
*/