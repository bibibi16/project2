# 프로젝트 이름
게시판

# 세부사항
여러 개의 게시글을 관리.<br/>
작성: 새로운 게시글을 입력받아 리스트에 추가.<br/>
조회: 게시글 번호를 입력받아 해당 게시글을 출력.<br/>
삭제: 게시글 번호를 입력받아 해당 게시글을 삭제.<br/>
수정: 게시글 번호를 입력받아 제목과 내용을 수정.<br/>
번호 관리: 게시글이 삭제되면 그 자리의 번호는 채워지지 않지만, 나머지 게시글의 번호는 변하지 않음.<br/>
예외 : 조회, 삭제, 수정 시 숫자 외에 문자를 입력하면 예외 발생<br/>
<br/>
<br/>
<br/>
1단계
ArrayList<Post> posts: 게시글을 저장하는 리스트<br/>
int postIdCounter: 게시글의 ID를 관리하는 변수, 게시글 추가마다 1씩 증가<br/>
Scanner scanner: 입력을 받을 때 사용하는 스캐너 객체<br/>
1.  BoardProgram<br/>
명령어(작성, 조회, 삭제, 수정, 목록, 종료)를 입력받아 기능 실행<br/>
<br/>
2. createPost (게시글 작성)<br/>
제목과 내용을 입력받아 게시글 생성<br/>
<br/>
3. viewPost (게시글 조회)<br/>
게시글 번호 입력: 사용자가 조회할 게시글 번호를 입력<br/>
게시글 찾기: posts 리스트에서 해당 번호를 가진 게시글을 찾음<br/>
찾으면 게시글의 내용을 출력하고, 찾지 못하면 해당 번호가 존재하지 않는다는 메시지를 출력<br/>
예외 처리: 사용자가 잘못된 형식의 입력(예: 숫자가 아닌 값)을 입력했을 때<br/>
NumberFormatException이 발생할 수 있으며, 이 경우 적절한 안내 메시지를 출력<br/>
<br/>
4. deletePost (게시글 삭제)<br/>
게시글 번호 입력: 사용자가 삭제할 게시글 번호를 입력<br/>
게시글 삭제: 입력된 번호에 해당하는 게시글을 posts 리스트에서 제거<br/>
예외 처리: 잘못된 형식의 입력이 들어오면 NumberFormatException 예외 발생<br/>
<br/>
5. updatePost (게시글 수정)<br/>
게시글 수정: 게시글 번호를 입력하고, 제목과 내용을 다시 입력하여 해당 게시글을 수정<br/>
예외 처리: 잘못된 번호가 입력되거나 없는 게시글을 수정하려고 하면 적절한 메시지를 출력<br/>
<br/>
6. listPosts (게시글 목록 출력)
지금까지 작성된 모든 게시글을 출력<br/>
게시글이 몇 개 작성되었는지 보여주며, 각 게시글의 내용을 확인 가능<br/>


## 트러블 슈팅
1. 문제<br/>
   첫 번째 문제. 게시글 목록 출력시 문제 <br/>
   두 번째 문제. 게시물 번호 입력 시 ArrayList가 0부터 인덱스를 사용하기 때문에 혼동 발생 <br/>
3. 그에 대한 고민<br/>
   첫 번째, 두번째. 코드가 뭐가 있을까를 고민<br/>
5. 해결 방안<br/>
    강사님이 알려주신 것 + 공부했던 내용 + 구글 검색<br/>
6. 해결<br/>
1. 문제
<pre>
<code>
private static void listPosts() {
    if (posts.isEmpty()) {
        System.out.println("게시글이 없습니다.\n");
        return;
    }

    System.out.println("총 게시글은 " + posts.size() + "개 작성되어 있습니다.");
    for (Post post : posts) {
        post.display();
    }
}
</code>
</pre>
2. 번 문제
<pre>
<code>
private static void deletePost() {
    if (posts.isEmpty()) {
        System.out.println("삭제할 게시글이 없습니다.");
        return;
    }

    try {
        System.out.print("어떤 게시물을 삭제할까요? ");
        int postNumber = Integer.parseInt(scanner.nextLine());

        // 사용자가 입력한 게시물 번호가 유효한지 체크
        if (postNumber < 1 || postNumber > posts.size()) {
            System.out.println(postNumber + "번 게시글은 존재하지 않습니다.");
        } else {
            // 게시물 삭제 (인덱스는 0부터 시작하므로 -1)
            posts.remove(postNumber - 1);
            System.out.println(postNumber + "번 게시물이 성공적으로 삭제되었습니다!");
        }
    } catch (NumberFormatException e) {
        System.out.println("유효한 숫자를 입력해주세요."); // 잘못된 입력 처리
    }
           }
</code>
</pre>
7. 후기<br/>
    머리가 너무 아팠던 프로젝트 였습니다. 코드를 어떻게 실행해야하는지 어디서부터 작성해야하는지 머리가 멍해져서 강의 재복습 하고<br/>
   구글링하고 찾아보고 대입해보고.. 다른 코드들도 써보고..<br/>
   그래도 경험 할 수 있어 너무 좋았고 2단계를 다 끝마치지 못해서 아쉬움이 많이 남습니다.<br/>
    
