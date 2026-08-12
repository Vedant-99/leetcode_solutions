class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum =0;
        for(int num:nums) totalSum+=num;
        if(Math.abs(target)>totalSum || (totalSum+target)%2==1) return 0;
        int s =(totalSum+target)/2; 
        int[][] dp = new int[nums.length][s+1];
        for(int[]rows:dp) Arrays.fill(rows,-1); 
        return helper(0,s,nums,dp);
    }
    public int helper(int idx,int target,int[]nums,int[][]dp){
        if(idx==nums.length){
            if(target==0) return 1;
            else return 0;
        }
        if(dp[idx][target]!=-1) return dp[idx][target];
        int skip= helper(idx+1,target,nums,dp);
        int pick=0;
        if(nums[idx]<=target) pick = helper(idx+1,target-nums[idx],nums,dp);
        return dp[idx][target] = pick+skip;

    }
}