class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int low =0,high = row*col-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int midRow = mid/col;
            int midCol = mid%col;
            if(matrix[midRow][midCol]==target) return true;
            else if(matrix[midRow][midCol]<target) low = mid+1;
            else high = mid-1;
        }
        return false;
    }
}