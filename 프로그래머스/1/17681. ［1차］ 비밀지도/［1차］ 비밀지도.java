class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0;i<n;i++) {
            answer[i] = convertToBinary(arr1[i]|arr2[i],n);
        }
        return answer;
    }
    
    public String convertToBinary(int value, int n) {
        StringBuilder result = new StringBuilder();
        while(value != 0) {
            if(value % 2 == 0) result.append(" ");
            else result.append("#");
            value = value/2;
        }
        int size = result.length();
        if(size < n) {
            for(int i=0;i<n-size;i++) {
                result.append(" ");
            }
        }
        return result.reverse().toString();
    }
}
