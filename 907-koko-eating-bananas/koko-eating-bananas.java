class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int ele :piles) max = Math.max(max,ele);

        int low =1,high = max, ans=-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(isPossible(mid,piles)<=h){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }
    public long isPossible(int speed,int[] arr){
        long hours =0;
        for(int ele:arr){
            hours+=(long)(Math.ceil((double)ele/speed));
            // if(ele%speed == 0) hours+=ele/speed;
            // else hours+=(ele/speed+1);

        }
    return hours;
    }
}