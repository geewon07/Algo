#include <iostream>
#include <algorithm>
#include <queue>
#define MAX_N 1005
#define MAX_M 1005
using namespace std;
int n, m;
int map[MAX_N][MAX_M];
bool visited[MAX_N][MAX_M];
int shortest[MAX_N][MAX_M];
int dr[4] = { -1,0,1,0 };
int dc[4] = { 0,1,0,-1 };
int ans = 0;
queue<pair<pair<int, int>, int>> q;
//안 익은 애들만 골라서 
void bfs() {
	while (!q.empty()) {
		int r = q.front().first.first;
		int c = q.front().first.second;
		int day = q.front().second;
		q.pop();
		for (int d = 0; d < 4; d++) {
			int nextr = r + dr[d];
			int nextc = c + dc[d];
			if (nextr>=0&&nextr<n&&nextc>=0&&nextc<m&&map[nextr][nextc]==0&&(!visited[nextr][nextc] || (shortest[nextr][nextc] > day + 1))) {
				visited[nextr][nextc] = true;
				shortest[nextr][nextc] = day + 1;
				q.push({ {nextr,nextc},shortest[nextr][nextc]});
			}
		}
	}
	return;
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	cin >> m >> n;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++) {
			cin >> map[i][j];
			if (map[i][j] == 1) {
				q.push({ {i,j},0 });
				visited[i][j] = true;
				shortest[i][j] = 0;
			}
		}
	bfs();
	//검증
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (map[i][j] == 0 && !visited[i][j]) {
				cout << -1; return 0;
			}
			else ans = max(ans, shortest[i][j]);
		}
	}
	cout << ans;
	return 0;
}