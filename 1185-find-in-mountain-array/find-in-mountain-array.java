/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int low = 0,high = mountainArr.length() -1;
        int peak =-1;
        // Finding peak 
        while(low<high){
            int mid = low+(high-low)/2;
            if(mountainArr.get(mid)<mountainArr.get(mid+1)) low = mid+1;
            else high = mid;
        }
        peak = low;


        // Appplying BS to strictly increasing part [0,peak]
        low = 0;
        high = peak;
        while(low<=high){
            int mid = low+(high-low)/2;
            int val = mountainArr.get(mid);
            if(val==target) return mid;
            if(val<target) low = mid+1;
            else high = mid-1;
        }


        // Applying BS to strictly decreasing part [peak,arr.length-1]


        low = peak+1;
        high = mountainArr.length()-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int val = mountainArr.get(mid);
            if(val==target) return mid;
            else if(val>target) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
}