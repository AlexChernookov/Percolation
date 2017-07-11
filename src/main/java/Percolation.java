/**
 * Created by a178300 on 7/10/2017.
 */
public class Percolation {

    private int gridSize;
    private boolean grid[][];

    // create n-by-n grid, with all sites blocked
    public Percolation(int n) {
        this.gridSize = n * n + 2;
        grid = new boolean[n][n];
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        return false;
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

    }
}
