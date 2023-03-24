import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
public class Solution {
        static int N;
        static int[][] arr;
        static int[] dr = {-1, -1};
        static int[] dc = { 1, -1};
        static int result;
        static boolean[] visited;
        public static void main(String[] args) throws NumberFormatException, IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
            for(int tc=1;tc<=T;tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            for(int i=0;i<N;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            result = -1;
            for(int i=0;i<N-2;i++) {
                for(int j=1;j<N-1;j++) {
                    visited = new boolean[101];
                    visited[arr[i][j]] = true;
                    dfs(i,j,0,0,0);
                     
                }
            }
            System.out.println("#"+tc+" "+result);
            }
        }
         
        static void dfs(int i, int j,int idx, int count1, int count2) {
            int r1 = i;
            int c1 = j;
            if(idx == 2 && count1>0 && count2 >0) {
                List<Integer> list = new ArrayList<Integer>();
                int size = count1+1 + count2+1;
                int num1 = 1;
                int num2 = 1;
                int r = i;
                int c = j;
                while(num1 < count1) {
                    r = i + num1 *dr[0];
                    c = j + num1 *dc[0];
                    if(r<0 | r>=N | c<0 | c>=N) return;
                    if(visited[arr[r][c]]) return;
                    if(list.contains(arr[r][c])) return;
                    list.add(arr[r][c]);
                    size++;
                    num1++;
                }
                while(num2 < count2) {
                    int r3 = r + num2 * dr[1];
                    int c3 = c + num2 * dc[1];
                    if(r3<0 | r3>=N | c3<0 | c3>= N ) return;
                    if(visited[arr[r3][c3]]) return;
                    if(list.contains(arr[r3][c3])) return;
                    list.add(arr[r3][c3]);
                    size++;
                    num2++;
                }
                result = Math.max(result,size);
                     
            }
            if(idx == 0) {
                if(r1+1>=0 && r1 +1< N && c1 -1 >=0 && c1 -1 < N ) {
                    if(!(visited[arr[r1+1][c1 -1]])) {
                        visited[arr[r1+1][c1 -1]] = true;
                           dfs(r1+1,c1-1,0,count1+1,count2);
                          visited[arr[r1+1][c1 -1]] = false ;
                    }}
                if(r1+1>=0 && r1 +1< N && c1+1 >=0 && c1 +1 < N ) {
                    if(!(visited[arr[r1+1][c1+1]])) {
                        visited[arr[r1+1][c1 +1]] = true;
                           dfs(r1+1,c1+1,1,count1,count2+1);
                           visited[arr[r1+1][c1 +1]] = false;
                   }
            }}
            else if(idx == 1) {
                if(r1+1>=0 && r1 +1< N && c1+1 >=0 && c1 +1 < N) {
                    if(!(visited[arr[r1+1][c1 +1]])) {
                        visited[arr[r1+1][c1 +1]] = true;
                           dfs(r1+1,c1+1,1,count1,count2+1);
                           visited[arr[r1+1][c1 +1]] = false;
                    }
                   }
                if(r1-1>=0 && r1 -1< N && c1+1 >=0 && c1 +1 < N) {
                    if(!(visited[arr[r1-1][c1 +1]])) {
                        visited[arr[r1-1][c1 +1]] = true;
                           dfs(r1-1,c1+1,2,count1,count2);
                           visited[arr[r1-1][c1 +1]] = false;
                    }
                }
            }
        }
    }