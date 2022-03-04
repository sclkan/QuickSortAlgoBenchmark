/**
 * Investigates the recursion limit of Quick Sort with arrays of various sizes
 * @author Sean Kan
 */
public class QuickSortBenchmark
{
    /**
     * Main function that captures Quick Sort's run time based on various array sizes and recursion limits
     * @param args
     */
    public static void main(String[] args)
    {
        int[] arraySize = {20000, 30000, 40000,50000,60000,70000,80000,90000,100000,200000,300000,400000
                ,500000,600000,700000,800000,900000,1000000,2000000,3000000};
        int recurLower = 2;
        int recurUpper= 300;
        int recurIncrement = 2;
        int quickSortIter=3;

        int randomInt;
        long averageTime, startTime, estimatedTime;

        //Outer loop - iterate through arrays with different sizes
        for (int i=0; i<arraySize.length; i++)
        {
            //Create array with random numbers;
            Integer[] arrayOfInts = new Integer[arraySize[i]];
            for (int ranIndex = 0; ranIndex < arraySize[i]; ranIndex++)
            {
                randomInt = (int) (Math.random() * Integer.MAX_VALUE);
                arrayOfInts[ranIndex] = randomInt;
            }

            //Middle loop - iterate through recursion limits
            for (int j=recurLower; j<=recurUpper; j+=recurIncrement)
            {
                FHSort.setRecursionLimit(j);
                averageTime=0;  //reset average

                //Inside loop - run quickSort() multiple times
                for (int k=0; k<quickSortIter;k++)
                {
                    Integer[] unsortedArray = arrayOfInts.clone(); //Create unsorted version of the array;

                    startTime = System.nanoTime();  // ------------------ start
                    FHSort.quickSort(unsortedArray);
                    estimatedTime = System.nanoTime() - startTime; // ------------------ stop
                    averageTime=averageTime+estimatedTime;  //append the estimated time
                }
                averageTime=averageTime/3; //divide to get the average
                System.out.println(arraySize[i]+","+j+","+averageTime);
            }
        }
    }
}