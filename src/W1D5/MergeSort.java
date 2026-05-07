package W1D5;

public class MergeSort
{
    static void Sort(int[] arr,int left,int right)
    {
        if(left<right)
        {
            int mid= left + (right-left)/2;

            Sort(arr,left,mid);
            Sort(arr,mid+1,right);
            Merge(arr,left,mid,right);

        }


    }

    static void Merge(int[] arr,int left,int mid,int right)
    {
        int n1= mid-left+1;
        int n2= right - mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for(int a =0;a<n1;a++)
        {
            leftArr[a] = arr[left+a];
        }

        for(int a =0;a<n2;a++)
        {
            rightArr[a] = arr[mid + 1 + a];
        }



        int i=0;
        int j=0;
        int k=left;

        while(i<n1 && j<n2)
        {
            if(leftArr[i] <= rightArr[j])
            {
                arr[k] = leftArr[i];
                i++;
                k++;
            }
            else
            {
                arr[k] = rightArr[j];
                j++;
                k++;
            }
        }

        while(i!=n1)
        {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while(j!=n2)
        {
            arr[k] = rightArr[j];
            j++;
            k++;
        }

    }

    static void Print(int[] arr)
    {
        for (int x: arr)
            System.out.print(x + " ");
        System.out.println();
    }

    static void main(String[] args)
    {
        int[] arr = { 38, 27, 43, 3, 9,3, 82, 10 };

        System.out.println("Before: ");
        Print(arr);

        Sort(arr, 0, arr.length - 1);

        System.out.println("After:  ");
        Print(arr);
    }

}
