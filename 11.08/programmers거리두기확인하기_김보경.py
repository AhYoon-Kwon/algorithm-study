from collections import deque

def bfs(place):
    start = []
    for i in range(5):
        for j in range(5):
            if place[i][j] == 'P':
                start.append([i, j])

    for s in start:
        queue = deque([s])
        visited = [[0] * 5 for i in range(5)]
        distance = [[0] * 5 for i in range(5)]
        visited[s[0]][s[1]] = 1
        while queue:
            r, c = queue.popleft()
            # 상하좌우
            dr = [-1, 1, 0, 0]
            dc = [0, 0, -1, 1]
            
            for d in range(4):
                nr = r + dr[d]
                nc = c + dc[d]
                # 범위에 맞아야 되고 아직 방문한 적이 없어야 한다
                if 0<=nr<5 and 0<=nc<5 and visited[nr][nc] == 0:
                    # 테이블이 있으면 dist +
                    if place[nr][nc] == 'O':
                        queue.append([nr, nc])
                        visited[nr][nc] = 1
                        distance[nr][nc] = distance[r][c] + 1
                    if place[nr][nc] == 'P' and distance[r][c] <= 1:
                        return 0

    return 1
            
def solution(places):
    answer = []
    for place in places:
        answer.append(bfs(place))
        
    return answer