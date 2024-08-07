public class Solution {
    public int kthElement(int k, int[] array1, int[] array2) {
        int index1 = 0, index2 = 0, mergedIndex = 0;
        int currentElement = 0;
        int length1 = array1.length;
        int length2 = array2.length;

        // Traverse both arrays and merge elements until we reach the k-th position
        while (index1 < length1 && index2 < length2) {
            if (mergedIndex == k) {
                return currentElement;
            }

            if (array1[index1] < array2[index2]) {
                currentElement = array1[index1];
                index1++;
            } else {
                currentElement = array2[index2];
                index2++;
            }

            mergedIndex++;
        }

        // If there are remaining elements in array1
        while (index1 < length1) {
            if (mergedIndex == k) {
                return currentElement;
            }

            currentElement = array1[index1];
            index1++;
            mergedIndex++;
        }

        // If there are remaining elements in array2
        while (index2 < length2) {
            if (mergedIndex == k) {
                return currentElement;
            }

            currentElement = array2[index2];
            index2++;
            mergedIndex++;
        }

        return currentElement;
    }
}