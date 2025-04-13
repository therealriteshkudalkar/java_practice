package problem91;

public class Problem91 {
    public String breakPalindrome(String palindrome) {
        // Char array approach
        char[] str = palindrome.toCharArray();
        int n = str.length;

        for (int i = 0; i < n / 2; i++) {
            if (str[i] != 'a') {
                str[i] = 'a';
                return String.valueOf(str);
            }
        }
        str[n - 1] = 'b';
        return n < 2 ? "" : String.valueOf(str);
    }
}
