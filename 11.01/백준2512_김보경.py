import sys
input = sys.stdin.readline

# 입력 받기
n = int(input())
arr = list(map(int, input().split()))
budget = int(input())
# 값을 정렬
arr.sort()

def search(array, start, end):
  # 상한액은 배열의 최대값을 넘을 수 없으므로 아래와 같이 조건 설정
  while start <= end:
    total = 0
    # 임시 상한액
    mid = (start + end) // 2
    for i in array:
      # 상한액 보다 커? 그럼 상한액만큼만
      if i > mid:
          total += mid
      # 작거나 같으면 노 상관
      else:
          total += i
    # 계산 결과과 총액을 넘어?
    if total > budget:
      # 그럼 상한액이 넘 큰거네 줄여
      end = mid -1
    # 오 아직 괜찮네 ㄱㄱ
    else:
      result = mid
      start = mid + 1
  return result
ans = search(arr, 0, arr[n-1])
print(ans)
