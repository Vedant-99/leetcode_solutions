class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks,(a,b)->(b[1]-b[0])-(a[1]-a[0]));
        int low = 0;
        int high = 0;

        for(int[] task:tasks){
            low+=task[0];
            high+=task[1];
        }
        int ans = high;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(isPossible(tasks,mid)){
                ans = mid;
                high= mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }

    public boolean isPossible(int[][] tasks,int a){
        for(int[] task: tasks){
           int  actual = task[0];
            int minimum = task[1];
            if(a<minimum) return false;
            a -= actual;
        }
return true;
    }
}