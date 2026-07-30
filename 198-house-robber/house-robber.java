class Solution {
    int[] dp;
    public int rob(int[] nums) {
        dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return loot(nums);
    }
    public int loot(int[]nums){
        // if(idx>=nums.length) return 0;
        dp[0]=nums[0];
       if(nums.length>1)dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[nums.length-1];
    }
}