package board;

import java.util.Scanner;

public class Board {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("게시판 프로그램 시작");

        // 명령을 처리하기 위한 반복문
        while (true) {
            System.out.print("명령어 > ");
            String cmd = scanner.nextLine();

            if (cmd.equals("작성")) {
                System.out.println("게시글을 작성합니다.");
                System.out.print("제목 : ");
                String title = scanner.nextLine();

                System.out.print("내용 : ");
                String content = scanner.nextLine();

                int id = 1;
                System.out.printf("%d번 게시물이 등록 되었습니다.\n", id);


        }else if (cmd.equals("exit") || (cmd.equals("종료"))) {
                System.out.println("프로그램을 종료합니다.");
                break;


            } else {
                System.out.println("명령어가 이상합니다.");


            }


        }
        scanner.close();
    }
}




