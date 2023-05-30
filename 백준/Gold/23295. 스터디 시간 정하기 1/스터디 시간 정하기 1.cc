#include <iostream>
#include <algorithm>

using namespace std;
typedef long long LL;
LL arr[200000];
LL cnt[200000];
LL sum[200000];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL), cout.tie(NULL);

    int n, m;
    cin >> n >> m;

    LL tc, fr, to, max_time = 0;
    for (int i = 0; i < n; i++) {
        cin >> tc;
        for (int j = 0; j < tc; j++) {
            cin >> fr >> to;
            arr[fr] += 1;
            arr[to] -= 1;
            max_time = max(max_time, to);
        }
    }
    cnt[0] = arr[0];
    sum[0] = arr[0];
    for (int i = 1; i <= max_time; i++) {
        cnt[i] = cnt[i - 1] + arr[i];
        sum[i] = sum[i - 1] + cnt[i];
    }

    LL max_cnt = 0, clo = 0;
    for (LL lo = 0; lo <= max_time; lo++) {
        LL calc;
        if (lo == 0) {
            calc = sum[lo + m] - cnt[lo + m];
        }
        else {
            calc = sum[lo + m] - sum[lo - 1] - cnt[lo+m];
        }
        if (calc > max_cnt) {
            max_cnt = calc;
            clo = lo;
        }
    }
    cout << clo << " " << clo + m;
}