class Solution {
    class Pair implements Comparable<Pair>{
        int ele, freq;
        Pair(int ele,int freq){
            this.ele = ele;
            this.freq = freq;
        }
        public int compareTo(Pair p){
            if(this.freq==p.freq) return Integer.compare(this.ele,p.ele);
            return Integer.compare(this.freq,p.freq);
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
         for(int i: nums) map.put(i,map.getOrDefault(i,0)+1);
        PriorityQueue<Pair> pq = new PriorityQueue<>(  );
        for(int i : map.keySet()){
            int freq = map.get(i);
            pq.add(new Pair(i,freq));
            if(pq.size()>k) pq.remove();
        }
        int[] ans = new int[k]; 
        for(int i=0;i<k;i++){
            ans[i]=pq.remove().ele;
        }
        return ans;  
    }
}