import java.util.Arrays;

public class Mergesort {
    private static final int START_POSITION = 0;

    public static int[] mergeSortAlgorithm(int[] listToSort) {
        if (listToSort.length <= 1) {
            return listToSort;
        }

        int halfSize = listToSort.length / 2;
        int[] halfLeft = Arrays.copyOfRange(
                listToSort,
                START_POSITION,
                halfSize);
        int[] halfRight = Arrays.copyOfRange(
                listToSort,
                halfSize,
                listToSort.length
        );

        halfLeft = mergeSortAlgorithm(halfLeft);
        halfRight = mergeSortAlgorithm(halfRight);

        int[] sortedList = merge(halfLeft, halfRight);
        return sortedList;
    }

    private static int[] merge(int[] halfLeft, int[] halfRight) {
        if (halfLeft.length == 0) {
            return halfRight;
        }
        if (halfRight.length == 0) {
            return halfLeft;
        }

        int[] current = {};
        int[] mergedList = new int[halfLeft.length + halfRight.length];

        if (halfLeft[START_POSITION] <= halfRight[START_POSITION]) {
            mergedList[START_POSITION] = halfLeft[START_POSITION];
            int[] left = Arrays.copyOfRange(
                    halfLeft,
                    START_POSITION + 1,
                    halfLeft.length
            );
            current = merge(left, halfRight);

        } else {
            mergedList[START_POSITION] = halfRight[START_POSITION];
            int[] right = Arrays.copyOfRange(
                    halfRight,
                    START_POSITION + 1,
                    halfRight.length
            );
            current = merge(halfLeft, right);
        }

        System.arraycopy(
                current,
                START_POSITION,
                mergedList,
                START_POSITION + 1,
                current.length
        );

        return mergedList;
    }
}
