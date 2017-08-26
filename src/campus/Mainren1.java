package campus;

/**
 * Created by Yang on 2017/4/20.
 */
public class Mainren1 {

    public static int[][] getresult(int initvalue,int row,int clum){

        //初始矩阵
        int[][] init = new int[row][clum];
        //初始化初始矩阵
        for(int i=0;i<row;i++){
            for (int j=0;j<clum;j++){
                init[i][j] = initvalue++;
            }
        }
        int[][] initreverse = new int[clum][row];
        for(int i=0;i<clum;i++){
            for(int j=0;j<row;j++){
                initreverse[i][j] = init[j][i];
            }
        }

        int[][] res = new int[row][row];
        for(int i=0;i<init.length;i++) {
            for(int j=0;j<initreverse[0].length;j++) {
                int sum = 0;
                for(int k=0;k<initreverse.length;k++) {
                    sum += init[i][k] * initreverse[k][j];
                }
                res[i][j] = sum;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] res = getresult(3,4,2);
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[0].length;j++){
                System.out.print(res[i][j]+" ");
            }
        }
    }
}
