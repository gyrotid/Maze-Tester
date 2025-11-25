import java.nio.file.*;
import java.io.*;

public class Maze
{
    char[][] aMaze = new char[20][20]; 
    boolean solveable = false;
    int startRow, startCol;
    int endRow, endCol;
    int currentRow, currentCol;

    public Maze()
    {
        //the constructor for the Maze class
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("/workspaces/Maze-Tester/maze.dat"));
            String s = null;
            currentRow = 0;
            currentCol = 0;
            while ((s = reader.readLine()) != null)
            {
                for (int i = 0; i < aMaze[currentRow].length; i++)
                {
                    currentCol = i;
                    aMaze[currentRow][currentCol] = s.charAt(currentCol);
                    if (aMaze[currentRow][currentCol] == 'S')
                    {
                        startRow = currentRow;
                        startCol = currentCol; //this way we can call aMaze[startRow][startCol] when we track if it's solveable
                    }
                    else if (aMaze[currentRow][currentCol] == 'E')
                    {
                        endRow = currentRow;
                        endCol = currentCol; //same thing as the startRow/startCol call but with the end!
                    }
                }
                currentRow++;
            }
            reader.close();


        }
        catch (IOException e)
        {
            System.out.println(e);
        }

        boolean[][] visited = new boolean[20][20]; //type[][] variableName = new type[row size][collumn size]
        visited[startRow][startCol] = true;

        for (currentRow = 0; currentRow < 20; currentRow++)
        {
            for (currentCol = 0; currentCol < 20; currentCol++)
            {
                if (visited[currentRow][currentCol])
                {
                    if (currentRow > 0 && aMaze[currentRow - 1][currentCol] != '#' && !visited[currentRow - 1][currentCol])
                    {
                        visited[currentRow - 1][currentCol] = true;
                    }
                }
                if (visited[currentRow][currentCol])
                {
                    if (currentRow < 19 && aMaze[currentRow + 1][currentCol] != '#' && !visited[currentRow + 1][currentCol])
                    {
                        visited[currentRow + 1][currentCol] = true;
                    }
                }
                if (visited[currentRow][currentCol])
                {
                    if (currentCol > 0 && aMaze[currentRow][currentCol - 1] != '#' && !visited[currentRow][currentCol - 1])
                    {
                        visited[currentRow][currentCol - 1] = true;
                    }
                }
                if (visited[currentRow][currentCol])
                {
                    if (currentCol < 19 && aMaze[currentRow][currentCol + 1] != '#' && !visited[currentRow][currentCol + 1])
                    {
                        visited[currentRow][currentCol + 1] = true;
                    }
                }
            }
        }

        if (visited[endRow][endCol])
        {
            solveable = true;
        }
    }

    public String toString()
    {
        //toString method that returns either yes or no depending on the value of solveable
        if (solveable == true)
            return("Maze: YES");
        else
            return("Maze: NO");
    }

    public static void main(String[] args)
    {
        //this function calls the maze object (Maze newMaze) that i decalared globally & prints the toString
        Maze newMaze = new Maze();
        System.out.println(newMaze.toString());
    }
}