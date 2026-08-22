class Solution {
    public int maxEnvelopes(int[][] envelops) {
        Arrays.sort(envelops,(a,b)-> (a[0]!=b[0])? Integer.compare(a[0],b[0]):Integer.compare(b[1],a[1]));

        ArrayList<Integer> ans = new ArrayList<>();
        for(int[] a:envelops){
            int ele=a[1];
            if(ans.size()==0 || ele > ans.get(ans.size()-1)) ans.add(ele);
            else replace(ele,ans);
        }
        return ans.size();
    }
    public void replace(int ele,ArrayList<Integer>ans){
        // Find lower bond:
        int low = 0, high = ans.size()-1, lowerbond = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(ans.get(mid)>=ele){
                lowerbond = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        ans.set(lowerbond,ele);
    }
}
