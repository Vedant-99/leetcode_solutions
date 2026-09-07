class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int ele:bloomDay){
            if(ele<min) min = ele;
            if(ele>max) max= ele;
        }
        int low = min,high=max;
        int ans=-1;
        while(low<=high){
            int mid= low+(high-low)/2;
            if(isPossible(bloomDay,mid,m,k)){
                ans= mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }
    public boolean isPossible(int[] arr,int maxDay,int m, int k){
        int flowers = 0;
        int noBouqet = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=maxDay){
                flowers++;
            }
            else flowers=0;
            if(flowers==k){
                noBouqet++;
                flowers=0;
                }
        }

        return (noBouqet>=m);
        }


}