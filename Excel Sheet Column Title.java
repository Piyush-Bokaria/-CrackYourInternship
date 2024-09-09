//Day 45 of #CrackYourInternship
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        while(columnNumber > 0){
            int index = (columnNumber - 1) % 26;
            result.insert(0, (char) ('A' + index));
            columnNumber = (columnNumber - 1) / 26;
        }
        return result.toString();
    }
}
