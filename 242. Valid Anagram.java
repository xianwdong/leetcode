// Given two strings s and t, write a function to determine if t is an anagram of s.
// For example,
// s = "anagram", t = "nagaram", return true.
// s = "rat", t = "car", return false.

public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    int[] times = new int[256];
    for (int i = 0; i < s.length(); ++i) {
        ++times[s.charAt(i)];
        --times[t.charAt(i)];
    }
    for (int i = 0; i < times.length; ++i) {
        if (times[i] != 0) {
            return false;
        }
    }
    return true;
}
