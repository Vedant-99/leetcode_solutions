class Solution {
    class Pair implements Comparable<Pair>{
        int freq;
        String s;
        Pair(int freq,String s){
            this.freq = freq;
            this.s = s;
        }
        public int compareTo(Pair p){
            if(p.freq != this.freq) return Integer.compare(p.freq,this.freq);
            return this.s.compareTo(p.s);
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String s:words) map.put(s,map.getOrDefault(s,0)+1);

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(String s:map.keySet()){
            pq.add(new Pair(map.get(s),s));
        }
        List<String> result = new ArrayList<>();
        while(k>0){
            result.add(pq.remove().s);
            k--;
        }
        return result;

    }
}