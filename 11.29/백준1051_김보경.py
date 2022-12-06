n, m = map(int, input().split())

arr = []

for i in range(n):
    arr.append(list(input()))

check = min(n, m)
answer = 0
for i in range(n):
    for j in range(m):
        for k in range(check):
            # 범위를 벗어나거나 하나라도 틀리면 나가리
            if ((i + k) < n) and ((j + k) < m) and (arr[i][j] == arr[i][j + k] == arr[i + k][j] == arr[i + k][j + k]):
                # 넓이 계산
                answer = max(answer, (k + 1)**2)
                
print(answer)