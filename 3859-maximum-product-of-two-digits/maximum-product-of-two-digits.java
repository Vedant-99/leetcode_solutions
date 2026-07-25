class Solution {
    public int maxProduct(int n) {
    ArrayList<Integer> ans = new ArrayList<>();
    while(n>0){
        ans.add(n%10);
        n/=10;
    }
    int Size = ans.size();
    Collections.sort(ans);
    return ans.get(Size-1)*ans.get(Size-2);
    }
}