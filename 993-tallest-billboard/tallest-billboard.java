class Solution {
    public int tallestBillboard(int[] rods) {
        int n = rods.length;
        int sum =0;
        for(int e:rods) sum+=e;
        int[][] dp = new int[n][2*sum+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        int res = helper(0,0,rods,dp,sum);
        return (res<0)?0:res;
    }
    public int helper(int idx,int diff,int[] rods,int[][]dp,int sum){
        if(idx==rods.length){
            if(diff==0) return 0;
            return Integer.MIN_VALUE/2;
        }
        int d = diff+ sum;
        if(dp[idx][d]!=-1) return dp[idx][d];

        // option1: DONT USE THAT ROD
        int option1 = helper(idx+1,diff,rods,dp,sum);

        // option2: USE THAT ROD ON FIRST SIDE 
        int option2 =helper(idx+1,diff+rods[idx],rods,dp,sum);

        // option3: USE THAT ROD ON OTHER SIDE
        int option3 =rods[idx]+ helper(idx+1,diff-rods[idx],rods,dp,sum);
        return dp[idx][d]=Math.max(option1,Math.max(option2,option3));

    }
}