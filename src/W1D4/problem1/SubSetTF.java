package W1D4.problem1;

public class SubSetTF
{
    static void subSetTF(int[] set, int k)
    {
        boolean[] dp = new boolean[k+1];
        dp[0] = true;
        dp[set[0]] = true;
        for(int i=1;i<set.length;i++)
        {
            for(int j=1; j<=k;j++)
            {
                if(j >= set[i])
                {
                    dp[j] = dp[j-set[i]];
                }

                System.out.print(dp[j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void main(String[] args) {
        int[] set = {2,3,5};
        int k= 8;
        subSetTF(set,k);
    }
}
