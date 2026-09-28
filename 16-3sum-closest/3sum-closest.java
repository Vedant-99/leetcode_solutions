class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closestSum = nums[0]+nums[1]+nums[2];
        for(int i=0;i<n-2;i++){
            if(i>0&&nums[i-1]==nums[i]) continue;
            int start = i+1,end = n-1;
            while(start<end){
                int currentSum = nums[i]+nums[start]+nums[end];

                if(currentSum==target) return currentSum;
                if(Math.abs(currentSum-target)<Math.abs(closestSum-target)){
                    closestSum= currentSum;
                }
                if(currentSum<target) start++;
                else end--;
            }

        }
        return closestSum;
    }
}