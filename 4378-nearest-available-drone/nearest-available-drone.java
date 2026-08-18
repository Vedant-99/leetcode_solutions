class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int mindist=Integer.MAX_VALUE;
        int bestIdx = -1;
        for(int i = 0;i<drones.length;i++){
            int x = Math.abs(drones[i][0]-target[0]);
            int y = Math.abs(drones[i][1]-target[1]);
            int r = x+y;
            if(r<=drones[i][2] && r< mindist){
                mindist = r;
                bestIdx = i;
            }
        }
        return bestIdx;
    }
}