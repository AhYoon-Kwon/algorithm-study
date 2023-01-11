# test 5, test 10 실패

def solution(m, n, board):
    answer = 0
    game = [list(b) for b in board]
    dx = [1, 0, 1, 0]
    dy = [0, 1, 1, 0]
    while True:
        cnt = 0
        check = [[0 for _ in range(n)] for _ in range(m)]
        for i in range(m - 1):
            for j in range(n - 1):
                friend = game[i][j]
                # 비어있는 블록이면 넘어가기
                if not friend: continue
                # 하나라도 다른게 있다면 넘어가기
                if friend != game[i + dy[0]][j + dx[0]]: continue
                if friend != game[i + dy[1]][j + dx[1]]: continue
                if friend != game[i + dy[2]][j + dx[2]]: continue
                for k in range(4):
                    if check[i + dx[k]][j + dy[k]] == 0:
                        check[i + dx[k]][j + dy[k]] = 1
                        cnt += 1
        for i in range(m):
            print(game[i])
        # 찾아봤는데 같은 4개의 블록이 없으면 그만
        if cnt == 0:break
        # 값 더해주기
        answer += cnt
        # 지워주기
        for i in range(m):
            for j in range(n):
                if check[i][j]:
                    game[i][j] = []
        # 비어있는 칸만큼 내려주기
        for i in range(m - 1):
            for j in range(n):
                # 현재 위치에 블럭이 있는데
                if game[i][j]:
                    # 아래에는 블럭이 없으면?
                    if not game[i + 1][j]:
                        # 그 위에 모든 블럭들이 한칸씩 아래로 내려와야지 뭐
                        game[i + 1][j] = game[i][j]
                        game[i][j] = []

        print(check)
        for i in range(m):
            print(game[i])
    return answer

test = ["TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"]
print(solution(6, 6, test))