package Programmers;

public class 이모티콘_할인행사 {
	static int[] sale = {10, 20, 30, 40};
	static int[] arr;
	static int[] answer;
	static int len;
	public int[] solution(int[][] users, int[] emoticons) {
		answer = new int[2];

		len = emoticons.length;
		arr = new int[len];

		getSale(0, users, emoticons);
		return answer;
	}

	static void getSale(int level, int[][] users, int[] emoticons) {
		if (level == len) {
			getAnswer(users, emoticons);
			return;
		}

		for (int i = 0; i < sale.length; i++) {
			arr[level] = sale[i];
			getSale(level + 1, users, emoticons);
		}
	}

	static void getAnswer(int[][] users, int[] emoticons) {
		int[] tmp = new int[2];

		for (int[] user : users) {
			int userSale = user[0];
			int userMoney = 0;
			for (int i = 0; i < arr.length; i++) {
				int curSale = arr[i];

				if (curSale >= userSale) {
					userMoney = userMoney + (emoticons[i] * (100-curSale) / 100);
				}
			}

			if (userMoney >= user[1]) {
				tmp[0]++;
			} else {
				tmp[1] += userMoney;
			}
		}

		if (answer[0] < tmp[0]) {
			answer[0] = tmp[0];
			answer[1] = tmp[1];
		} else if(answer[0] == tmp[0]) {
			answer[0] = tmp[0];
			answer[1] = Math.max(answer[1], tmp[1]);
		}
	}
}
