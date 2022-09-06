from copy import deepcopy
import sys
path = __file__[0:-2] + 'txt'
sys.stdin = open(path, 'r')
input = sys.stdin.readline

key = []
lock = []
N, M = map(int, input().split())
for _ in range(N):
    key.append(list(map(int, input().split())))
for _ in range(M):
    lock.append(list(map(int, input().split())))

def add(x, y, N, key, tmp):
    for i in range(N):
        for j in range(N):
            tmp[x+i][y+j] += key[i][j]

def check(tmp, N, M):
    for i in range(M):
        for j in range(M):
            if tmp[N+i][N+j] != 1:
                return False
    return True

def solution(key, lock):
    N = len(key)
    M = len(lock)
    board = [[0 for i in range(2*N + M)] for _ in range(2*N + M)]
    for i in range(M):
        for j in range(M):
            board[N+i][N+j] = lock[i][j]

    rotated_key = key
    for _ in range(4):
        rotated_key = list(zip(*rotated_key[::-1]))
        for i in range(1, N + M):
            for j in range(1, N + M):
                tmp = deepcopy(board)
                add(i, j, N, rotated_key, tmp)
                if check(tmp, N, M):
                    return True

    return False


print(solution(key, lock))