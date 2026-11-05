import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SudokuSolver {
    private final int M = 3;
    private final int N = M * M;
    private int[][] grid;
    private ArrayList<Set<Integer>> rows;
    private ArrayList<Set<Integer>> cols;
    private ArrayList<Set<Integer>> squares;
    private Set<Integer> nums;

    public SudokuSolver(String fileName) {
        // read the puzzle file
        try (Scanner in = new Scanner(new File(fileName))) {

            this.grid = new int[N][N];

            for (int row = 0; row < N; row++) {
                String line = in.next();

                for (int col = 0; col < N; col++) {
                    String strVal = line.substring(col, col + 1);
                    int number;
                    if (strVal.equals("x")) {
                        number = 0; //0s are stand-ins for 'x'
                    } else {
                        number = Integer.parseInt(strVal);
                    }
                    this.grid[row][col] = number;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open: " + fileName);
        }

        // create the list of sets for each row (this.rows)
        // ...
        rows = new ArrayList<>();

        for (int i = 0; i < N; i++)
        {
            rows.add(new HashSet<>());
        }


        // create the list of sets for each col (this.cols)
        // ...
        cols = new ArrayList<>();
        for (int i = 0; i < N; i++)
        {
            cols.add(new HashSet<>());
        }

        squares = new ArrayList<>();
        for (int i = 0; i < N; i++)
        {
            squares.add(new HashSet<>());
        }


        // create a hash set for [1..9] (this.nums)
        // ...

        nums = new HashSet<>();
        for (int i = 0; i < N; i++)
        {
            nums.add(i+1);
        }









        //add to rows and cols
        for(int row = 0; row < N; row++)
        {
            for(int col = 0; col<N; col++)
            {
                if(this.grid[row][col]!= 0)
                {      
                    rows.get(row).add(this.grid[row][col]);
                    cols.get(col).add(this.grid[row][col]);
                    int currentSquare = mapCellToSquare(row, col);
                    squares.get(currentSquare).add(this.grid[row][col]);

                }
            }
        }





        // create the list of sets for each square (this.squares)
        /* the squares are added to the list row-by-row:
            0 1 2
            3 4 5
            6 7 8
         */
        // ...
        





        /* 
        // visually inspect that all the sets are correct
        for (int row = 0; row < N; row++) {
            System.out.println("row " + row + ": " + this.rows.get(row));
        }
        for (int col = 0; col < N; col++) {
            System.out.println("col " + col + ": " + this.cols.get(col));
        }
        for (int square = 0; square < N; square++) {
            System.out.println("square " + square + ": " + this.squares.get(square));
        }
        System.out.println(this.nums);
        */
    }


    public boolean solve() {
        // find an empty location, if any
        boolean finished = true;
        int nextRow = -1;
        int nextCol = -1;
        for (int row = 0; row < N && finished; row++) {
            for (int col = 0; col < N && finished; col++) {
                if (this.grid[row][col] == 0) {
                    finished = false;
                    nextRow = row;
                    nextCol = col;
                }
            }
        }

        // the board is complete; we solved it
        if (finished) {
            return true;
        }

        // get all possible numbers for the row and column we are trying to populate
        /*
            Create a new set based on the this.nums and remove all elements in the sets
            corresponding to nextRow, nextCol, and the corresponding square (use the
            removeAll method).

            Properly indexing the squares list of sets is tricky. Verify that your
            algorithm is correct.
         */
        Set<Integer> possibleNums = new HashSet<Integer>();
        possibleNums.addAll(this.nums);

        Set<Integer> current_row = rows.get(nextRow);
        Set<Integer> current_col = cols.get(nextCol);
        int currentSquare = mapCellToSquare(nextRow, nextCol);
        Set<Integer> current_square = squares.get(currentSquare);

        //Iterator<Integer> iter = possibleNums.iterator();


        for (int i = 1; i < N+1; i++)
        {

            if(current_row.contains(i) || current_col.contains(i) || current_square.contains(i) )
                possibleNums.remove(i);
            System.out.println(possibleNums);
        }


        /* 
        for (int num : possibleNums)
        {
            if(current_row.contains(num) || current_col.contains(num) || current_square.contains(num) )
                possibleNums.remove(num);
        }
        */
        
        // ...

        // if there are no possible numbers, we cannot solve the board in its current state
        if (possibleNums.isEmpty()) {
            return false;
        }

        // try each possible number
        for (Integer possibleNum : possibleNums) {
            // update the grid and all three corresponding sets with possibleNum
            // ...
            grid[nextRow][nextCol] = possibleNum;
            current_row.add(possibleNum);
            current_col.add(possibleNum);
            current_square.add(possibleNum);

            // recursively solve the board
            if (this.solve()) {
                // the board is solved!
                return true;
            } else {
                /*
                 Undo the move before trying another possible number by setting the corresponding
                 element in the grid back to 0 and removing possibleNum from all three corresponding
                 sets.
                 */
                // ...


            current_row.remove(possibleNum);
            current_col.remove(possibleNum);
            current_square.remove(possibleNum);
            grid[nextRow][nextCol] = 0;

            }
        }

        return false;
    }

    public String toString() {
        String str = "";

        for (int[] row : grid) {
            for (int val : row) {
                str += val + "\t";
            }

            str += "\n";
        }

        return str;
    }

    public int mapCellToSquare(int row, int col)
    {
        /*
         * Given the specific row and column in the grid, return the index for the
         *  corresponding square set in the list
        */ 

        // ...
        int currentSquare = 0;

        if(row< 3)
        {
            if(col < 3)
            {
                currentSquare = 0;
            }
            else if(col < 6)
            {
                currentSquare = 1;
            }
            else
                currentSquare = 2;
            
        }
        else if(row < 6)
        {
            if(col < 3)
            {
                currentSquare = 3;
            }
            else if(col < 6)
            {
                currentSquare = 4;
            }
            else
                currentSquare = 5;
            
        }
        else
        {
            if(col < 3)
            {
                currentSquare = 6;
            }
            else if(col < 6)
            {
                currentSquare = 7;
            }
            else
                currentSquare = 8;
        }


        return currentSquare;
    }

    public static void main(String[] args) {
        String fileName = "C:\\Users\\mgnajera\\Codething\\MannyN-Data-structures\\Chapter 15 Activities\\Sudoku\\src\\puzzle1.txt";

        SudokuSolver solver = new SudokuSolver(fileName);
        System.out.println(solver);
        if (solver.solve()) {
            System.out.println("Solved!");
            System.out.println(solver);
        } else {
            System.out.println("Unsolveable...");
        }
    }
}