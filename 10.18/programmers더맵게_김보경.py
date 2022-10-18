import heapq
def solution(scoville, K):
    answer = 0
    h=[]
    for s in scoville:
        heapq.heappush(h,s)
    while h[0]<=K:
        try:
            heapq.heappush(h,heapq.heappop(h)+heapq.heappop(h)*2)
            answer+=1
        except:
            return -1
    return answer