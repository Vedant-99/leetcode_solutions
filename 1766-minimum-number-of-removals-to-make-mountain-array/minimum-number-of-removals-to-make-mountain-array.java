class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] dp1 =new int[n];
        int[] dp2 =new int[n];
        Arrays.fill(dp1,1);
        Arrays.fill(dp2,1);

        //LIS FROM LEFT TO RIGHT
        for(int i=1;i<n;i++){
            int max1=0;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]) max1 = Math.max(max1,dp1[j]);
            }
            dp1[i]+=max1;
        }
        //LIS FROM right to left(LDS)
        for(int i=n-2;i>0;i--){
            int max2=0;
            for(int j=i+1;j<n;j++){
                if(nums[j]<nums[i]) max2 =Math.max(max2,dp2[j]);
            }
            dp2[i]+=max2;
        }
        int maxLen =0;
        for(int i=0;i<n;i++){
            if(dp1[i]!=1 && dp2[i]!=1){
                maxLen = Math.max(maxLen,dp2[i]+dp1[i]-1);
            }
        }
return n-maxLen;
    }
}