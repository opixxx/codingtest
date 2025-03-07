package Programmers;

public class K진수에서_소수_개수_구하기 {
	public int solution(int n, int k) {
		int answer = 0;

		String newNum = getNewNum(n, k);
		String[] arr = newNum.split("0");

		for(String a : arr) {
			if(!a.isEmpty()) {
				if(isPrime(Long.parseLong(a))) {
					answer++;
				}
			}
		}
		return answer;
	}

	public boolean isPrime(long num) {
		if (num == 1) return false;
		if (num == 2) return true;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) {
				return false;
			}

		}
		return true;
	}

	public String getNewNum(int n, int k) {

		StringBuilder num = new StringBuilder();
		while(true) {
			int a = n / k; //몫
			int b = n % k; //나머지

			n = a;
			num.append(b);

			if(a == 0) break;
		}
		num.reverse();
		return num.toString();
	}
}