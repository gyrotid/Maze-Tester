import jave.nio.file.*;
import java.io.*;

public class Maze
{
    char aMaze[20][20]; 
    boolean solveable = false;
    
    public Maze()
    {
        //the constructor for the Maze class
        Path file = Paths.get("/workspaces/Maze-Tester/maze.dat");
        InputSteam input = null;
        try
        {
            input = Files.newInputStream(file);
            BufferedReader reader = new
                BufferedReader(new InputStreamReader(input));
            String s = null;
            while (s = reader.readLine() != null)
                System.out.println(s);
            input.close();
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