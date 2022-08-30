const fs = require("fs");
const filePath = process.platform === "linux" ? "./dev/stdin" : "./input.txt";
let input = fs
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n")
  .map((row) => row.split(" ").map((num) => +num));

solution();

function solution() {
  //Write your code
  //어떻게 해야 되지?
  //1. 1을 만나면 DFS로 탐색하는 방식은 한계점이 있다. -> ㄹㅇ 모르겠...
  //2. 그렇다면 색종이의 크기를 줄여나가면서 일치여부를 판단하면 안 되나? -> 그렇다면 3 1개보다 2 2개가 더 효율적인 경우는 어떻게 잡지?
  //살려줘.....
}
