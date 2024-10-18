package board;

import java.util.Scanner;

package board;

import java.util.Scanner;

public class Board {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("게시판 프로그램 시작");

        // 사용자 명령을 처리하기 위한 반복문
        while (true) {
            System.out.print("명령 > ");
            String cmd = scanner.nextLine();


            if (cmd.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;  // 반복문 종료
            } else {
                // 다른 명령어 처리
                System.out.println("명령어: " + cmd);
            }
        }

        scanner.close();
    }
}




