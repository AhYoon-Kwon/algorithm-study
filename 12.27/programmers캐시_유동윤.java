package Programmers.lv1;

import java.util.ArrayList;
import java.util.Scanner;

public class programmers캐시_유동윤 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] cities = { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA" };
		System.out.println(solution(3, cities));
	}

	public static int solution(int cacheSize, String[] cities) {
		int answer = 0;
		ArrayList<String> cache = new ArrayList<>();
		if (cacheSize == 0) {
			return cities.length * 5;
		}
		int t = 0;
		for (int i = 0; i < cities.length; i++) {
			// 대소문자 구분x
			cities[i] = cities[i].toLowerCase();
			// cache hit
			if (cache.contains(cities[i])) {
				answer += 1;
				cache.remove(cache.indexOf(cities[i])); // 최근에 사용했으니까 뒤로 뺸다.
				cache.add(cities[i]);
			}
			// cache miss
			else {
				if (cache.size() == cacheSize)
					cache.remove(0); // 제일 오래된 것을 뺸다.
				cache.add(cities[i]);
				answer += 5;
			}

		}
		return answer;
	}
}
