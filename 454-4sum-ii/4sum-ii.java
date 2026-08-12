class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums1){
            for(int j:nums2){
                int ans=i+j;
                map.put(ans,map.getOrDefault(ans,0)+1);
            }
        }
            int ans =0;
            for(int k:nums3){
                for(int l:nums4){
                    int sum = k+l;
                    ans+=map.getOrDefault(-sum,0);
                }
            }
        
            return ans;
    }
}