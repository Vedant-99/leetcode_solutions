class Solution {
    int dp[];
    public int rob(int[] nums) {
        dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return loot(0,nums);
    }
    public int loot(int idx,int arr[]){
        if(idx>=arr.length) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int pick = arr[idx]+loot(idx+2,arr);
        int skip = loot(idx+1,arr);
        int ans = Math.max(pick,skip);
        dp[idx]=ans;
        return ans;
    }
}