import java.util.Objects;

public class Segment {
    Dot dot1;
    Dot dot2;

    Line line;

    public Segment(Dot dot1, Dot dot2, Line line) {
        this.dot1 = dot1;
        this.dot2 = dot2;
        this.line = line;
    }

    Boolean contains(double x) {
        return x > dot1.x && x < dot2.x || x < dot1.x && x > dot2.x;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Segment)) {
            return false;
        }
        Segment segment = (Segment) o;
        return Objects.equals(dot1, segment.dot1) && Objects.equals(dot2, segment.dot2) && Objects.equals(line, segment.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dot1, dot2, line);
    }

    @Override
    public String toString() {
        return "{" +
            " dot1='" + this.dot1 + "'" +
            ", dot2='" + this.dot2 + "'" +
            ", line='" + this.line + "'" +
            "}";
    }

}
