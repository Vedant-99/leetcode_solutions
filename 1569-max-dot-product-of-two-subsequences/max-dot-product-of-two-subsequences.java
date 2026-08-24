class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int i =nums1.length;
        int j =nums2.length;
        int[][] dp = new int[i][j];
        for(int[] row:dp) Arrays.fill(row,Integer.MIN_VALUE);
        return helper(0,0,nums1,nums2,dp);
    }
    public int helper(int i,int j,int[] a1,int[] a2,int[][] dp){
        if(i==a1.length  || j==a2.length) return Integer.MIN_VALUE;
        if(dp[i][j]!=Integer.MIN_VALUE) return dp[i][j];
        int pick = a1[i]*a2[j] + Math.max(0,helper(i+1,j+1,a1,a2,dp));
        int skip1 = helper(i+1,j,a1,a2,dp);
        int skip2 = helper(i,j+1,a1,a2,dp);
        return dp[i][j] = Math.max(pick,Math.max(skip1,skip2));
    }
}