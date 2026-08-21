class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n][2];
        for(long[]row:dp) Arrays.fill(row,-1);
        return solve(0,1,nums,dp);
    }
    public long solve(int i,int j,int[]nums,long[][]dp){
        if(i==nums.length) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        long skip = solve(i+1,j,nums,dp);
        long val = (j==1)?nums[i]:-nums[i]; 
        long pick =val+ solve(i+1,1-j,nums,dp);
        return dp[i][j]=Math.max(skip,pick);

    }
}