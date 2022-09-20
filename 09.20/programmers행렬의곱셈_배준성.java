class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
//         결과 행렬의 위치 잡아주기 (답 들어갈 곳)
        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr2[0].length; j++){
//                     행렬 곱셈에서 곱해지는 두 수의 위치 정해줌
                for(int x = 0; x < arr1[0].length; x++){
                    answer[i][j] += arr1[i][x]*arr2[x][j];
                }
            }
        }

        return answer;
    }
}