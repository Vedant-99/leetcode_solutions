class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(max<nums[i]){
                max2 = max;
                max = nums[i];
            }
            else if(max2<nums[i]) max2 =  nums[i];
        }
        return (max-1)*(max2-1);
    }
}