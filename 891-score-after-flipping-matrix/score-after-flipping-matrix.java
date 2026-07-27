class Solution {
    public int matrixScore(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // Step 1: Make the first column all 1s
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] ^= 1;
                }
            }
        }

        // Step 2: For every remaining column,
        // make the number of 1s greater than or equal to 0s
        for (int j = 1; j < m; j++) {
            int countZeros = 0;
            int countOnes = 0;

            for (int i = 0; i < n; i++) {
                if (grid[i][j] == 0) {
                    countZeros++;
                } else {
                    countOnes++;
                }
            }

            if (countZeros > countOnes) {
                for (int i = 0; i < n; i++) {
                    grid[i][j] ^= 1;
                }
            }
        }

        // Step 3: Calculate score
        int sum = 0;

        for (int j = 0; j < m; j++) {
            int ones = 0;

            for (int i = 0; i < n; i++) {
                if (grid[i][j] == 1) {
                    ones++;
                }
            }

            sum += ones * (1 << (m - 1 - j));
        }

        return sum;
    }
}