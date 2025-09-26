import java.util.ArrayList;
import java.util.List;

public class RemovableIndices {
    public static List<Integer> findRemovalIndices(String str1, String str2) {
        int n = str1.length();
        List<Integer> result = new ArrayList<>();
        
        // Precompute the longest common prefix length at each index
        // prefixMatch[i] = true if the first i characters of str1 and str2 match
        boolean[] prefixMatch = new boolean[n + 1];
        prefixMatch[0] = true; // Empty prefix always matches
        for (int i = 0; i < n; i++) {
            if (i < str2.length() && str1.charAt(i) == str2.charAt(i) && prefixMatch[i]) {
                prefixMatch[i + 1] = true;
            } else {
                prefixMatch[i + 1] = false;
            }
        }
        
        // Precompute the longest common suffix length from each index
        // suffixMatch[i] = true if the substring from index i to the end matches
        boolean[] suffixMatch = new boolean[n + 1];
        suffixMatch[n] = true; // Empty suffix always matches
        for (int i = n - 1; i >= 0; i--) {
            int str2Index = i - 1; // Because we remove one character, the indices shift
            if (str2Index >= 0 && str2Index < str2.length() && 
                str1.charAt(i) == str2.charAt(str2Index) && suffixMatch[i + 1]) {
                suffixMatch[i] = true;
            } else {
                suffixMatch[i] = false;
            }
        }
        
        // Check for each candidate index k
        for (int k = 0; k < n; k++) {
            if (prefixMatch[k] && suffixMatch[k + 1]) {
                result.add(k);
            }
        }
        
        if (result.isEmpty()) {
            result.add(-1);
        }
        return result;
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Test cases
        System.out.println(findRemovalIndices("abcd", "acd"));  // [1]
        System.out.println(findRemovalIndices("extra", "etra")); // [2]
        System.out.println(findRemovalIndices("a", ""));        // [0]
        System.out.println(findRemovalIndices("aab", "ab"));    // [0, 1]
        System.out.println(findRemovalIndices("abc", "def"));   // [-1]
    }
}