import java.util.*;
class GameOfLife 
{ 
    public static void main(String[] args) 
    { 
        int rows =10, cols=10; 
		Random randomObject = new Random();
		int [][] grid = new int [rows][cols];
		System.out.println("Original Generation");
		for (rows = 0; rows < 10; rows++) {
			for (cols = 0; cols < 10; cols++) {
				grid[rows][cols] = randomObject.nextInt(2);
				if (grid[rows][cols] == 0){
					//System.out.print("0 ");
				}                      
                else{
					//System.out.print("X ");
				}
                    
			}
			System.out.println(); 
	    }
		System.out.println(); 
        nextGeneration(grid, rows, cols);
    } 
    // Function to print next generation 
    static void nextGeneration(int mat[][], int p, int q) 
    { 
        int[][] newGrid = new int[p][q]; 
        
        for (int l = 1; l < p - 1; l++) 
        { 
            for (int m = 1; m < q - 1; m++) 
            { 
                // finding no Of Neighbours that are alive 
                int Neighbours = 0; 
                for (int i = -1; i <= 1; i++) 
                    for (int j = -1; j <= 1; j++) 
                        Neighbours += mat[l + i][m + j]; 
  
                Neighbours -= mat[l][m]; 
  
				//Satisfying Condition
                if ((mat[l][m] == 1) && (Neighbours < 2)) 
                    newGrid[l][m] = 0;
                else if ((mat[l][m] == 1) && (Neighbours > 3)) 
                    newGrid[l][m] = 0; 
                 else if ((mat[l][m] == 0) && (Neighbours == 3)) 
                    newGrid[l][m] = 1; 
                else
                    newGrid[l][m] = mat[l][m]; 
            } 
        } 
  
        System.out.println("Next Generation"); 
        for (int i = 0; i < p; i++) 
        { 
            for (int j = 0; j < q; j++) 
            { 
                if (newGrid[i][j] == 0) 
                    System.out.print("0 "); 
                else
                    System.out.print("X "); 
            } 
            System.out.println(); 
        }
		nextGeneration(newGrid, 10, 10);
    } 
} 
