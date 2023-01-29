#include<iostream>
#include<algorithm>
using namespace std;

int N, K;
int a, b;
int seg[(1<<18)];

// 세그먼트트리 초기화
int init(int node, int s, int e) // (루트노드, 시작, 끝)
{
    if (s == e) return seg[node] = 1; // start 와 end 의 위치가 일치하면 1을 넣어준다.
    int mid = (s + e) / 2;
    return seg[node] = init(2 * node, s, mid) + init(2 * node + 1, mid + 1, e);
}

// 세그먼트트리 정보 수정
int update(int node, int s, int e, int del) // (루트노드, 시작, 끝, 제거번호)
{
    seg[node]--;
    if (s == e) return 0;
    else
    {
        int mid = (s + e) / 2;
        if (del <= mid) return update(2 * node, s, mid, del);
        else return update(2 * node + 1, mid + 1, e, del);
    }
}

// 다음 순서에 해당하는 번호 받아오기
int query(int node, int s, int e, int order) // (현재노드, 시작, 끝, 순서)
{
    if (s == e) return s; // start 와 end 의 위치가 일치하면 번호를 반환한다.
    int mid = (s + e) / 2;

    if (order <= seg[2 * node]) return query(2 * node, s, mid, order);
    else return query(2 * node + 1, mid + 1, e, order - seg[2 * node]);

}


int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie();

    cin >> N >> K;

    init(1, 1, N); // (루트노드, 시작, 끝)

    int index = 1;

    cout << "<";

    for (int i = 0; i < N; i++)
    {
        // 다음 순서 구하기
        int size = N - i; // 사람 수
        index += K - 1;

        if (index % size == 0) index = size;
        else if (index > size) index %= size;
            

        // 다음 순서에 해당하는 번호 받아오기
        int num = query(1, 1, N, index);

        // 해당 번호 제거 하기
        update(1, 1, N, num);
          
        if (i == N - 1) cout << num;
        else cout << num << ", ";
    }
    cout << ">";
}