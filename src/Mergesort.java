import java.util.Arrays;

public class Mergesort {

    public static int[] mergeSortAlgorithm(int[] listToSort) {
        if (listToSort.length <= 1) {
            return listToSort;
        }

        int halfSize = listToSort.length / 2;
        int[] halfLeft = Arrays.copyOfRange(
                listToSort,
                0,
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
        int[] mergedList = new int[halfLeft.length + halfRight.length];

        mergedList = merge(mergedList, halfLeft, halfRight, 0);
        return mergedList;
    }

    private static int[] merge(
            int[] mergedList,
            int[] halfLeft,
            int[] halfRight,
            int posMerged
    ) {
        if (halfLeft.length == 0) {
            return halfRight;
        }
        if (halfRight.length == 0) {
            return halfLeft;
        }

        int[] current = {};

        if (halfLeft[0] <= halfRight[0]) {
            mergedList[posMerged] = halfLeft[0];
            int[] left = Arrays.copyOfRange(halfLeft, 1, halfLeft.length);
            current = merge(mergedList, left, halfRight, posMerged + 1);

        } else {
            mergedList[posMerged] = halfRight[0];
            int[] right = Arrays.copyOfRange(halfRight, 1, halfRight.length);
            current = merge(mergedList, halfLeft, right, posMerged + 1);
        }

        if (current.length == mergedList.length) {
            mergedList[posMerged] = current[posMerged];
        } else {
            mergedList[posMerged + 1] = current[0];
        }

        return mergedList;
    }
}
