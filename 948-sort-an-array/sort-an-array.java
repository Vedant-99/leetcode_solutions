class Solution {
    public int[] sortArray(int[] nums) {
        merge(nums);
        return nums;
    }
    public void merge(int[] nums){
        int n= nums.length;
        if(n<=1) return; 
        int[] a = new int[n/2];
        int[] b = new int[n-n/2];
        int idx=0;
        for(int i =0;i<a.length;i++){
            a[i]=nums[idx];
            idx++;
        }
        for(int i=0;i<b.length;i++){
            b[i]=nums[idx];
            idx++; 
        }
        merge(a);
        merge(b);
        mergeArray(a,b,nums);
    }
    public void mergeArray(int[] a,int[] b,int[] c){
        int i =0,j=0,k=0;
        while(i<a.length && j<b.length){
            if(a[i]<=b[j]){
                c[k++] = a[i++];
            }
            else{
                c[k++]=b[j++];
            }
        }
        while(i<a.length) c[k++] = a[i++];
        while(j<b.length) c[k++] = b[j++];

    }
}