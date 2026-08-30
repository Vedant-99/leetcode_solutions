class Solution {
    public int shipWithinDays(int[] weights, int d) {
        int sum =0;
        int max= Integer.MIN_VALUE;
        for(int ele:weights){
            sum+=ele;
            max = Math.max(max,ele);
        }
        
        // Capacity ranges from::   Max element of array to total sum of array

        int low = max;
        int high = sum;
        int ans = -1;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(isPossible(mid,weights)<=d){
                high = mid-1;
                ans = mid;
            }
            else low = mid+1;
        }
        return ans;
    }
    public int isPossible(int capacity,int[] arr){
        int days = 0;
        int cap = capacity;
        for(int ele : arr) {
            if(cap>=ele) cap-=ele;
            else{
                days++;
                cap = capacity-ele;
            }
        }
            days++;
        return days;
    }
}