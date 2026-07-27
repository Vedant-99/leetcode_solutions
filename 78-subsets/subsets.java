class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<Math.pow(2,n);i++){
            List<Integer> ans = new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i>>j)%2==1) ans.add(nums[j]);
            }
            res.add(ans);
        }
        return res;
    }
}