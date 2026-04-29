package W1D2.prob1;

public class Algo1
{
    int thirdLargest(int[] arr)
    {
        int largest = Integer.MIN_VALUE;
        int largestIndex = 0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i] > largest)
            {
                largest = arr[i];
                largestIndex = i;
            }
        }


        int secondLargest = Integer.MIN_VALUE;
        int secondLargestIndex =0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i] >= secondLargest && i != largestIndex)
            {
                secondLargest = arr[i];
                secondLargestIndex =i;
            }
        }

        int thirdLargest = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i] >= thirdLargest && i != largestIndex && i!= secondLargestIndex)
            {
                thirdLargest = arr[i];
            }
        }

        return  thirdLargest;

    }

    public static void main(String[] args)
    {
        Algo1 algo = new Algo1();

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
