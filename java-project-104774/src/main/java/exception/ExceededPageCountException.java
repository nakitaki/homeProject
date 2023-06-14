package exception;

public class ExceededPageCountException extends Exception {
    private int pages;

    public ExceededPageCountException(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "ExceededPageCount{" +
                "pages=" + pages +
                "} " + super.toString();
    }
}
