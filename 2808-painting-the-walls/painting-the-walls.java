class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[][] dp = new int[n][n+1];
        for(int[] row: dp) Arrays.fill(row,-1);
        return helper(0,n,cost,time,dp);
    }
    public int helper(int idx,int wallsRemaining,int[] cost, int[] time,int[][]dp){
        if(wallsRemaining<=0) return 0;
        if(idx>=cost.length) return Integer.MAX_VALUE/2;
        if(dp[idx][wallsRemaining]!=-1) return dp[idx][wallsRemaining];
        int pick  = cost[idx]+helper(idx+1,wallsRemaining-time[idx]-1,cost,time,dp);
        int skip  = helper(idx+1,wallsRemaining,cost,time,dp);
        return dp[idx][wallsRemaining]=Math.min(pick,skip);
    }
}