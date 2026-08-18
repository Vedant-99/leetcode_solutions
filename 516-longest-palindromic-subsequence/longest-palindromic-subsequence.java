class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        StringBuilder t = new StringBuilder(s);
        t=t.reverse();
        return LCS(s,t.toString());
    }
    public int LCS(String a,String b){
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n][m];
        for(int[] row:dp) Arrays.fill(row,-1);
        return helper(n-1,m-1,a,b,dp);
    }
    public int helper(int a,int b,String s,String t,int[][]dp){
        if(a<0||b<0) return 0;
        if(dp[a][b]!=-1) return dp[a][b];
        if(s.charAt(a)==t.charAt(b)) return dp[a][b]=1+helper(a-1,b-1,s,t,dp);
        else return dp[a][b]=Math.max(helper(a-1,b,s,t,dp),helper(a,b-1,s,t,dp));
    }
}