import sys
input = sys.stdin.readline

# 입력받기
N = int(input().strip())
M = int(input().strip())
# vip 자리를 기준으로 덩어리 나누기
chunkList = [0] * (M + 1)
prev = 1
for i in range(M + 1):
  if i < M:
    num = int(input().strip())
  else:
    num = N + 1
  chunkList[i] = num - prev
  prev = num + 1  

# 갯수 특징을 반영한 dp
dp = []
# 0개는 당연히 0개지만 계산이 잘 되도록 하기 위해서 1로
dp.append(1)
# 1개도 당연히 1개
dp.append(1)
# 2개가 되면 2가지가 존재
dp.append(2)

for i in range(3, 41):
  dp.append(dp[i - 1] + dp[i - 2])

ans = 1
for c in chunkList:
  ans *= dp[c]
print(ans)