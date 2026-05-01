package W1D3.problem1;

public class prob1A
{
          /* 5	6	7	8	9
            10	11	12	13	14
            15	16	17	18	19
            20	21	22	23	24
            25	26	27	28	29*/

    static int[][] firstAlgo(int n)
    {
        int val =n;
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j] = val;
                val++;
            }
        }
        return arr;

    }

//            5	10	15	20	25
//            6	11	16	21	26
//            7	12	17	22	27
//            8	13	18	23	28
//            9	14	19	24	29

    static int[][] thirdAlgo(int n)
    {
        int point = n;
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++)
        {
            int val = point;
            for(int j=0;j<n;j++)
            {
                arr[i][j] = val;
                val += n;
            }
            point++;
        }
        return arr;

    }

//            5	    7	8	14	15
//            6	    9	13	16	23
//            10	12	17	22	24
//            11	18	21	25	28
//            19	20	26	27	29

    static int[][] secondAlgo(int n)
    {;
        int[][] matrix = new int[n][n];
        int num = n;

        for (int d = 0; d < 2 * n - 1; d++)
        {
            int startRow = Math.max(0, d - (n - 1));
            int startCol = Math.min(d, n - 1);

            int cells = Math.min(d + 1, n) - Math.max(0, d - (n - 1));

            if (d % 2 == 0)
            {
                for (int k = 0; k < cells; k++)
                {
                    matrix[startRow + k][ startCol - k] = num++;
                }
            }
            else
            {
                for (int k = cells - 1; k >= 0; k--)
                {
                    matrix[startRow + k][startCol - k] = num++;
                }
            }
        }
        return matrix;
    }


    //Time Complexity = O(n^2)
    //Space Complexity = O(1)
    static void searchSS(int[][] M, int key)
    {
        for(int i=0;i<M.length;i++)
        {
            for(int j=0;j<M[i].length;j++)
            {
                if(M[i][j]==key)
                {
                    System.out.println("("+i+","+j+")");
                    return;
                }
            }
        }
        System.out.println("Not Found");
    }

    static void DACSearchSS(int[][] M, int key)
    {
        int i;
        for(i=0;i < M.length-1;i++)
        {
            if(key > M[i][M.length-1]) //the last in the row
            {
                continue;
            }
            else
            {
                break;
            }
        }

        int left =0;
        int right = M[i].length-1;
        int pos = DACSearchSSRec(M[i],key,left,right);
        if(pos>=0)
        {
            System.out.println("("+i+","+pos+")");
        }
        else
        {
            System.out.println("Not Found");
        }
    }

    //only works for the first algo
    //Time Complexity = O(log n)
    //Space Complexity = O(n)
    static int DACSearchSSRec(int[] arr,int key,int left,int right)
    {
        if(left > right) return -1;
        int mid = left + (right-left)/2;

        if(key > arr[mid])
        {
            return DACSearchSSRec(arr,key,mid+1,right);
        }
        else if(key<arr[mid])
        {
            return DACSearchSSRec(arr,key,left,mid-1);
        }
        else
        {
            return mid;
        }

    }

    static void main(String[] args) {
        int[][] firstArr = firstAlgo(5);
        for (int[] ints : firstArr) {
            for (int anInt : ints) {
                System.out.print(anInt);
                System.out.print(" ");
            }
            System.out.println();
        }


        int[][] secondArr = secondAlgo(5);
        for (int[] ints : secondArr) {
            for (int anInt : ints) {
                System.out.print(anInt);
                System.out.print(" ");
            }
            System.out.println();
        }

        int[][] thirdArr = thirdAlgo(5);
        for (int[] ints : thirdArr) {
            for (int anInt : ints) {
                System.out.print(anInt);
                System.out.print(" ");
            }
            System.out.println();
        }

        searchSS(secondArr,23);

        DACSearchSS(firstArr,5);

    }

}
