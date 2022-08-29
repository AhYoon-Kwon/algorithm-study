# 아 시간초과 진짜 그럴줄 알았지만 진짜 화난닼ㅋㅋㅋㅋ - 배열을 자꾸 이리저리 가져다니니까 시간초과가 나네
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
    arr_list = copy.deepcopy(arr)
    new = copy.deepcopy(arr)

    for cal in cals:
        r, c, s = cal
        # 인덱싱 에러가 안나도록 -1 해주기
        start = (r - s - 1, c - s - 1)
        end = (r + s - 1, c + s - 1)

        while end[0] - start[0] > 0:
            for i in range(1, end[0] - start[0] + 1):
                 # 상
                new[start[0]][start[1] + i] = arr_list[start[0]][start[1] + i - 1]
                # 우
                new[start[0] + i][end[1]] = arr_list[start[0] + i - 1][end[1]]
                # 하
                new[end[0]][end[1] - i] = arr_list[end[0]][end[1] - i + 1]
                # 좌
                new[end[0] - i][start[1]] = arr_list[end[0] - i + 1][start[1]]
            start = (start[0] + 1, start[1] + 1)
            end = (end[0] - 1, end[1] - 1)
        arr_list = copy.deepcopy(new)
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
