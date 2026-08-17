class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
    int[][] dp = new int[nums.size()][target+1];
    for(int[] row:dp) Arrays.fill(row,-2);
    int res = helper(0,target,nums,dp);
    return (res>0)?res:-1;
    }
    public int helper(int idx,int target,List<Integer> nums,int[][] dp){
            if(target==0) return 0;
            if(nums.size()==idx|| target<1) return -1;
            if(dp[idx][target]!=-2) return dp[idx][target];
            int skip = helper(idx+1,target,nums,dp);
            int pick = helper(idx+1,target-nums.get(idx),nums,dp);
            if(pick!=-1) pick++;
            return dp[idx][target] = Math.max(pick,skip);
        }

    }
