import math
import sys
from turtle import speed
path = __file__[0:-2] + 'txt'
sys.stdin = open(path, 'r')
input = sys.stdin.readline

progresses = list(map(int, input().strip().split()))
speeds = list(map(int, input().split()))


def solution(progresses, speeds):
    answer = []
    day = 0
    length = len(progresses)
    for idx in range(length):
        if progresses[idx] == -1:
            continue
        if progresses[idx] < 100:
            #날짜 구하기
            day = math.ceil((100 - progresses[idx]) / speeds[idx])
            # 날짜 만큼 값을 더하기
            for i in range(idx, length):
                progresses[i] = progresses[i] + speeds[i] * day
        # 몇 개가 완료됐는지 확인
        cnt = 0
        for i in range(idx, length):
            if progresses[i] >= 100:
                cnt += 1
                progresses[i] = -1
            else: break
        answer.append(cnt)
    return answer


print(solution(progresses, speeds))
