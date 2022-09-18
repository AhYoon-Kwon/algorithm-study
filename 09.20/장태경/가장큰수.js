function solution(numbers) {
  numbers = numbers.map((num) => String(num));
  
  const answer = numbers
    .sort((a, b) => b + a - (a + b))
    .reduce((prev, cur) => prev + cur, "");

  if (answer == 0) return "0";

  return answer;
}
