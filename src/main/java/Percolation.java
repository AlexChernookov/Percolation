import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by a178300 on 7/10/2017.
 */
public class Percolation {

    private int gridConnectionSize;
    private int N;
    private boolean[][] grid;
    private WeightedQuickUnionUF gridConnection;
    private int TOP = 0;
    private int BOTTOM;

    // create n-by-n grid, with all sites blocked
    public Percolation(int n) {
        this.N = n;
        this.gridConnectionSize = n * n + 2;
        this.grid = new boolean[n][n];
        gridConnection = new WeightedQuickUnionUF(gridConnectionSize);
        this.BOTTOM = n * n + 1;
        for (int i = 1; i <= n; i++) {
            //connect top
            gridConnection.union(TOP, i);
            //connect bottom
            gridConnection.union(BOTTOM, n * n - i + 1);
        }
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        row = row - 1;
        col = col - 1;
        grid[row][col] = true;
        connectNeighbors(row, col);
    }

    // get corresponding number to connect in gridConnection
    private int getCorrespondingNumber(int row, int col) {
        return (row - 1) * N + col;
    }

    // connect neighbors of element if they are opened
    private void connectNeighbors(int row, int col) {
        int current = getCorrespondingNumber(row, col);
        if (isTopSideOpen(row, col)) {
            int top = getCorrespondingNumber(row - 1, col);
            gridConnection.union(current, top);
        }
        if (isBottomSideOpen(row, col)) {
            int bottom = getCorrespondingNumber(row + 1, col);
            gridConnection.union(current, bottom);
        }
        if (isLeftSideOpen(row, col)) {
            int left = getCorrespondingNumber(row, col - 1);
            gridConnection.union(current, left);
        }
        if (isRightSideOpen(row, col)) {
            int right = getCorrespondingNumber(row, col + 1);
            gridConnection.union(current, right);
        }
    }

    private boolean isTopSideOpen(int row, int col) {
        return isOpen(row - 1, col);
    }

    private boolean isBottomSideOpen(int row, int col) {
        return isOpen(row + 1, col);
    }

    private boolean isLeftSideOpen(int row, int col) {
        return isOpen(row, col - 1);
    }

    private boolean isRightSideOpen(int row, int col) {
        return isOpen(row, col + 1);
    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        return grid[row][col];
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        return gridConnection.connected(TOP, getCorrespondingNumber(row, col));
    }

    // number of open sites
    public int numberOfOpenSites() {
        return 0;
    }

    // does the system percolate?
    public boolean percolates() {
        return gridConnection.connected(TOP, BOTTOM);
    }

    public static void main(String[] args) {
        Percolation p = new Percolation(5);
        p.open(1, 1);
        p.open(2, 1);
        System.out.print("SSSSS");
    }
}
