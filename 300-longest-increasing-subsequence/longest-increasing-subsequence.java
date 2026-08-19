class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] r:dp) Arrays.fill(r,-1);
        return helper(0,-1,nums,dp);
    }
    public int helper(int i,int pidx,int[] arr,int[][]dp){
        if(i==arr.length) return 0;
        if(dp[i][pidx+1]!=-1) return dp[i][pidx+1];
        int skip = helper(i+1,pidx,arr,dp);
        if(pidx!=-1 && arr[i]<=arr[pidx]) return dp[i][pidx+1]= skip;
        int pick =1+helper(i+1,i,arr,dp);
        return dp[i][pidx+1] =Math.max(pick,skip);
    }
}