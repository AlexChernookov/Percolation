import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by a178300 on 7/10/2017.
 */
public class Percolation {

    private int gridSize;
    private boolean grid[][];
    private WeightedQuickUnionUF wduf;

    // create n-by-n grid, with all sites blocked
    public Percolation(int n) {
        this.gridSize = n * n + 2;
        wduf = new WeightedQuickUnionUF(gridSize);
        for (int i = 1; i <= n; i++) {
            wduf.union(0, i);
        }
        for (int j = gridSize - 1; j >= gridSize - 1 - n; j--) {
            wduf.union(gridSize - 1, j);
        }
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
        Percolation p = new Percolation(5);
        System.out.print("SSSSS");
    }
}
