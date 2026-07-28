class Solution {
    int dp[];
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(helper(0,cost),helper(1,cost));
    }
    public int helper(int i,int[] arr){
        if(i>=arr.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int pick = arr[i]+Math.min(helper(i+1,arr) ,helper(i+2,arr));
        dp[i]=pick;
        return pick;
    }
}