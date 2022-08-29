# 백트랙킹이란 뭐 결국, 해를 구하다가 막히면 빨리 잘 돌아와서 다시 찾을 수 있도록
# 조건문 잘 가지고 노는건가?

import sys
input = sys.stdin.readline

paper = [list(map(int, input().split())) for _ in range(10)]
papers = [0] * 5

ans = 26

# 종이로 덮으려는 면적에 0 이 있는지 확인


def check(x, y, size):
    for i in range(x, x+size+1):
        for j in range(y, y+size+1):
            if (paper[i][j] == 0):
                return False
    return True

# 이것저것 종이대가면서 찾기 시작


def searching(x, y, cnt):
    global ans
    # 모든 행 다 봤어? 그럼 계산 ㄱ
    if x >= 10:
        ans = min(ans, cnt)
        return
    # 모든 열을 다 봤어? 그럼 다음 줄 처음부터로 ㄱ
    if y >= 10:
        searching(x + 1, 0, cnt)
        return

    # 1이 있어? 가려야지
    if paper[x][y] == 1:
        # 소인에게는 5종류의 색종이가 있사옵니다
        for p in range(5):
            # 다 씀
            if papers[p] == 5:
                continue
            # 범위 벗어나면 못 씀
            if x + p >= 10 or y + p >= 10:
                continue

            # 이제 붙여볼까?
            # 중간에 0도 없음
            if check(x, y, p):
                for i in range(x, x + p + 1):
                    for j in range(y, y + p + 1):
                        # 겹쳐도 안된다고 했으니 걍 0으로 바꿔버리기
                        paper[i][j] = 0
                # 사용한 색종이 표시해주기
                papers[p] += 1
                searching(x, y + p + 1, cnt + 1)
                # 취소한 경우의 수
                papers[p] -= 1
                for i in range(x, x + p + 1):
                    for j in range(y, y + p + 1):
                        # 겹쳐도 안된다고 했으니 걍 0으로 바꿔버리기
                        paper[i][j] = 1
    else:
        searching(x, y+1, cnt)

if sum([sum(p) for p in paper]) == 0:
    print(0)
else:
    searching(0, 0, 0)
    print(-1 if ans == 26 else ans)
