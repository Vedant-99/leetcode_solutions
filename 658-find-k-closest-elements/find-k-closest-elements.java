class Solution {
    class Pair implements Comparable<Pair>{
        int dist;
        int val;
        Pair(int dist ,int val){
            this.dist = dist;
            this.val = val;
        }
        public int compareTo(Pair p){
            if(this.dist != p.dist) return Integer.compare(this.dist,p.dist);
            return Integer.compare(this.val ,p.val);
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : arr){
            pq.add(new Pair(Math.abs(i-x),i));
            if(pq.size()>k) pq.remove();
        }
        while(pq.size()>0){
            Pair top = pq.remove();
            int aa = top.val;
            ans.add(aa);
        }
        Collections.sort(ans);
        return ans;
    }
}