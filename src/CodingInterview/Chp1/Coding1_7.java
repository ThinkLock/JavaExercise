package CodingInterview.Chp1;
public class Coding1_7{

  public int[][] clearZero(int[][] mat){
    int m = mat.length;
    int n = mat[0].length;

    boolean[] rows = new boolean[m];
    boolean[] clums = new boolean[n];

    for(int i=0;i<m;i++){
      for(int j=0;j<n;j++){
        if(mat[i][j]==0){
          rows[i]=true;
          clums[j] = true;
        }
      }
    }

    for(int i=0;i<m;i++){
      for (int j=0; j<n; j++) {
        if(rows[i] || clums[j]){
          mat[i][j]=0;
        }
      }
    }

    return mat;
  }


  public static void main(String[] args) {

  }
}
