def solution(n, k, cmd):
    arr = [i for i in range(n)]
    deleted = []    
    curr = k
    for c in cmd:
        if c[0] == 'U':
            curr -= int(c[-1])
        elif c[0] == 'D':
            curr += int(c[-1])
        elif c[0] == 'C':
            deleted.append((curr, arr[curr]))
            arr.pop(curr)
            if curr == len(arr):
                curr -= 1
        else:
            idx, num = deleted.pop()
            arr.insert(idx, num)
            if idx <= curr:
                curr += 1
    ans = ['O' if i in arr else 'X' for i in range(n)]
    
    answer = ''.join(ans)
    return answer