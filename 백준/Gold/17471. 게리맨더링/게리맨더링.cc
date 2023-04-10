#include <iostream>
#include <queue>
#include <cstring>
#include <cstdlib>
#define MAX_N 15
using namespace std;
int ans = 99999999,n,sum=0;
int team[MAX_N];
int visited[MAX_N];
int p[MAX_N];
int adj[MAX_N][MAX_N];
bool connected();
void comb(int depth, int index, int cnt) {
	if (depth > n / 2)return;
	if (depth >= 1) {
		if (connected()) {
			int a = cnt;
			int b = sum - a;
			if (abs(a - b) < ans)ans = abs(a - b);
		}
	}
	for (int i = index; i < n; i++) {
		if (team[i])continue;
		team[i] = true;
		comb(depth + 1,i + 1,cnt+p[i]);
		team[i] = false;
	}

}
bool connected() {
	queue<int> q;
	bool flag = false;
	int a=0,b=0,cnt=0;
	for (int i = 0; i < n; i++) {
		if (team[i])a++;
		else b++;
	}
	memset(visited, 0, sizeof(visited));
	for (int i = 0; i < n; i++) {
		if (team[i]) {
			cnt++;
			visited[i] = true;
			q.push(i);
			break;
		}
	}
	while (!q.empty()) {
		if (a == cnt) {
			flag = true;
			break;
		}
		int now = q.front();
		q.pop();
		for (int i = 0; i < n; i++) {
			if (now == i)continue;
			if (adj[now][i] && team[i] && !visited[i]) {
				q.push(i);
				visited[i] = true;
				cnt++;
			}
		}
	}
	if (!flag) return flag;
	flag = false;
	memset(visited, 0, sizeof(visited));
	cnt = 0;
	q = queue<int>();
	for (int i = 0; i <n; i++) {
		if (!team[i]) {
			q.push(i);
			visited[i] = true;
			cnt++;
			break;
		}
	}
	while (!q.empty()) {
		if (b == cnt) {
			flag = true;
			break;
		}
		int now = q.front();
		q.pop();
		for (int i = 0; i < n; i++) {
			if (now == i)continue;
			if (adj[now][i] && !team[i] && !visited[i]) {
				visited[i] = true;
				q.push(i);
				cnt++;
			}
		}
	}
	return flag;
}


int main() {
	int temp,node;
	memset(team, 0, sizeof(team));
	memset(adj, 0, sizeof(adj));
	cin >> n;
	for (int i = 0; i < n; i++) { 
		cin >> p[i];
		sum += p[i];
	}
	for (int i = 0; i < n; i++) {
		cin >> temp;
		for (int j = 0; j < temp; j++) {
			cin >> node;
			adj[i][node - 1] = adj[node - 1][i] = 1;
		}
	}
	comb(0, 0, 0);
	if (ans == 99999999)ans = -1;
	cout << ans;
	return 0;
}