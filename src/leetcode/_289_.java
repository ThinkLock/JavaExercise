package leetcode;
public class _289_{

    public static int getNeiAliveNum(int[][] board,int i,int j){
        int m = board.length;
        int n = board[0].length;

        int[][] board_ex = new int[m+2][n+2];

        for(int x=0;x<m+2;x++){
            for(int y=0;y<n+2;y++){
                if(x<1 || x>m || y<1 || y>n){
                    board_ex[x][y] = 0;
                }else{
                    board_ex[x][y] = board[x-1][y-1];
                }
            }
        }

        int i_l = i-1;
        int j_l = j-1;
        int i_r = i+1;
        int j_r = j+1;
        int result  = 0;
        
        for(int x=i_l;x<=i_r;x++){
            for(int y=j_l;y<=j_r;y++){
                result += board_ex[x][y];
            }
        }

        return result;
    }


    public static void gameOfLife(int[][] board) {
        
        if(board==null || board.length==0) return;
        int m = board.length;   
        int n = board[0].length;
        int[][] next_state = new int[m][n];
        for(int x=0;x<m;x++){
            for(int y=0;y<n;y++){
                int numoflive = getNeiAliveNum(board, x, y);
                if(board[x][y]==1){
                    if(numoflive<2){
                        next_state[x][y] = 0;
                    }else if(numoflive>=2 && numoflive<=3){
                        next_state[x][y] = 1;
                    }else if(numoflive>3){
                        next_state[x][y] = 0;
                    }
                }else{
                    if(numoflive==3){
                        next_state[x][y] = 1;
                    }
                }
            }
        }
        board = next_state;
    }


    public static void main(String[] args) {
        
    }
}