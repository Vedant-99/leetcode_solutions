class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp =new int[len1][len2];
        for(int[] row:dp)Arrays.fill(row,-1);
        return solve(len1-1,len2-1,word1,word2,dp);
    }
    public int solve(int i,int j,String s,String t,int[][] dp){
        if(i<0) return j+1; // Inserting remaining characters of t
        if(j<0) return i+1; // Deleteing extra characters of s
        if(dp[i][j]!=-1) return dp[i][j];

        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]=solve(i-1,j-1,s,t,dp);
        }

        int insertCost = solve(i,j-1,s,t,dp);
        int deleteCost = solve(i-1,j,s,t,dp);
        int replaceCost = solve(i-1,j-1,s,t,dp);

        return dp[i][j]=1+Math.min(insertCost,Math.min(deleteCost,replaceCost));
    }
}