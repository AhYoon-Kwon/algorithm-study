n = int(input())
L = list(map(int, input().split()))


def f(L):
    if len(L) == 3:
        return L[0]*L[2]
    ret = 0
    for i in range(1, len(L)-1):
        r = L[i-1]*L[i+1]+f(L[:i]+L[i+1:])
        ret = max(ret, r)
    return ret


print(f(L))
