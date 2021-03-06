/**
 * Implementation of Quick Sort
 */
public class FHSort
{
    /**
     * Takes the array, left and right as arguments and returns the pivot, which is also our median
     * @param a  An array
     * @param left  Left index
     * @param right  Right index
     * @param <E>  Generic object
     * @return The pivot
     */
    // median3 sorts a[left], a[center] and a[right].
    // it leaves the smallest in a[left], the largest in a[right]
    // and median (the pivot) is moved "out-of-the-way" in a[right-1].
    // (a[center] has what used to be in a[right-1])
    protected static < E extends Comparable< ? super E > >
    E median3(E[] a, int left, int right)
    {
        int center;
        E tmp;

        // swaps are done in-line for speed;  each compound line is a swap
        center = (left + right) / 2;
        if(a[center].compareTo(a[left]) < 0)
        { tmp = a[center]; a[center] = a[left]; a[left] = tmp; }
        if(a[right].compareTo(a[left]) < 0)
        { tmp = a[right]; a[right] = a[left]; a[left] = tmp; }
        if(a[right].compareTo(a[center]) < 0)
        { tmp = a[right]; a[right] = a[center]; a[center] = tmp; }

        tmp = a[center]; a[center] = a[right-1]; a[right-1] = tmp;

        return a[right - 1];
    }

    protected static int QS_RECURSION_LIMIT = 15;

    /**
     * Changes the recursion limit
     * @param newLim  New recursion limit
     * @return  Boolean that indicates whether the change was successful
     */
    public static boolean setRecursionLimit(int newLim)
    {
        if (newLim < 2 || newLim > 1000)
            return false;
        QS_RECURSION_LIMIT = newLim;
        return true;
    }

    /**
     * Private quicksort helper that does the sorting with recursion
     * @param a   Array
     * @param left   Left Index
     * @param right   Rigt Index
     * @param <E>   Generic object
     */
    protected static < E extends Comparable< ? super E > >
    void quickSort(E[] a, int left, int right)
    {
        E pivot, tmp;
        int i, j;

        if( left + QS_RECURSION_LIMIT <= right )
        {
            pivot = median3(a, left, right);

            for(i = left, j = right - 1; ; )
            {
                while( a[++i].compareTo(pivot) < 0 )
                    ;
                while( pivot.compareTo(a[--j]) < 0)
                    ;
                if(i < j)
                { tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp; }

                else
                    break;
            }

            // restore pivot
            tmp = a[i]; a[i] = a[right - 1]; a[right - 1] = tmp;

            // recursive calls on smaller sub-groups
            quickSort(a, left, i - 1);
            quickSort(a, i + 1, right);
        }
        else
            // non-recursive escape valve - insertion sort
            insertionSort(a, left, right);
    }

    /**
     * Private insertion sort that works on sub-arrays
     * @param a   Array
     * @param start  Start position
     * @param stop  End position
     * @param <E>   Generic object
     */
    // private insertion sort that works on sub-arrays --------------
    protected static < E extends Comparable< ? super E > >
    void insertionSort(E[] a, int start, int stop)
    {
        int k, pos;
        E tmp;

        // we are not testing for ranges to keep times down - private so ok
        for(pos = start + 1; pos <= stop; pos++ )
        {
            tmp = a[pos];
            for(k = pos; k > 0 && tmp.compareTo(a[k-1]) < 0; k-- )
                a[k] = a[k-1];
            a[k] = tmp;
        }
    }

    /**
     * Quicksort that is used by client
     * @param a   Array
     * @param <E>   Generic object
     */
    // public quicksort
    public static < E extends Comparable< ? super E > >
    void quickSort( E[] a )
    {
        quickSort(a, 0, a.length - 1);
    }
}