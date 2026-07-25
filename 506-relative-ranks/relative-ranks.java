class Solution {
    class Pair implements Comparable<Pair>{
        int num;
        int idx;
        Pair(int num,int idx){
            this.num = num;
            this.idx = idx;
        }
       public int compareTo(Pair p){
             return Integer.compare(p.num,this.num);
        }
    }
    public String[] findRelativeRanks(int[] score) {
        String[] r = new String[score.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0;i<score.length;i++){
            pq.add(new Pair(score[i],i));
        }
        int place =1;
        while(!pq.isEmpty()){
            Pair current = pq.poll();
            int newidx = current.idx;
            if(place==1) r[newidx]="Gold Medal";
            else if(place==2) r[newidx]="Silver Medal";
            else if(place==3) r[newidx]="Bronze Medal";
            else r[newidx] = String.valueOf(place);
            place++;
        }
        return r;

    }
}