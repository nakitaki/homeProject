public class Rhombus {
    private int n;

    public Rhombus(int n) {
        this.n = n;
    }

    public String getFigure() {
        return getTop() + getMiddle() + getBottom();
    }

    private String getTop() {
        StringBuilder out = new StringBuilder();
        for (int r = 1; r < n; r++) {
            out.append(repeatString(n - r, " ")).append(repeatString(r, "* ")).append(System.lineSeparator());
        }
        return out.toString();
    }

    private String getMiddle() {
        return repeatString(n, "* ") + System.lineSeparator();
    }

    private String getBottom() {
        StringBuilder out = new StringBuilder();
        for (int r = 1; r < n; r++) {
            out.append(repeatString(r, " ")).append(repeatString(n - r, "* ")).append(System.lineSeparator());
        }
        return out.toString();
    }

    private String repeatString(int count, String str) {
        return str.repeat(count);
    }
}
