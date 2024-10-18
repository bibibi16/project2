package board;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Board {

    public static void main(String[] args) {
        ArrayList<Article> articles = new ArrayList<>();
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

                Article article = new Article(id, title, content);
                articles.add(article); // 게시글을 리스트에 추가

                System.out.printf("%d번 게시물이 등록 되었습니다.\n", id);
                System.out.println("생성된 게시물 : " + article);

            } else if (cmd.equals("목록")) {
                System.out.println("게시물은 " + articles.size() + "개 작성되어 있습니다.");
                if (articles.isEmpty()) {
                    System.out.println("게시물이 없습니다.");
                } else {
                    for (Article article : articles) {
                        article.display();
                    }
                }
            }else if (cmd.equals("수정")) {
                System.out.print("수정할 게시물 번호를 입력하세요 : ");
                int idToEdit = Integer.parseInt(scanner.nextLine());
                Article articleToEdit = findArticleById(articles, idToEdit);
                if (articleToEdit != null) {
                    System.out.print("새로운 제목: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("새로운 내용: ");
                    String newContent = scanner.nextLine();

                    articleToEdit.title = newTitle; // 제목 수정
                    articleToEdit.content = newContent; // 내용 수정
                    System.out.printf("%d번 게시물이 수정되었습니다.\n", idToEdit);
                } else {
                    System.out.println("해당 게시물이 존재하지 않습니다.");
                }

            } else if (cmd.equals("삭제")) {
                System.out.print("삭제할 게시물 번호를 입력하세요: ");
                int idToDelete = Integer.parseInt(scanner.nextLine());
                Article articleToDelete = findArticleById(articles, idToDelete);

                if (articleToDelete != null) {
                    articles.remove(articleToDelete); // 리스트에서 삭제
                    System.out.printf("%d번 게시물이 삭제되었습니다.\n", idToDelete);
                } else {
                    System.out.println("해당 게시물이 존재하지 않습니다.");
                }

            } else if (cmd.equals("exit") || cmd.equals("종료")) {
                System.out.println("프로그램을 종료합니다.");
                break;

            } else {
                System.out.println("명령어가 이상합니다.");
            }
        }

        scanner.close();
    }
    // 게시물 ID로 게시물 찾기
    private static Article findArticleById(ArrayList<Article> articles, int id) {
        for (Article article : articles) {
            if (article.id == id) {
                return article;
            }
        }
        return null; // 찾지 못한 경우 null 반환
    }
}

class Article {
    int id;
    String title;
    String content;

    Article(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format("번호 : %d, 제목 : %s, 내용 : %s", id, title, content);
    }

    public void display() {
        System.out.println("게시물 번호: " + id);
        System.out.println("제목: " + title);
        System.out.println("내용: " + content);
    }
}

