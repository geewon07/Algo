#include <iostream>
#include <algorithm>
#include <queue>
#define MAX_N 51
#define MAX_M 51
using namespace std;
int n, m;
int startr, startc;
bool visited[MAX_N][MAX_M][33];
int ans = 1e8;
char map[MAX_N][MAX_M];
int dr[4] = { -1,0,1,0 };
int dc[4] = { 0,1,0,-1 };
int collected[MAX_N][MAX_M];
void bfs(int i,int j) {
	queue < pair<pair<int, int>, pair<int, int>>> q;
	q.push({ {0,0},{i,j} });
	while (!q.empty()) {
		int cnt = q.front().first.first;
		int keys = q.front().first.second;
		int r = q.front().second.first;
		int c = q.front().second.second;
		q.pop();
		for (int d = 0; d < 4; d++) {
			if (cnt > ans)return;
			int nextr = r + dr[d];
			int nextc = c + dc[d];
			if (nextr >= 0 && nextr < n && nextc >= 0 && nextc < m && (!visited[nextr][nextc][keys])) {
				if (map[nextr][nextc] == '1') {
					ans = min(ans, cnt + 1);
				}
				else if (map[nextr][nextc] == '#')continue;
				else if (map[nextr][nextc] >= 'a' && map[nextr][nextc] <= 'f') {
					int temp = keys|(1<<map[nextr][nextc]-'a');
					visited[nextr][nextc][temp] = true;
					q.push({ {cnt + 1,temp},{nextr,nextc} });
				}
				else if (map[nextr][nextc] >= 'A' && map[nextr][nextc] <= 'F') {
					int temp = keys & (1 << (map[nextr][nextc] - 'A'));
					if (temp>0) {
						visited[nextr][nextc][keys] = true;
						q.push({ {cnt + 1,keys},{nextr,nextc} });
					}
				}
				else {
					visited[nextr][nextc][keys] = true;
					q.push({ {cnt + 1,keys},{nextr,nextc} });
				}
			}
		}
	}
	
	return;
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	cin >> n >> m;
	for (int i = 0; i < n; i++)cin >> map[i];
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (map[i][j] == '0') {
				startr = i; startc = j;
				map[i][j] = '.';
				break;
			}
		}
	}
	bfs(startr,startc);
	if (ans == 1e8)cout << -1;
	else cout << ans;
	return 0;
}