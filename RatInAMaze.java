import java.util.Scanner;
class RatInAMazeCode{
    
    public void printSolution(int solution[][],int n ){
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                System.out.print(solution[i][j]+" ");
            }
        }
        System.out.println();
        return;
    }
    public void ratInAMazeCodeHelpper(int maze[][],int solution[][],int n,int i,int j){
        if(i==n-1 && j ==n-1){
            solution[i][j] = 1;
            printSolution(solution, n);
            solution[i][j] = 0;
            return;
        }

        if(i<0 || j<0 || i>=n|| j>=n || maze[i][j] == 0 || solution[i][j]==1){
            return;
        }
        solution[i][j] = 1;
        ratInAMazeCodeHelpper(maze, solution, n, i, j+1);
        ratInAMazeCodeHelpper(maze, solution, n, i, j-1);
        ratInAMazeCodeHelpper(maze, solution, n, i+1, j);
        ratInAMazeCodeHelpper(maze, solution, n, i-1, j);
        solution[i][j] = 0;
        return;
    }

    public void solution(int maze[][],int n){
        int solution[][] = new int[n][n];
        ratInAMazeCodeHelpper(maze,solution, n, 0, 0);
    }
}
public class RatInAMaze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Maze Size: ");
        int n = sc.nextInt();
        int maze[][] = new int[n][n];
        System.out.println("Enter Maze: ");
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                maze[i][j] = sc.nextInt();
            }
        }
        RatInAMazeCode code = new RatInAMazeCode();
        code.solution(maze,n);
        sc.close();
    }
}