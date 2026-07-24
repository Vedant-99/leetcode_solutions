class Solution {
    class Triplet implements Comparable<Triplet>{
        int val;
        int row;
        int col;
        Triplet(int val,int row,int col){
            this.val = val;
            this.row = row;
            this.col = col;
        }
        public int compareTo(Triplet t){
            return Integer.compare(this.val,t.val);
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
       PriorityQueue<Triplet> pq = new PriorityQueue<>();
       int k = nums.size();
       int max = Integer.MIN_VALUE;
       for(int i=-0;i<k;i++){
        int value = nums.get(i).get(0);
        pq.add(new Triplet(value,i,0));
        max = Math.max(max,value);
       }
       int start = pq.peek().val;
       int end = max;
       while(true){
        Triplet curr = pq.poll();
        int min = curr.val;
        if(max-min < end -start){
            start = min;
            end = max;
        }
    int nextCol = curr.col+1;
    if(nextCol == nums.get(curr.row).size()) break;
    int nextVal = nums.get(curr.row).get(nextCol);
    pq.add(new Triplet(nextVal,curr.row,nextCol));
    max = Math.max(max,nextVal);
       }
       return new int[]{start,end}; 
    }
}