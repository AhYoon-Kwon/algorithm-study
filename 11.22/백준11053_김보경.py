import sys
input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))
ans = [0] * N

# 전체 범위를 돌면서 확인
for i in range(N):
  # 확인 중인 i 를 기준으로 
  for j in range(i):
    # 나보다 작은 친구가 있고 나보다 숫자가 작아?
    # 그럼 내 값이 가장 긴 증가수열이네!
    if arr[i] > arr[j] and ans[i] < ans[j]:
      ans[i] = ans[j]
  # 증가가 됐든 안됐든 일단 나는 무조건 1의 길이를 가지니까
  ans[i] += 1
print(max(ans))