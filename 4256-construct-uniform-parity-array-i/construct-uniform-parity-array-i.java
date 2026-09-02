class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;

        if(n == 1) return true;

        int[] nums2_even = new int[n];
        int[] nums2_odd = new int[n];
        for(int i = 0; i < n; i++) {
            if(nums1[i]%2 != 0) nums2_even[i] = 0;
            else nums2_even[i] = nums1[i];

            if(nums1[i]%2 == 0) nums2_odd[i] = -1;
            else nums2_odd[i] = nums1[i];
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j) {
                    if(nums1[i] == nums2_odd[i] || nums2_odd[i] == nums1[i] - nums1[j]) {
                        return true;
                    }

                    if(nums1[i] == nums2_even[i] || nums2_even[i] == nums1[i] - nums1[j]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}