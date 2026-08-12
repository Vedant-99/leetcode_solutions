class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if(n<4) return ans;
        Arrays.sort(nums);
        for(int i=0;i<n-3;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n-2;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int start = j+1, stop = n-1;
                while(start<stop){
                    long sum = (long)nums[i]+nums[j]+nums[start]+nums[stop];
                    if(sum==target){ 
                    ans.add(Arrays.asList(nums[i],nums[j],nums[start],nums[stop]));
                    while(start<stop && nums[start]==nums[start+1]) start++;
                    while(start<stop && nums[stop]==nums[stop-1]) stop--;
                    start++;
                    stop--;
                    }
                    else if(sum>target) stop--;
                    else start++;

                }
            }

        }
        return ans;
        
    }
}