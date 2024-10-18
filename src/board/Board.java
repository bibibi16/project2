package board;

import java.util.Scanner;

public class Board {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int articleLastId = 0; // 마지막에 생성된 id 초창기엔 게시물이 없어 0

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

                int id = articleLastId + 1;
                articleLastId = id; // 값 보존

                Article article = new Article(); // 아티클 사용
                article.id = id;
                article.title = title;
                article.content = content;


                System.out.printf("%d번 게시물이 등록 되었습니다.\n", id);
                System.out.println("생성된 게시물 : " + article);

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

class Article { // 아티클 를래스 생성, 모든 클래스는 extends Object 클래스 상속
    int id;
    String title;
    String content;

    @Override // Object 클래스 오버라이드
    public String toString() {
        return String.format ("{게시물 번호 : %d, 제목 : \"%s\", 내용 : \"%s\"}", id, title, content);

    }
}




