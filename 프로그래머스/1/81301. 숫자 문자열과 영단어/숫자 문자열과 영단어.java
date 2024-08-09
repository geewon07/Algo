class Solution {
    public int solution(String s) {
        String[] count = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i=0;i<count.length;i++) {
            s = s.replaceAll(count[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}