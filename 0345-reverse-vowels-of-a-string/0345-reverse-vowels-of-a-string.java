class Solution {

    static boolean vowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }

    public String reverseVowels(String s) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (vowel(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }
        sb.reverse();

        char[] arr = s.toCharArray();
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (vowel(arr[i])) {
                arr[i] = sb.charAt(j++);
            }
        }

        return new String(arr);
    }
}