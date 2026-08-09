class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp =new int[len1+1][len2+1];
        for(int[] row:dp)Arrays.fill(row,-1);
        return solve(word1,word2,len1,len2,dp);
    }
    public int solve(String s,String t,int i,int j,int[][] dp){
        if(i==0) return j;
        if(j==0) return i;
        if(dp[i][j]!=-1) return dp[i][j];

        if(s.charAt(i-1)==t.charAt(j-1)){
            return dp[i][j]=solve(s,t,i-1,j-1,dp);
        }

        int insertCost = solve(s,t,i,j-1,dp);
        int deleteCost = solve(s,t,i-1,j,dp);
        int replaceCost = solve(s,t,i-1,j-1,dp);

        return dp[i][j]=1+Math.min(insertCost,Math.min(deleteCost,replaceCost));
    }
}