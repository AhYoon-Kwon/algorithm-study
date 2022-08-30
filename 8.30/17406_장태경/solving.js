const fs = require("fs");
const filePath = process.platform === "linux" ? "./dev/stdin" : "./input.txt";
let input = fs
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n")
  .map((row) => row.split(" ").map((i) => +i));

const [N, M, K] = input[0];
let map = input.slice(1, 6);
let rotateOrder = input.slice(6);

solution();

function solution() {
  let answer = Number.MAX_VALUE;

  const orders = getPermutation(rotateOrder);

  for (let order of orders) {
    let mapCopied = map.map((v) => v.slice());
    // console.log(mapCopied);
    order.forEach((rotateArr) => {
      rotate(rotateArr, mapCopied);
    });
    // console.log(mapCopied);
    answer = Math.min(answer, findMin(mapCopied));
  }

  console.log(answer);
}

function getPermutation(order) {
  if (order.length === 1) return [order];
  let permus = [];

  const smallPermu = getPermutation(order.slice(1));
  const firstOrder = order[0];
  smallPermu.forEach((permu) => {
    for (let i = 0; i <= permu.length; i++) {
      const prefix = permu.slice(0, i);
      const suffix = permu.slice(i);
      permus.push(prefix.concat([firstOrder], suffix));
    }
  });
  return permus;
}

function rotate(rotateArr, mapCopied) {
  const r = rotateArr[0] - 1;
  const c = rotateArr[1] - 1;
  const s = rotateArr[2];

  const dr = [0, 1, 0, -1];
  const dc = [1, 0, -1, 0];

  for (let i = 1; i <= s; i++) {
    //끝점 잡아놓기
    const top = [r - i, c - i];
    const bottom = [r + i, c + i];

    let [nr, nc] = top;
    let older;
    let newer = mapCopied[nr][nc];

    //순회 test 후 적용
    for (let k = 0; k < 4; k++) {
      for (let j = 0; j < 2 * i; j++) {
        older = newer;
        nr = nr + dr[k];
        nc = nc + dc[k];
        newer = mapCopied[nr][nc];
        mapCopied[nr][nc] = older;
      }
    }
  }
  return mapCopied;

  //   //시작시점 북서
  //   //끝점 잡아 놓고 하나씩 밀기
  //   let tmpNW;
  //   for (let j = -i; j < i; j++) {
  //     tmpNW = mapCopied[r - i][c + j + 1];
  //     console.log(mapCopied[r - i][c + j + 1], "전");
  //     if (j === -i) {
  //       mapCopied[r - i][c + j + 1] = mapCopied[r - i][c + j];
  //     } else {
  //       mapCopied[r - i][c + j + 1] = tmpNW;
  //     }
  //     console.log(mapCopied[r - i][c + j + 1], "후");
  //   }

  //   //북동
  //   let tmpNE;
  //   for (let j = -i; j < i; j++) {
  //     //   console.log(i, j, r, c);
  //     tmpNE = mapCopied[r + j + 1][c + i];
  //     mapCopied[r + j + 1][c + i] = mapCopied[r + j][c + i];
  //   }
  //   mapCopied[r - i][c + i] = tmpNW;

  //   let tmpSE;
  //   for (let j = i; j > -i; j--) {
  //     tmpSE = mapCopied[r + i][c + j - 1];
  //     mapCopied[r + i][c + j - 1] = mapCopied[r + i][c + j];
  //   }
  //   mapCopied[r + i][c + i] = tmpNE;

  //   let tmpSW;
  //   for (let j = i; j > -i; j--) {
  //     tmpSW = mapCopied[r + j - 1][c - i];
  //     mapCopied[r + j - 1][c - i] = mapCopied[r + j][c - i];
  //   }
  // }
  // return mapCopied;
}

function findMin(map) {
  let min = Number.MAX_VALUE;
  for (let rows of map) {
    const rowSum = rows.reduce((pre, cur) => pre + cur, 0);
    min = Math.min(min, rowSum);
  }

  return min;
}
