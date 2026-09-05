class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] maxArr = new int[n];
        int[] minArr = new int[n];

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            maxArr[i] = max;
        }

        int min = Integer.MAX_VALUE;
        for(int i = n-1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            minArr[i] = min;
        }

        for(int i = 0; i < n; i++) {
            int stable = maxArr[i] - minArr[i];
            if(stable <= k) return i;
        }

        return -1;
    }
}