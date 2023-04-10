#include <iostream>
#include <algorithm>
#define MAX_N 1005
#define MAX_M 1005
using namespace std;
int candy[MAX_N][MAX_N];
int dp[MAX_N][MAX_M];
int dr[3] = { 1,1,0 };
int dc[3] = { 0,1,1 };
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n, m;
	cin >> n >> m;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			cin >> candy[i][j];
	dp[0][0] = candy[0][0];
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			for (int d = 0; d < 3; d++) {
				int nextr = i + dr[d];
				int nextc = j + dc[d];
				dp[nextr][nextc] = max(dp[nextr][nextc], dp[i][j] + candy[nextr][nextc]);
			}
		}
	}
	cout << dp[n - 1][m - 1];
	return 0;
}