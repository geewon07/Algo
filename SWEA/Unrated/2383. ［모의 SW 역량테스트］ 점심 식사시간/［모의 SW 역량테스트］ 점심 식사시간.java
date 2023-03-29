import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
public class Solution {
    static int N,result;
    static int[][] arr;
    static List<int[]> person;
    static List<int[]> stair;
    static int[] sel;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            stair = new ArrayList<>();
            person = new ArrayList<int[]>();
            
            for(int i=0;i<N;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(arr[i][j] == 1) {
                        person.add(new int[] {i, j});
                    }
                    if(arr[i][j] > 1) {
                        stair.add(new int[] {i,j,arr[i][j]});
                    }
                }
            }
            // 사람의 수만큼 배열크기 설정 -> 해당 사람에 선택되는 계단의 종류
            sel = new int[person.size()];
            result = Integer.MAX_VALUE;
            lunch(0);
            System.out.println("#"+tc+" "+result);
            
            }
        // 제한 : 계단 위에는 3명까지만 가능, 시간 count : 계단까지의 거리 + 계단을 내려가는 거리
        // 모든 사람이 계단을 선택해야함! 2^10까지 가능함 사람1이 1번계단 or 2번계단을 선택
        // 모든 조합의 경우의 수 생각
        // idx가 끝나면 값 계산하기
        // 우선순위 큐
    }
    static void lunch(int idx) {
        if(idx == person.size()) {
        	int time = 0;
        	PriorityQueue<Integer> q1 = new PriorityQueue<>(); // 1번째 계단
        	PriorityQueue<Integer> q2 = new PriorityQueue<>(); // 2번째 계단
        	int q1time = stair.get(0)[2];
        	int q2time = stair.get(1)[2];
        	
        	for(int i=0;i<person.size();i++) {
        		int num = Math.abs(person.get(i)[0]-stair.get(sel[i])[0]) + Math.abs(person.get(i)[1]-stair.get(sel[i])[1]);
        		if(sel[i] == 0) {
        			q1.add(num);
        		}else q2.add(num);
         	}
        	int time1 = 0;
        	int time2 = 0;
        	
        	if(q1.size()<=3) {
        		while(!q1.isEmpty()) {
        			time1 = q1.poll() + q1time +1;
        		}
        	} else {
        		Queue<Integer> q = new LinkedList<>();
        		for(int i=0;i<3;i++) {
        			int num = q1.poll();
        			q.add(num + q1time+1);
        		}
        		while(!q1.isEmpty()) {
        			int first = q.poll();
        			int next = q1.poll();
        			if(first <= next) {
        				q.add(next + q1time +1);
        			} else {
        				q.add(next+(first-next)+q1time);
        			}
        		}
        		
        		while(!q.isEmpty()) {
        			time1 = q.poll();
        		}
        		
        	}
        	if(time1 > result ) return;
        	
        	if(q2.size()<=3) {
        		while(!q2.isEmpty()) {
        			time2 = q2.poll() + q2time+1;
        		}
        	} else {
        		Queue<Integer> q = new LinkedList<>();
    		for(int i=0;i<3;i++) {
    			int num = q2.poll();
    			q.add(num + q2time+1);
    		}
    		while(!q2.isEmpty()) {
    			int first = q.poll();
    			int next = q2.poll();
    			if(first <= next) {
    				q.add(next + q2time +1);
    			} else {
    				q.add(next+(first-next)+q2time);
    			}
    		}
    		
    		while(!q.isEmpty()) {
    			time2 = q.poll();
    		}
    		
    		if(time2 > result ) return;
    	}
        time = Math.max(time1, time2);
        if(time < result ) result = time;
        return;
        }
        
        
        sel[idx] = 0;
        lunch(idx+1);
        
        sel[idx] = 1;
        lunch(idx+1);
    }
    
    
    }