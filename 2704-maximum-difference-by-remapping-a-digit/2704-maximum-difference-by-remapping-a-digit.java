class Solution {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        char digitToReplaceWith9 = getFirstNonNineDigit(s);
        char digitToReplaceWith0 = s.charAt(0);

        int maxNum = replaceDigit(s, digitToReplaceWith9, '9');
        int minNum = replaceDigit(s, digitToReplaceWith0, '0');

        return maxNum - minNum;
    }

    private char getFirstNonNineDigit(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '9') {
                return s.charAt(i);
            }
        }
        return '9';
    }

    private int replaceDigit(String s, char fromDigit, char toDigit) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == fromDigit) {
                sb.append(toDigit);
            } else {
                sb.append(c);
            }
        }
        return Integer.parseInt(sb.toString());
    }
};
