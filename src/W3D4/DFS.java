package W3D4;

import java.util.Arrays;
import java.util.Stack;

//Java program to find all components of a graph given the adjacency matrix through
// DFS.
public class DFS
{

    int[] mark;
    int numberComponent;
    int[] componentNumber;
    int componentNumberIndex;

    public DFS(int numberOfVertices)
    {
        mark = new int[numberOfVertices];
        numberComponent=0;
        componentNumber = new int[numberOfVertices];
        componentNumberIndex = numberOfVertices;
    }

    public int[] getComponents(int[][] adjMatrix)
    {
        while(anyUnvisitedVertices())
        {
            numberComponent++;
            Stack<Integer> stack = new Stack<Integer>();
            int s = selectVerticeNotMarked();
            stack.push(s);
            mark[s] =1;
            while(!stack.isEmpty())
            {
                int v = stack.peek();
                int w= adjacentVertexUnvisited(v,adjMatrix[v]);
                if(w!=-1)
                {
                    mark[w]=1;
                    stack.push(w);
                }
                else
                {
                    componentNumber[stack.pop()]=numberComponent;
                }
            }
        }
        return componentNumber;

    }

    private int adjacentVertexUnvisited(int v,int[] vAdj)
    {
        for(int i=0;i<vAdj.length;i++)
        {
            if(vAdj[i]==1)
            {
                if(mark[i]==0)
                {
                    return i;
                }
            }
        }
        return -1;
    }
    private boolean anyUnvisitedVertices()
    {
        for(int i=0;i<mark.length;i++)
        {
            if(mark[i]==0)
            {
                return true;
            }
        }
        return false;
    }

    private int selectVerticeNotMarked()
    {
        for(int i=0;i<mark.length;i++)
        {
            if(mark[i]==0)
            {
                return i;
            }
        }
        return -1;
    }
}
