class Solution {
    public int rob(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int opt1 = helper(nums,0,nums.length-2);
        int opt2 = helper(nums,1,nums.length-1);
        return Math.max(opt1,opt2);

    }
    public int helper(int nums[],int start,int end){
        int len = end-start+1;
        if(len==1) return nums[start];

        int[] dp = new int[len];
        dp[0]=nums[start];
        dp[1]= Math.max(nums[start],nums[start+1]);
        for(int i=2;i<len;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[start+i]);
        }
        return dp[len-1];
    }
}