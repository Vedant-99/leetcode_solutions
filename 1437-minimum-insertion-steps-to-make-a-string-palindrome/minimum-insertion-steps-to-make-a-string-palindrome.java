class Solution {
    public int minInsertions(String s) {
        return s.length()-LPS(s);
    }
    public int LPS(String s){
        StringBuilder t = new StringBuilder(s);
        t = t.reverse();
        return LCS(s,t.toString());
    }
    public int LCS(String a,String b){
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n][m];
        for(int[] row:dp) Arrays.fill(row,-1);
        return helper(n-1,m-1,a,b,dp);
    }
    public int helper(int n,int m,String a,String b,int[][]dp){
        if(n<0 || m<0) return 0;
        if(dp[n][m]!=-1) return dp[n][m];
        if(a.charAt(n)==b.charAt(m)) return dp[n][m] = 1+helper(n-1,m-1,a,b,dp);
        else return dp[n][m] = Math.max(helper(n-1,m,a,b,dp),helper(n,m-1,a,b,dp));
    }
}