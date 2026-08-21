class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];
        for(int[] row:dp) Arrays.fill(row,-1);
        return helper(n-1,m-1,word1,word2,dp);
    }
    public int helper(int n,int m,String a, String b,int[][]dp){
        if(n<0) return m+1;
        if(m<0) return n+1;
        if(dp[n][m]!=-1) return dp[n][m];
        if(a.charAt(n)==b.charAt(m)) return dp[n][m]=helper(n-1,m-1,a,b,dp);
        return dp[n][m]=1+Math.min(helper(n-1,m,a,b,dp),helper(n,m-1,a,b,dp));
    }
}