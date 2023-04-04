#include <iostream>
#include <queue>
#include <cstring>
#include <algorithm>
#define MAX_H 201
#define MAX_W 201
using namespace std;
int dr[4] = { -1,0,1,0 };
int dc[4] = { 0,1,0,-1 };
int k,w,h,ans=-1;
int map[MAX_H][MAX_W];
int shortest[MAX_H][MAX_W];
int sum[MAX_H][MAX_W];
void bfs() {
	queue<pair<pair<int,int>, pair<int, int>>> q;
	shortest[0][0] = 0;
	q.push({ {0,0},{0,0} });
	while (!q.empty()) {
		int r = q.front().second.first;
		int c = q.front().second.second;
		int cnt = q.front().first.first;
		int dist = q.front().first.second;
		q.pop();
		//말처럼 이동
		if (cnt < k) {
			for (int d = 0; d < 4; d++) {
				int nextr, nextc;
				if (d % 2 == 0) {
					nextr = r + 2*dr[d] + dr[1];
					nextc = c + 2*dc[d] + dc[1];
					if (nextr == h - 1 && nextc == w - 1) {
						if (ans == -1)ans = dist + 1;
						else ans = min(ans, dist + 1);
					}
					if (nextr >= 0 && nextr < h && nextc >= 0 && nextc < w &&map[nextr][nextc]==0&& (shortest[nextr][nextc] == -1 || shortest[nextr][nextc] > shortest[r][c] + 1||sum[nextr][nextc]>cnt+1)) {
						shortest[nextr][nextc] = shortest[r][c] + 1;
						sum[nextr][nextc] = cnt + 1;
						q.push({ {cnt + 1,shortest[nextr][nextc]},{nextr,nextc} });
					}
					nextr = r + 2*dr[d] + dr[3];
					nextc = c + 2*dc[d] + dc[3];
					if (nextr == h - 1 && nextc == w - 1) {
						if (ans == -1)ans = dist + 1;
						else ans = min(ans, dist + 1);
					}
					if (nextr >= 0 && nextr < h && nextc >= 0 && nextc < w && map[nextr][nextc] == 0 && (shortest[nextr][nextc] == -1 || shortest[nextr][nextc] > shortest[r][c] + 1 || sum[nextr][nextc] > cnt + 1)) {
						shortest[nextr][nextc] = shortest[r][c] + 1;
						sum[nextr][nextc] = cnt + 1;
						q.push({ {cnt + 1,shortest[nextr][nextc]},{nextr,nextc} });
					}
				}
				else {
					nextr = r + 2*dr[d] + dr[0];
					nextc = c + 2*dc[d] + dc[0];
					if (nextr == h - 1 && nextc == w - 1) {
						if (ans == -1)ans = dist + 1;
						else ans = min(ans, dist + 1);
					}
					if (nextr >= 0 && nextr < h && nextc >= 0 && nextc < w && map[nextr][nextc] == 0 && (shortest[nextr][nextc] == -1 || shortest[nextr][nextc] > shortest[r][c] + 1 || sum[nextr][nextc] > cnt + 1)) {
						shortest[nextr][nextc] = shortest[r][c] + 1;
						sum[nextr][nextc] = cnt + 1;
						q.push({ {cnt + 1,shortest[nextr][nextc]},{nextr,nextc} });
					}
					nextr = r + 2*dr[d] + dr[2];
					nextc = c + 2*dc[d] + dc[2];
					if (nextr == h - 1 && nextc == w - 1) {
						if (ans == -1)ans = dist + 1;
						else ans = min(ans, dist + 1);
					}
					if (nextr >= 0 && nextr < h && nextc >= 0 && nextc < w && map[nextr][nextc] == 0 && (shortest[nextr][nextc] == -1 || shortest[nextr][nextc] > shortest[r][c] + 1 || sum[nextr][nextc] > cnt + 1)) {
						shortest[nextr][nextc] = shortest[r][c] + 1;
						sum[nextr][nextc] = cnt + 1;
						q.push({ {cnt + 1,shortest[nextr][nextc]},{nextr,nextc} });
					}
				}
			}
		}
		//인접 이동
		for (int d = 0; d < 4; d++) {
			int nextr = r + dr[d];
			int nextc = c + dc[d];
			if (nextr == h - 1 && nextc == w - 1) {
				if (ans == -1)ans = dist + 1;
				else ans = min(ans, dist + 1);
			}
			if (nextr >= 0 && nextr < h && nextc >= 0 && nextc < w && map[nextr][nextc] == 0 && (shortest[nextr][nextc] == -1 || shortest[nextr][nextc] > shortest[r][c] + 1 || sum[nextr][nextc] > cnt)) {
				shortest[nextr][nextc] = shortest[r][c] + 1;
				sum[nextr][nextc] = cnt;
				q.push({ {cnt,shortest[nextr][nextc]},{nextr,nextc} });
			}
		}
	}
	return;
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	cin >> k>>w>>h;
	if (w == 1 && h == 1) {
		cout << 0; return 0;
	}
	for (int i = 0; i < h; i++) {
		for (int j = 0; j < w; j++) {
			cin >> map[i][j];
		}
	}
	memset(shortest, -1, sizeof(shortest));
	bfs();
	cout <<ans;
	return 0;
}