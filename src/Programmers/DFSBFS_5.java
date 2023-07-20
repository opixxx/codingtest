package Programmers;

import java.util.*;

class DFSBFS_5 {
    static int[] ch;
    static ArrayList<String> list = new ArrayList<>();
    static String route = "";
    public void DFS(String start, String route, int L, String[][] tickets) {

        if(L == tickets.length + 1) list.add(route);
        else{
            for(int i = 0; i < tickets.length; i++) {
                if(ch[i] == 0 && tickets[i][0].equals(start)) {
                    ch[i] = 1;
                    DFS(tickets[i][1], route + " " + tickets[i][1], L + 1, tickets);
                    ch[i] = 0;
                }
            }
        }
    }
    public String[] solution(String[][] tickets) {
        String[] answer;
        ch = new int[tickets.length];
        DFS("ICN", "ICN", 1, tickets);
        Collections.sort(list);
        route = list.get(0);
        answer = route.split(" ");
        return answer;
    }
}