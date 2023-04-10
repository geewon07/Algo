#include <iostream>
#define MIN(x,y) (x<=y?x:y)
using namespace std;
int cost[1001][3];
int table[1001][3] = { 0, };
int main() {
	ios::sync_with_stdio(false);cin.tie(NULL);
	int n,temp;
	cin >> n;
	for (int i = 0;i < n;i++) {
		for (int j = 0;j < 3;j++) {
			cin >> temp;
			cost[i][j] = temp;
		}
	}
	for (int j = 0;j < 3;j++)table[0][j] = cost[0][j];
	for (int i = 1;i < n;i++) {
		for (int j = 0;j < 3;j++) {
			if (j == 0)table[i][j] = cost[i][j]+MIN(table[i - 1][1], table[i - 1][2]);
			if (j == 1)table[i][j] = cost[i][j] + MIN(table[i - 1][0], table[i - 1][2]);
			if (j == 2)table[i][j] = cost[i][j] + MIN(table[i - 1][0], table[i - 1][1]);
		}
	}
	cout << MIN(MIN(table[n - 1][0], table[n - 1][1]), table[n - 1][2]);
	return 0;
}