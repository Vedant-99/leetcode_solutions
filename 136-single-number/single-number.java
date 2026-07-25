class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i: nums){
            if(set.contains(i)) set.remove(i);
            else set.add(i);
        }
        for(int n :set) return n;
        return -1;
    }
}