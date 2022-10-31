import sys
input = sys.stdin.readline

arr = input().replace(' ', '')

# 십자카드 숫자를 넣으면 시계수를 찾아주는 함수
def getClockNum(arr):
# 십자카드로 만들 수 있는 숫자 4개
  nums = [0] * 4
  for i in range(4):
    string = ''
    for j in range(4):
      string += arr[(i + j) % 4]
    nums[i] = int(string)
  return min(nums)
# 시계수는
clockNum = getClockNum(arr)

# 숫자는 1111 ~ 9999
# 단, 0은 없어야 된다
ans = 1
tempNum = []
for num in range(1111, clockNum):
  string = str(num)
  if '0' in string: continue
  temp = getClockNum(string)
  # 계산된 시계수가 이미 앞에 나온것과 같은면 카운트 ㄴㄴ
  if temp not in tempNum:
    ans += 1
    tempNum.append(temp)

print(ans)
