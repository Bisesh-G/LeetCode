import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {

        HashMap<Integer, Integer> countMap = new HashMap<>();

        // Count frequency of each number
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        HashSet<Integer> occurrences = new HashSet<>();

        // Check if any frequency repeats
        for (int freq : countMap.values()) {
            if (occurrences.contains(freq)) {
                return false;
            }
            occurrences.add(freq);
        }

        return true;
    }
}