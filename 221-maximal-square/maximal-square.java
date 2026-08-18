class Solution {
    int maxSide=0;
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for(int[] r:dp) Arrays.fill(r,-1);
        int fun = helper(0,0,matrix,dp);
        return maxSide*maxSide;
    }
    public int helper(int row,int col,char[][] mat,int[][]dp){
        if(row>=mat.length || col>=mat[0].length) return 0;
        if(dp[row][col]!=-1) return dp[row][col];
        int right = helper(row,col+1,mat,dp);
        int down = helper(row+1,col,mat,dp);
        int diagonal = helper(row+1,col+1,mat,dp);

        if(mat[row][col]=='1'){
            dp[row][col]=1+Math.min(right,Math.min(down,diagonal));
            maxSide = Math.max(maxSide,dp[row][col]);
        }
        else dp[row][col]=0;

    return dp[row][col];
    }
}