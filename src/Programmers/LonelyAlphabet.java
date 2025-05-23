package Programmers;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LonelyAlphabet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String Alphabet = scanner.nextLine();

        Set<Character> set = new HashSet<>(); // 포함되는 문자 확인을 위한 set
        Set<Character> visit = new HashSet<>(); // 중복 안 되게 출력값을 저장하기 위한 set

        char prev = 0;
        for (int i = 0; i < Alphabet.length(); i++) {
            char c = Alphabet.charAt(i);
            // 전의 값과 같지 않고, 이미 포함하고 있는 경우에는 visit에 저장
            if (c != prev) {
                if (set.contains(c)) {
                    visit.add(c);
                }
                set.add(c);
            }
            prev = c;
        }

        if (set.isEmpty()) {
            System.out.println("N");
        }

        // stream의 sorted를 이용하여 Print 진행
        visit.stream().sorted().forEach(System.out::print);
    }
}
