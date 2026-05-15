package W3D4;
import W3D4.DFS;

public class Main
{
    static int[][] matrix =
            {
                    new int[]{0,1,1,0,0,1,0,0,0}, //A
                    new int[]{1,0,0,0,0,1,0,0,0}, //B
                    new int[]{1,0,0,0,0,1,1,0,0}, //C
                    new int[]{0,0,0,0,1,0,0,0,1}, //D
                    new int[]{0,0,0,1,0,0,0,0,1}, //E
                    new int[]{1,1,1,0,0,0,0,1,0}, //F
                    new int[]{0,0,1,0,0,0,0,1,0}, //G
                    new int[]{0,0,0,0,0,1,1,0,0}, //H
                    new int[]{0,0,0,1,1,0,0,0,0}  //I
            };

    static void main(String[] args) {

        System.out.println("////////////////");
        System.out.println("//////    DFS    /////");
        System.out.println("////////////////");
        DFS dfs = new DFS(matrix.length);
        int[] res = dfs.getComponents(matrix);

        for(int i=0;i<res.length;i++)
        {
            System.out.print(res[i] + " ");
        }
        System.out.println();

        System.out.println("////////////////");
        System.out.println("//////    BFS    /////");
        System.out.println("////////////////");
        BFS bfs = new BFS(matrix.length);
        int[] res2 = bfs.getComponents(matrix);

        for(int i=0;i<res2.length;i++)
        {
            System.out.print(res2[i] + " ");
        }
    }

}
