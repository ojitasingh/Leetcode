class Solution {
  public boolean detectCapitalUse(String word) {
    return word.equals(word.toUpperCase()) ||
        word.substring(1).toLowerCase());
  }
}