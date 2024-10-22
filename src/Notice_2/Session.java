package Notice_2;

public class Session {
    private String loggedUser;

    public void login(String username) {
        if (loggedUser != null){
            // 예외 사용으로 중복 로그인 방지
            throw new IllegalStateException("이미 로그인된 계정이 있습니다.");
        }
        // 로그인 되어있지 않다면 정상 로그인
        this.loggedUser = username;

    }
    public void  logout() {
        // 로그인된 사용자가 없는 상태에서 로그아웃을 시도하면 예외 발생
        if (loggedUser == null){
            throw new IllegalStateException("이미 로그인된 계정이 없습니다.");
        }
        // 로그아웃 처리 사용자 정보 없애기 위해 null  사용
        this.loggedUser = null;
    }

    public boolean isLoogedIn() {
        return loggedUser != null;
        // 리턴 값이 true면 로그인, false면 로그아웃
    }
    public String getLoggedUser() {
        return loggedUser;
        // loggedUser에 저장된 값을 반환
        // 만약 로그인이 되어 있다면, 로그인된 사용자의 이름이나 ID가 loggedUser에 저장되어 있으므로 그 값을 반환
    }

}
