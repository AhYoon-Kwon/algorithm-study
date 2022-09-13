# 아 시간초과 진짜 그럴줄 알았지만 진짜 화난닼ㅋㅋㅋㅋ - 배열을 자꾸 이리저리 가져다니니까 시간초과가 나네
# https://dailymapins.tistory.com/202 여기 참고하자
import copy
import sys
input = sys.stdin.readline

# 입력받기
N, M, K = map(int, input().split())
arr = []
for _ in range(N):
    arr.append(list(map(int, input().split())))
cals = []
for _ in range(K):
    cals.append(list(map(int, input().split())))

ans = sys.maxsize

# 회전


def rotate(cals):
    global arr
    global ans
    new = copy.deepcopy(arr)

    for cal in cals:
        r, c, s = cal
        # 인덱싱 에러가 안나도록 -1 해주기
        r -= 1
        c -= 1
        for n in range(s, 0, -1):
            tmp = new[r-n][c+n]
            # 상
            new[r-n][c-n+1:c+n+1] = new[r-n][c-n:c+n]
            # 좌
            for row in range(r-n, r+n):
                new[row][c-n] = new[row+1][c-n]
            # 하
            new[r+n][c-n:c+n] = new[r+n][c-n+1:c+n+1]
            # 우
            for row in range(r+n, r-n, -1):
                new[row][c+n] = new[row-1][c+n]
            new[r-n+1][c+n] = tmp
    for i in range(N):
        if sum(new[i]) < ans:
            ans = sum(new[i])


# 순열
check = [False for _ in range(K)]
result = [[] for _ in range(K)]


def perm(idx):
    if idx == K:
        # 순열 결과에 따라 min 값 계산하기
        rotate(result)
        return
    for i in range(K):
        if check[i]:
            continue
        result[idx] = cals[i]
        check[i] = True
        perm(idx + 1)
        check[i] = False


perm(0)
print(ans)
