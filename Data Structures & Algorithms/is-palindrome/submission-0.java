class Solution {
    public boolean isPalindrome(String s) {
        // remove spaces and punctuation
        String s2 = s.replaceAll("[^a-zA-Z0-9]", "");

        // change string to lower case
        String s3 = s2.toLowerCase();

        // List<Char>[] list = new ArrayList<>();
        // list = s.toCharArray();// ?

        // loop through the char in the string and compare in place with two pointers
        int left = 0;
        int right = s3.length() - 1;
        
        while (left < right) {
            if (s3.charAt(left) != s3.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
