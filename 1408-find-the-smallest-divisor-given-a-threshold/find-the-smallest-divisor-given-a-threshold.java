class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
    int min = Integer.MAX_VALUE;   
    int max = Integer.MIN_VALUE;
    for(int i=0;i<nums.length;i++){
        if(nums[i]>max) max =nums[i];
        if(nums[i]<min) min =nums[i];
    }
    int low = 1;
    int high = max;
    while(low<=high){
        int mid = low+(high-low)/2;
        int value = isPossible(nums,mid);
        if(value<=threshold) high = mid-1;
        else low = mid+1;
    }
     return low; 
    }
    public int isPossible(int[] nums,int k){
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += (nums[i]+k-1)/k;
        
        }
        return sum;
    }
}