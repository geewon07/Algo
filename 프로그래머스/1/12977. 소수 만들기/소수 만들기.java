class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int value = 0;
        boolean[] visit = new boolean[nums.length];
        
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                for(int k=j+1;k<nums.length;k++) {
                    value = nums[i] + nums[j] + nums[k];
                    if(setPrime(value)) answer++;
                }
            }
        }
    

        return answer;
    }
    
    public boolean setPrime(int value) {
        boolean prime = true;
        for(int i=2;i*i<=value;i++) {
            if(value % i == 0) {
                prime = false;
                break;
            }
        }
        return prime;
    }
}