class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] mat = new char[n][n];
        for(char ch[]:mat) Arrays.fill(ch,'.');
        nQueens(0,mat,res);
        return res;
    }
    public void nQueens(int row,char[][] chessBoard,List<List<String>> res){
        int n = chessBoard.length;
        if(row==n){
            List<String> ans = new ArrayList<>();
            for(int i=0;i<n;i++){
                ans.add(new String(chessBoard[i]));
                }
                res.add(ans);
            return;
        }
        for(int col=0;col<n;col++){
            if(canQueenPlaced(row,col,chessBoard)){
                chessBoard[row][col]='Q';
                nQueens(row+1,chessBoard,res);
                chessBoard[row][col]='.';
            }
        }
    }
    public boolean canQueenPlaced(int row, int col, char[][] chessBoard){
        int n = chessBoard.length;
        // check col
        int i = row-1;
        while(i>=0){
            if(chessBoard[i][col]=='Q') return false;
            i--;
        }

        // check left diagonal:
        i = row-1;
        int j = col-1;
        while(i>=0 && j>=0){
            if(chessBoard[i][j]=='Q') return false;
            i--;
            j--;
        }

        // check right diagonal:
        i = row-1;
        j = col+1;
        while(i>=0 && j<n){
            if(chessBoard[i][j]=='Q') return false;
            i--;
            j++;
        }
        return true;
    }

}