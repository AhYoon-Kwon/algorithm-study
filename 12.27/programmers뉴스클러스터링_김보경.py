import re
def solution(str1, str2):
    first = makeList(str1)
    second = makeList(str2)

    inter = len(intersection(first, second))
    multi = len(multiset(first, second))
    if inter == 0 and multi == 0:
        return 65536
    answer = int(inter / multi * 65536)
    return answer

# 리스트로 만들어주기
def makeList(string):
    result = []
    string = list(string)
    for i in range(0, len(string) - 1):
        temp = ''.join(string[i:i+2])
        # 영어 아니면 추가하지 않는다
        if temp.isalpha():
            result.append(temp.lower())
    return result

# 교집합 구하기
def intersection(first, second):
    # copy 를 쓰지않으면 원본 리스트까지 바뀜
    first_copy = first.copy()
    result = []
    for i in second:
        if i in first_copy:
            result.append(i)
            first_copy.remove(i)
    return result

# 합집합 구하기
def multiset(first, second):
    first_copy = first.copy()
    first_result = first.copy()
    for i in second:
        if i not in first_copy:
            first_result.append(i)
        else:
            first_copy.remove(i)
    return first_result
            

solution("E=M*C^2","e=m*c^2")