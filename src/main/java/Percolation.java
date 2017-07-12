import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by a178300 on 7/10/2017.
 */
public class Percolation {

    private int gridConnectionSize;
    private int N;
    private boolean[][] grid;
    private WeightedQuickUnionUF gridConnection;
    private int top = 0;
    private int bottom;

    // create n-by-n grid, with all sites blocked
    public Percolation(int n) {
        this.N = n;
        this.gridConnectionSize = n * n + 2;
        this.grid = new boolean[n][n];
        gridConnection = new WeightedQuickUnionUF(gridConnectionSize);
        this.bottom = n * n + 1;
        for (int i = 1; i <= n; i++) {
            //connect top
            gridConnection.union(top, i);
            //connect bottom
            gridConnection.union(bottom, n * n - i + 1);
        }
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        grid[row - 1][col - 1] = true;
    }

    // get corresponding number to connect in gridConnection
    private int getCorrespondingNumber(int row, int col) {
        return (row - 1) * N + col;
    }

    // connect neighbors of element if they are opened
    private void connectNeighbors(int row, int col) {
        if (isLeftBorder(col)) {

        }

    }

    private boolean isLeftBorder(int col) {
        if (col == 0) {
            return true;
        }
        return false;
    }

    private boolean isRightBorder(int col) {
        if (col == N) {
            return true;
        }
        return false;
    }

    private boolean isTobBorder(int row) {
        if (row == 0) {
            return true;
        }
        return false;
    }

    private boolean isBottomBorder(int row) {
        if (row == N) {
            return true;
        }
        return false;
    }

    private boolean isTopLeftCorner(){
        return false;
    }

    private boolean isTopRightCorner(){
        return false;
    }

    private boolean isBottomLeftCorner(){
        return false;
    }

    private boolean isBottomRightCorner(){
        return false;
    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        return grid[row][col];
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        return gridConnection.connected(top, getCorrespondingNumber(row, col));
    }

    // number of open sites
    public int numberOfOpenSites() {
        return 0;
    }

    // does the system percolate?
    public boolean percolates() {
        return gridConnection.connected(top, bottom);
    }

    public static void main(String[] args) {
        Percolation p = new Percolation(5);
        System.out.print("SSSSS");
    }
}
