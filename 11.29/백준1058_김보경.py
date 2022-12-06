import sys
from collections import deque

n = int(sys.stdin.readline())
graph = [list(map(str, sys.stdin.readline().strip())) for _ in range(n)]

def bfs(v):
    visited = [False] * n
    queue = deque([[v, 0]]) # 사람의 번호와 친구와의 관계
    visited[v] = True
    cnt = 0
    while queue:

        a, b = queue.popleft()

        # 친구와의 관계가 2이상이면 계산 ㄴㄴ
        if b >= 2:
            continue

        # 반복문을 통해 탐색하지 않은 사람이고 그 사람이 친구가 있는지 확인
        for i in range(n):
            if not visited[i] and graph[a][i] == "Y":
                cnt += 1
                visited[i] = True
                queue.append([i, b + 1])

    return cnt

res = 0
# 각 사람마다 친구의 2-친구의 수를 구하고 제일 유명한 사람을 출력한다.
for i in range(n):
    res = max(res, bfs(i))

print(res)