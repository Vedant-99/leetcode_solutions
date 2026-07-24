class Solution {
    class Triplet implements Comparable<Triplet>{
        int value;  //value → actual value
        int row;    //row → which list it came from
        int col;    //col → index inside that list
        Triplet(int value,int row,int col){
            this.value = value;
            this.row = row;
            this.col = col;
        }
        public int compareTo(Triplet t){
            return Integer.compare(this.value,t.value);
        }


    }
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        int k = nums.size();
        int max = Integer.MIN_VALUE;

        for(int i=0;i<k;i++){
            int val = nums.get(i).get(0);
            pq.add(new Triplet(val,i,0));
            max = Math.max(val,max);
        }
        int start = pq.peek().value;
        int end = max;
        while(true){
            Triplet curr = pq.remove();
            int min = curr.value;
            if(max-min < end-start){
                start = min;
                end = max;
            }
            int nextCol = (curr.col+1);
            if(nextCol == nums.get(curr.row).size()) break;
            int nextVal = nums.get(curr.row).get(nextCol);
            pq.add(new Triplet(nextVal,curr.row,nextCol));
            max = Math.max(max,nextVal);
        }
        return new int[]{start,end};

    }
}