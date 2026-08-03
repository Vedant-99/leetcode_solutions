class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][]  dp = new int[n][n];
        for(int[] row:dp) Arrays.fill(row,Integer.MAX_VALUE);
        return helper(0,0,triangle,dp);
    }
    public int helper(int row,int col,List<List<Integer>> triangle,int[][]dp){
        if(row==triangle.size()-1) return triangle.get(row).get(col);
        if(dp[row][col]!=Integer.MAX_VALUE) return dp[row][col];
        int left = helper(row+1,col,triangle,dp);
        int right = helper(row+1,col+1,triangle,dp);
        dp[row][col]=triangle.get(row).get(col) + Math.min(left,right);
        return dp[row][col]; 

    }
}