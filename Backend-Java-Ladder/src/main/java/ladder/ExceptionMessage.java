package ladder;

public enum ExceptionMessage {
    INVALID_POSITION("범위 내에서 입력해주세요."), INVALID_DRAW_POSITION("범위 내에서 입력해주세요.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
