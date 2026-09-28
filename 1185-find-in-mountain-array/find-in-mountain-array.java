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
        int low = 0,high = mountainArr.length()-1;
        int peek = -1;
        while(low<high){
            int mid = low+(high-low)/2;
            if(mountainArr.get(mid)<mountainArr.get(mid+1)) low = mid+1;
            else high = mid;
        }
        peek = low;


        low = 0;
        high = peek;
        while(low<=high){
            int mid = low+(high -low)/2;
            int val = mountainArr.get(mid);
            if(val==target) return mid;
            else if(val<target) low = mid+1;
            else high = mid-1;
        }

        low = peek+1;
        high = mountainArr.length()-1;
        while(low<=high){
            int mid = low+(high -low)/2;
            int val = mountainArr.get(mid);
            if(val==target) return mid;
            else if(val>target) low = mid+1;
            else high = mid-1;
        }
return -1;


    }
}