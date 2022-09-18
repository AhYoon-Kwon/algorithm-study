function solution(arr1, arr2) {
  let c = [];

  for (let i = 0; i < arr1.length; i++) {
    let rowArr = [];
    for (let j = 0; j < arr2[0].length; j++) {
      let x = 0;
      for (let k = 0; k < arr2.length; k++) {
        x += arr1[i][k] * arr2[k][j];
      }
      rowArr.push(x);
    }
    c.push(rowArr);
  }
  return c;
}
