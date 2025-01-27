package Notice;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardProgram {
    private static ArrayList<Post> posts = new ArrayList<>(); //접근제어자 private 사용
    private static int postIdCounter = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("명령어 > ");
            String command = scanner.nextLine();

            if (command.equals("종료") || command.equals("exit")) {
                System.out.println("프로그램이 종료됩니다.");
                break;
            }

            switch (command) {
                case "작성":
                    createPost();
                    break;
                case "조회":
                    viewPost();
                    break;
                case "삭제":
                    deletePost();
                    break;
                case "수정":
                    updatePost();
                    break;
                case "목록":
                    listPosts();
                    break;
                default:
                    System.out.println("알 수 없는 명령어입니다.");
            }
        }
        scanner.close();
    }

    // 게시글 작성
    private static void createPost() {
        System.out.print("제목: ");
        String title = scanner.nextLine();
        System.out.print("내용: ");
        String content = scanner.nextLine();
        posts.add(new Post(postIdCounter++, title, content));
        System.out.println("게시글이 작성되었습니다.\n");
    }

    // 게시글 조회
    private static void viewPost() {
        try {
            System.out.print("어떤 게시물을 조회할까요? ");
            int postId = Integer.parseInt(scanner.nextLine());

            for (Post post : posts) {
                if (post.getId() == postId) {
                    post.display();
                    return;
                }
            }
            System.out.println(postId + "번 게시물은 존재하지 않습니다.\n");
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해야 합니다. 조회하려는 게시물 번호를 확인해주세요.\n");
        } catch (Exception e) {
            System.out.println("게시글 조회 중 오류가 발생했습니다: " + e.getMessage());
        }
    }


    // 게시글 삭제
    private static void deletePost() {
        if (posts.isEmpty()) {
            System.out.println("삭제할 게시글이 없습니다.");
            return;
        }

        try {
            System.out.print("어떤 게시물을 삭제할까요? ");
            int postNumber = Integer.parseInt(scanner.nextLine());

            if (postNumber <= 0 || postNumber > posts.size()) {
                System.out.println(postNumber + "번 게시글은 존재하지 않습니다.");
            } else {
                posts.remove(postNumber - 1);
                System.out.println(postNumber + "번 게시물이 성공적으로 삭제되었습니다!");
            }
        } catch (NumberFormatException e) {
            System.out.println("유효한 숫자를 입력해주세요.");
        }
    }

    // 게시글 수정
    private static void updatePost() {
        if (posts.isEmpty()) {
            System.out.println("수정할 게시글이 없습니다.");
            return;
        }

        try {
            System.out.print("어떤 게시물을 수정할까요? ");
            int postNumber = Integer.parseInt(scanner.nextLine());

            if (postNumber <= 0 || postNumber > posts.size()) {
                System.out.println(postNumber + "번 게시글은 존재하지 않습니다.");
            } else {
                System.out.println(postNumber + "번 게시물을 수정합니다.");
                System.out.print("제목: ");
                String newTitle = scanner.nextLine();
                System.out.print("내용: ");
                String newContent = scanner.nextLine();
                Post post = posts.get(postNumber - 1);
                post.setTitle(newTitle);
                post.setContent(newContent);
                System.out.println(postNumber + "번 게시물이 성공적으로 수정되었습니다!");
            }
        } catch (NumberFormatException e) {
            System.out.println("유효한 숫자를 입력해주세요.");
        }
    }

    // 게시글 목록 출력
    private static void listPosts() {
        System.out.println("총 게시글은 " + posts.size() + "개 작성되어 있습니다.");
        for (Post post : posts) {
            post.display();
        }
    }
}
