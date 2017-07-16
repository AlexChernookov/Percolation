import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by a178300 on 7/10/2017.
 */
public class Percolation {
    private boolean[][] grid;
    private WeightedQuickUnionUF gridConnection;
    private int gridConnectionSize, sidesNum, openSides, top = 0, bottom;

    // create n-by-n grid, with all sidesNum blocked
    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException("n needs to be > 0");
        this.sidesNum = n;
        this.gridConnectionSize = n * n + 2;
        this.grid = new boolean[n][n];
        gridConnection = new WeightedQuickUnionUF(gridConnectionSize);
        this.bottom = n * n + 1;
        for (int i = 1; i <= n; i++) {
            // connect top
            gridConnection.union(top, i);
            // connect bottom
            gridConnection.union(bottom, n * n - i + 1);
        }
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        row = row - 1;
        col = col - 1;
        grid[row][col] = true;
        openSides++;
        connectNeighbors(row, col);
    }

    // get corresponding number to connect in gridConnection
    private int getCorrespondingNumber(int row, int col) {
        if (row < 0 || row >= sidesNum) {
            return -1;
        }
        if (col < 0 || col >= sidesNum) {
            return -1;
        }
        return row * sidesNum + col + 1;
    }

    // connect neighbors of element if they are opened
    private void connectNeighbors(int row, int col) {
        int currentSite = getCorrespondingNumber(row, col);
        int topSite = getCorrespondingNumber(row - 1, col);
        int bottomSite = getCorrespondingNumber(row + 1, col);
        int leftSite = getCorrespondingNumber(row, col - 1);
        int rightSite = getCorrespondingNumber(row, col + 1);
        if (isInRange(topSite)) {
            if (isTopSideOpen(row, col)) {
                gridConnection.union(currentSite, topSite);
            }
        }
        if (isInRange(bottomSite)) {
            if (isBottomSideOpen(row, col)) {
                gridConnection.union(currentSite, bottomSite);
            }
        }
        if (isInRange(leftSite)) {
            if (isLeftSideOpen(row, col)) {
                gridConnection.union(currentSite, leftSite);
            }
        }
        if (isInRange(rightSite)) {
            if (isRightSideOpen(row, col)) {
                gridConnection.union(currentSite, rightSite);
            }
        }
    }

    private boolean isTopSideOpen(int row, int col) {
        return isOpen(row, col + 1);
    }

    private boolean isBottomSideOpen(int row, int col) {
        return isOpen(row + 2, col + 1);
    }

    private boolean isLeftSideOpen(int row, int col) {
        return isOpen(row + 1, col);
    }

    private boolean isRightSideOpen(int row, int col) {
        return isOpen(row + 1, col + 2);
    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        row = row - 1;
        col = col - 1;
        if (row < 0 || col < 0) {
            throw new IllegalArgumentException("Value should row '" + row + "' < 0, or col '" + col + " < 0");
        }
        if (row > sidesNum + 1 || col > sidesNum + 1) {
            throw new IllegalArgumentException("The value is out of bound");
        }
        return grid[row][col];
    }

    // is in range of connected array
    private boolean isInRange(int number) {
        if (number <= 0 || number >= bottom) {
            return false;
        }
        return true;
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        if (isOpen(row, col)) {
            return gridConnection.connected(top, getCorrespondingNumber(row - 1, col - 1));
        }
        return false;
    }

    // number of open sides
    public int numberOfOpenSites() {
        return openSides;
    }

    // does the system percolate?
    public boolean percolates() {
        return gridConnection.connected(top, bottom);
    }

    public static void main(String[] args) {
    }
}
