import java.util.Objects;

public class Dot {
    double x;
    double y;

    Dot(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        Dot dot = (Dot) obj;

        return this.x == dot.x && this.y == dot.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }


    public Dot() {
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Dot x(double x) {
        setX(x);
        return this;
    }

    public Dot y(double y) {
        setY(y);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " x='" + getX() + "'" +
            ", y='" + getY() + "'" +
            "}";
    }

}