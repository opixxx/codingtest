package Programmers;

class search_1 {
    public int solution(int[][] sizes) {
        int answer = 0, length = 0, height = 0;
        for(int[] card : sizes) {
            length = Math.max(length, Math.max(card[0], card[1]));
            height = Math.max(height, Math.max(card[0], card[1]));
        }
        answer = length * height;
        return answer;
    }
/*        int answer = 0;
        int len = sizes.length;
        int tmp = 0;
        for(int i = 0; i < len; i++) {
            if(sizes[i][0] < sizes[i][1]) {
                tmp = sizes[i][1];
                sizes[i][1] = sizes[i][0];
                sizes[i][0] = tmp;

            }
        }
        int max_1 = Integer.MIN_VALUE;
        int max_2 = Integer.MIN_VALUE;
        for(int i = 0; i < len; i++) {
            if(sizes[i][1] > max_1) max_1 = sizes[i][1];
        }
        for(int i = 0; i < len; i++) {
            if(sizes[i][0] > max_2) max_2 = sizes[i][0];
        }
        answer = max_1 * max_2;
        return answer;
    }*/
}

