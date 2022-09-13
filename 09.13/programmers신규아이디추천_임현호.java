class Solution {
    public String solution(String new_id) {
        new_id = new_id
                        .toLowerCase()
                        .replaceAll("[^a-zA-Z0-9-_.]", "") // 알파벳, -,_, . 제외 하고 제거
                        .replaceAll("[.]{2,}",".") // . 두개이상 . 으로 치환
                        .replaceAll("[.]$", "") // .으로 끝나는거 제거
                        .replaceAll("^[.]", ""); // .으로 시작 제거

        new_id = (new_id.length() == 0) ? "a" : new_id;
        new_id = (new_id.length() >= 16) ? new_id.substring(0, 15).replaceAll("[.]$","") : new_id;
        while(new_id.length() < 3)
            new_id += new_id.charAt(new_id.length() - 1);

        String answer = new_id;
        return answer;
    }
}