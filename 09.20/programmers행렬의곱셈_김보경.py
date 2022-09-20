def solution(arr1, arr2):
    return [[sum(a*b for a, b in zip(row,col)) for col in zip(*arr2)] for row in arr1]