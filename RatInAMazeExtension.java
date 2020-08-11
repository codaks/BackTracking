import java.util.Scanner;
class RatInAMazeExtensionCode{
    
    public void printSolution(int solution[][],int n ){
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                System.out.print(solution[i][j]+" ");
            }
        }
        System.out.println();
        return;
    }
    public void ratInAMazeCodeHelpper(int maze[][],int solution[][],int n,int i,int j,int dst_i,int dst_j){
        if(i==dst_i-1 && j ==dst_j-1){
            solution[i][j] = 1;
            printSolution(solution, n);
            solution[i][j] = 0;
            return;
        }

        if(i<0 || j<0 || i>=n|| j>=n || maze[i][j] == 0 || solution[i][j]==1){
            return;
        }
        solution[i][j] = 1;
        ratInAMazeCodeHelpper(maze, solution, n, i, j+1,dst_i,dst_j);
        ratInAMazeCodeHelpper(maze, solution, n, i, j-1,dst_i,dst_j);
        ratInAMazeCodeHelpper(maze, solution, n, i+1, j,dst_i,dst_j);
        ratInAMazeCodeHelpper(maze, solution, n, i-1, j,dst_i,dst_j);
        solution[i][j] = 0;
        return;
    }

    public void solution(int maze[][],int n,int dst_i,int dst_j){
        int solution[][] = new int[n][n];
        ratInAMazeCodeHelpper(maze,solution, n, 0, 0,dst_i,dst_j);
    }
}
public class RatInAMazeExtension {
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
        System.out.println("Enter Destination: ");
        int dst_i = sc.nextInt();
        int dst_j = sc.nextInt();
        RatInAMazeExtensionCode code = new RatInAMazeExtensionCode();
        code.solution(maze,n,dst_i,dst_j);
        sc.close();
    }
}