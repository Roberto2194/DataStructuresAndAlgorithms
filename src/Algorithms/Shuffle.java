package Algorithms;

import static Algorithms.Sorting.Sortable.swap;

/**
 *  The {@code Shuffle} class provides a client for reading in a
 *  sequence of strings and <em>shuffling</em> them using the Shuffle (or Fisher-Yates)
 *  shuffling algorithm. This algorithm guarantees to rearrange the
 *  elements in uniformly random order, under
 *  the assumption that Math.random() generates independent and
 *  uniformly distributed numbers between 0 and 1.
 */
public class Shuffle {

    // this class should not be instantiated
    private Shuffle() { }

    /**
     * Rearranges an array of objects in uniformly random order
     * (under the assumption that {@code Math.random()} generates independent
     * and uniformly distributed numbers between 0 and 1).
     * @param a the array to be shuffled
     */
    public static void random(Object[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            // choose index uniformly in [0, i]
            int r = (int) (Math.random() * (i + 1));
            swap(a, r, i);
        }
    }

    /**
     * Unit test the {@code Shuffle} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Integer[] a = {2, 23, 12, 17, 11, 9, 77, 45, 62, 22};

        // shuffle the array
        Shuffle.random(a);

        // print results.
        for (Integer integer : a) System.out.print(integer + " ");
    }
}

