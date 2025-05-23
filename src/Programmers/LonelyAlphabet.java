package Programmers;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
알파벳 소문자로만 이루어진 어떤 문자열에서, 2회 이상 나타난 알파벳이 2개 이상의 부분으로 나뉘어 있으면 외톨이 알파벳이라고 정의합니다.

문자열 "edeaaabbccd"를 예시로 들어보면,

a는 2회 이상 나타나지만, 하나의 덩어리로 뭉쳐있으므로 외톨이 알파벳이 아닙니다.
"ede(aaa)bbccd"

b, c도 a와 같은 이유로 외톨이 알파벳이 아닙니다.
d는 2회 나타나면서, 2개의 부분으로 나뉘어 있으므로 외톨이 알파벳입니다.
"e(d)eaaabbcc(d)"

e도 d와 같은 이유로 외톨이 알파벳입니다.
문자열 "eeddee"를 예시로 들어보면,

e는 4회 나타나면서, 2개의 부분으로 나뉘어 있으므로 외톨이 알파벳입니다.
"(ee)dd(ee)"

d는 2회 나타나지만, 하나의 덩어리로 뭉쳐있으므로 외톨이 알파벳이 아닙니다.
"ee(dd)ee"

문자열 input_string이 주어졌을 때, 외톨이 알파벳들을 알파벳순으로 이어 붙인 문자열을 return 하도록 solution 함수를 완성해주세요. 만약, 외톨이 알파벳이 없다면 문자열 "N"을 return 합니다.
*/

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
