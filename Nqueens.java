import java.util.Scanner;

class NQueensHelper{
    int board[][] = new int[11][11];
    public boolean isPossible(int row,int n,int j){

        for(int i = row;i>=0;i--){
            if(board[i][j]!=0){
                return false;
            }
        }
        for(int i = row, k = j;i>=0 && k>=0;i--,k--){
            if(board[i][k]!=0){
                return false;
            }
        }
        for(int i = row, k = j;i>=0 && k<n;i--,k++){
            if(board[i][k]!=0){
                return false;
            }
        }
        return true;
    }
    public  void nqueens(int row,int n){
        if(row==n){
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    System.out.print(board[i][j]+" ");
                }
            }
            System.out.println();
            return;
        }
        for(int i = 0;i<n;i++){
            if(isPossible(row,n,i)){
                board[row][i] = 1;
                nqueens(row+1,n);
                board[row][i] = 0;
            }
        }
   }
}
public class Nqueens{

    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        NQueensHelper nqueens = new NQueensHelper();
        nqueens.nqueens(0,n);
        sc.close();
    }
}