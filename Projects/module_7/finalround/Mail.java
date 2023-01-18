package module_7.finalround;

public abstract class Mail<T> {
    private String from;
    private String to;
    private T content;

    public Mail(String from, String to, T content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    protected String getTo() {
        return to;
    }

    protected String getFrom() {
        return from;
    }

    protected T getContent() {
        return content;
    }
}
