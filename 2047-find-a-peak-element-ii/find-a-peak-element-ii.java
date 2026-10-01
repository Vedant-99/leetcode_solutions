class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;   
        int n = mat[0].length;
        int low = 0,high = n-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int maxRow = 0;
            for(int i=0;i<m;i++){
                if(mat[i][mid]>mat[maxRow][mid]){
                    maxRow = i;
                }
            }
            int leftNeighbour = (mid>0)? mat[maxRow][mid-1]:-1;
            int rightNeighbour = (mid<n-1)? mat[maxRow][mid+1]:-1;

            if(mat[maxRow][mid]>leftNeighbour && mat[maxRow][mid]>rightNeighbour){
                return new int[]{maxRow,mid};
            }
            else if(mat[maxRow][mid]>leftNeighbour){
                low = mid+1;
            }
            else high = mid-1;
        }
    return new int[]{-1,-1};
    }
}