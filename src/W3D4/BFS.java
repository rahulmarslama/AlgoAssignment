package W3D4;

import java.util.*;

//Java program to find all components of a graph given the adjacency matrix through
// BFS.
public class BFS
{
    int[] mark;
    int numberComponent;
    int[] componentNumber;
    int componentNumberIndex;

    public BFS(int numberOfVertices)
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
            Queue<Integer> queue = new LinkedList<Integer>();
            int s = selectVerticeNotMarked();
            queue.add(s);
            mark[s] =1;

            while(!queue.isEmpty())
            {
                int v= queue.remove();
                componentNumber[v] = numberComponent;
                List<Integer> unvisitedAdjacentTov = getUnvisitedAdjacent(v,adjMatrix[v]);

                for(var w: unvisitedAdjacentTov)
                {
                    mark[w] = 1;
                    queue.add(w);
                }
            }


        }
        return componentNumber;

    }

    private List<Integer> getUnvisitedAdjacent(int v, int[] vAdj)
        {
            List<Integer> returnList = new ArrayList<>();
            for(int i=0;i<vAdj.length;i++)
            {
                if(vAdj[i]==1)
                {
                    if(mark[i]==0)
                    {
                        returnList.add(i);
                    }
                }
            }
            return returnList;
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
