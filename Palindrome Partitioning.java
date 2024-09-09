//Day 45 of #CrackYourInternship
class Solution {
    List<List<String>> result;

    private boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private void helper(String s, int start, List<String> curr) {
        if (start == s.length()) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String substring = s.substring(start, i + 1);
            if (isPalindrome(substring)) {
                curr.add(substring);
                helper(s, i + 1, curr); 
                curr.remove(curr.size() - 1); 
            }
        }
    }

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
    }
}
