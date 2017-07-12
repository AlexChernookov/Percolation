import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by a178300 on 7/10/2017.
 */
public class Percolation {

    private int gridSize;
    private int N;
    private boolean [][] grid;
    private WeightedQuickUnionUF gridConnection;

    // create n-by-n grid, with all sites blocked
    public Percolation(int n) {
        this.gridSize = n * n + 2;
        this.grid = new boolean[n][n];
        gridConnection = new WeightedQuickUnionUF(gridSize);
        for (int i = 1; i <= n; i++) {
            //connect top
            gridConnection.union(0, i);
            //connect bottom
            gridConnection.union(n * n + 1, n * n - i + 1);
        }
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        grid[row-1][col-1] = true;
    }

    // get corresponding number to connect in gridConnection
    private int getCorrespondingNumber(int row, int col){
        return (row-1)*N+col;
    }

    // connect neighbors of element if they are opened
    private void connectNeighbors(int row, int col){

    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        return grid[row][col];
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        return false;
    }

    // number of open sites
    public int numberOfOpenSites() {
        return 0;
    }

    // does the system percolate?
    public boolean percolates() {
        return false;
    }

    public static void main(String[] args) {
        Percolation p = new Percolation(5);
        System.out.print("SSSSS");
    }
}
