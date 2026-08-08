class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] rows:dp) Arrays.fill(rows,-1);
        return helper(0,amount,coins,dp);
    }
    public int helper(int idx,int amt,int[]coins,int[][]dp){
        if(amt==0) return 1;
        if(idx==coins.length) return 0;
        if(dp[idx][amt]!=-1) return dp[idx][amt];
        int skip = helper(idx+1,amt,coins,dp);
        if(coins[idx]>amt) return dp[idx][amt] =skip;
        int take = helper(idx,amt-coins[idx],coins,dp);
        return dp[idx][amt] = take+skip; 
    }

}