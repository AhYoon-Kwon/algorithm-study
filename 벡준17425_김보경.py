import sys
input = sys.stdin.readline

# 해결법
# A 가 B로 나눠진다면 A의 약수의 합에 B를 더해야만 한다.
# A보다 작은 숫자로 나눠보면서
# 나눠진다면 더해나가는 과정을 전체 범위에 대하여 실행한다.

# 입력 받아놓기
N = int(input().strip())
quest = [int(input().strip()) for i in range(N)]
# 범위의 최대값(가독성 up)
MAX = 1000000

# 계산값 넣을 빈 배열과 누적합 계산할 빈 배열 만들기
sumDivisor = [0] * (MAX + 1)
sumCumulated = [0] * (MAX + 1)

# 모든 범위에 대하여 계산 시작
for i in range(1, MAX + 1):
    mul = 1
    while i * mul <= MAX:
        sumDivisor[i * mul] += i
        mul += 1
    sumCumulated[i] = sumCumulated[i - 1] + sumDivisor[i]

# 출력
for q in quest:
    print(sumCumulated[q])
