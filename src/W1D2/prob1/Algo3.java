package W1D2.prob1;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Algo3
{
    int thirdLargest(int[] arr)
    {
        if(arr.length <3)
        {
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : arr) {
            pq.add(i);
        }
        pq.poll();
        pq.poll();
        return pq.peek();

    }

    public static void main(String[] args)
    {
        Algo3 algo = new Algo3();

        int[] arr1 = {5, 1, 3, 2, 4};
        System.out.println("Test 1: " + algo.thirdLargest(arr1)); // expected: 3

        int[] arr2 = {-1, -5, -3, -2, -4};
        System.out.println("Test 2: " + algo.thirdLargest(arr2)); // expected: -3

        int[] arr3 = {5, 5, 4, 3, 2};
        System.out.println("Test 3: " + algo.thirdLargest(arr3)); // expected: 4

        int[] arr4 = {7, 20, 18, 4, 20, 19, 20, 3};
        System.out.println("Test 4: " + algo.thirdLargest(arr4)); // expected: 20

        int[] arr5 = {5, 4, 3, 2, 1};
        System.out.println("Test 5: " + algo.thirdLargest(arr5)); // expected: 3

        int[] arr6 = {-10, 5, 3, 8, 1};
        System.out.println("Test 6: " + algo.thirdLargest(arr6)); // expected: 3
    }

}
