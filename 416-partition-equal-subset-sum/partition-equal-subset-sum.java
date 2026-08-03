class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum =0;
        
        for(int i:nums) totalSum+=i;
        if(totalSum%2 ==1) return false;
        int target = totalSum/2;

        int[][] dp = new int[nums.length][target+1];
        for(int row[]:dp) Arrays.fill(row,-1);
        return helper(0,target,nums,dp);
    }
    public boolean helper(int idx,int target,int[]nums,int[][]dp){
        if(target==0) return true;
        if(idx>=nums.length) return false;
        if(dp[idx][target]!=-1) return dp[idx][target]==1;
        boolean skip = helper(idx+1,target,nums,dp);
        boolean pick=false;
        if(nums[idx]<=target){
            pick = helper(idx+1,target-nums[idx],nums,dp); 
        }
        boolean ans=pick||skip;
        dp[idx][target]=ans?1:0;
        return ans;

    }
}