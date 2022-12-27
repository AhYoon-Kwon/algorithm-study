def solution(cacheSize, cities):
    if cacheSize == 0:
        return len(cities) * 5
    answer = 0
    cache = []
    for city in cities:
        # newyork NewYork 같은거 동일하게 처리 위해 lower
        if city.lower() in cache:
            # 최신으로 업데이트
            cache.remove(city.lower())
            cache.append(city.lower())
            answer += 1
        else:
            # 꽉 찼어?
            if len(cache) == cacheSize:
                # 가장 오랜된거 지우기
                cache.pop(0)
            cache.append(city.lower())
            answer += 5
    return answer
