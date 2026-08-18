class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for(int[] row:dp) Arrays.fill(row,-1);
        return helper(n-1,m-1,new StringBuilder(text1),new StringBuilder(text2),dp);
    }
    public int helper(int n,int m,StringBuilder a,StringBuilder b,int[][] dp){
        if(n<0 || m<0) return 0;
        if(dp[n][m]!=-1) return dp[n][m];
        if(a.charAt(n)==b.charAt(m)) return dp[n][m]=1+helper(n-1,m-1,a,b,dp);
        else return dp[n][m]=Math.max(helper(n-1,m,a,b,dp),helper(n,m-1,a,b,dp));
    }
}