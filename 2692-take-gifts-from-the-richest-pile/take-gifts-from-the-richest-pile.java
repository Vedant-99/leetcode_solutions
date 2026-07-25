class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i:gifts) pq.add(i);
        for(int i=0;i<k;i++){
            int ele = pq.poll();
            int remaining = (int)(Math.sqrt(ele));
            pq.add(remaining);
        }
        long noOfGifts = 0;
        while(pq.size()>0){
            noOfGifts +=pq.poll();
        }

        return noOfGifts;
    }
}