import sys
input = sys.stdin.readline

N = int(input())
ruler = [list(map(int, input().strip().split())) for _ in range(N)]
ruler.sort(key=lambda x:x[0])
start = ruler[0][0]
end = ruler[0][1]
length = 0
for i in range(1, N):
  # 만약 시작하는 점이 끝나는 점보다 길면 다시 길이 재기 시작
  if ruler[i][0] > end:
    # 끊겼기 때문에 앞의 부분 계산하기
    length += (end - start)
    start = ruler[i][0]
    end = ruler[i][1]
  # 만약 끝나는 점이 현재 점보다 크다면 end 업데이트
  # 작다면 할 필요 없음
  elif ruler[i][1] > end:
    end = ruler[i][1]
  # if i == N -1:
  #   length += (end-start)
  # 아래가 안되는 이유는 1개일때 계산하지 않기 때문이다
  # if i == N -1:
  #   length += (end-start)
# 마지막은 계산 안하므로 직접 해주기
length += (end-start)

print(length)
