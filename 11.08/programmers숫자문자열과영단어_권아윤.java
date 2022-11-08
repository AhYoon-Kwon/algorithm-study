class programmers숫자문자열과영단어_권아윤 {
    public int solution(String s) {
        int answer = 0;
        
       //찾아서 숫자로 바꿀 문자열 배열..
        String[] sNum = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i = 0; i < sNum.length; i++) {
            String temp = sNum[i];

            //배열 문자열 포함시 변환~
            if(s.contains(temp)) {
                String num = Integer.toString(i);
                s = s.replace(temp, num);
            }
        }
        answer = Integer.parseInt(s);
        
        return answer;
    }
}
