#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <queue>

using namespace std;

#define pii pair<int, int>

int n, d;
vector<pair<int, int>> input;
vector<pii> inputQ;
priority_queue<int, vector<int>, greater<int>> pq;

bool compare(const pair<int, int>& a, const pair<int, int>& b) {
	if (a.second != b.second) {
		return a.second < b.second;
	}
	else if (a.second == b.second) {
		return a.first < b.first;
	}
}

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n;
	for (int i = 0; i < n; i++) {
		int h, o;
		cin >> h >> o;
		if (h > o)inputQ.push_back({ o,h });
		else inputQ.push_back({ h,o });
	}
	cin >> d;

	// 끝 점 o를 기준으로 (h, o) pair를 오름차순 정렬
	sort(inputQ.begin(), inputQ.end(), compare);

	int maxSize = 0;

	// 정렬된 모든 쌍을 차례대로 살펴본다.
	for(int i = 0; i<inputQ.size(); i++){
		int iR = inputQ[i].second;
		int iL = inputQ[i].first;

		// iR-iL 사이즈, 즉 사람의 길이가 d보다 작으면
        // 일단 선분 L 안에 들어올 수 있는 후보니까 그 시작점을 우선순위 큐에 넣는다.
		if (iR - iL <= d) {
			pq.push(iL);
		}
		else continue;

		while (!pq.empty()) {
			// 가능한 왼쪽 시작점 후보들이 있는 pq 에서 하나를 뽑아서
			// 현재 살펴보고 있는 i번째 사람의 오른쪽 끝값과의 거리를 계산하고
			// 그 거리가 d 이하이면 나가서 다른 인풋을 계속 보며,
			// d 보다 큰 거리이면 후보에서 빼버린다. (pop)
			int tmp = pq.top();
			if (iR - tmp <= d) break;
			else 
				pq.pop();		
		}
		maxSize = max(maxSize, (int)pq.size());
	}

	cout << maxSize;
	return 0;
}