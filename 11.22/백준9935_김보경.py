import sys
input = sys.stdin.readline

quest = input().strip()
bomb = input().strip()
length = len(bomb)

# 문자열 replace 를 사용하면 시간복잡도가 높아진다
# 왜냐면 문자열을 사용하게 되면 복사, 또는 잘라내는거 모두
# 복사본을 만들게 된다
# 그에 반해 리스트로 만들면 복사 과정없이 그냥 없애기만 하는거라
# 더욱 빠르게 구현이 가능하다

# => stack 으로 구현해보자 
stack = []
for letter in quest:
  stack.append(letter)
  # 현재 넣은 문자가 폭발문자열의 마지막과 같고 
  # index error 를 피하기 위해 길이를 확인해주고
  if letter == bomb[-1] and len(stack) >= length:
    # 실제로 비교해보니 폭발 문자열과 같으면
    if ''.join(stack[-length:]) == bomb:
      # 문자열 길이만큼 pop
      for i in range(length):
        stack.pop()

print('FRULA 'if not stack else ''.join(stack))