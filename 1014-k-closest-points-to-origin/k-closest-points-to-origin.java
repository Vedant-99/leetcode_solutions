class Solution {
    class triplet implements Comparable<triplet>{
        int x,y,dist;
        triplet(int x,int y,int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
        public int compareTo(triplet t){
            return Integer.compare(t.dist,this.dist);
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<triplet> pq = new PriorityQueue<>();
        for(int[] point : points){
            int x = point[0];
            int y = point[1];
            int dist = x*x + y*y;

            pq.add(new triplet(x,y,dist));
            if(pq.size()>k) pq.remove();
        }
        int[][] ans = new int[k][2];
        for(int i=0;i<k;i++){
            triplet top = pq.remove();
            ans[i][0] = top.x;
            ans[i][1] = top.y;
        }
        return ans;
    }
}