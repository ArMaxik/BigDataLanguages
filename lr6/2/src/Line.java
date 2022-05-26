import java.util.Objects;

public class Line {
    double k;
    double b;

    String axis;
    double axisValue;

    Line(double k, double b) {
        this.k = k;
        this.b = b;
    }

    Line(String axis, double value) {
        this.axis = axis;
        this.axisValue = value;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Line)) {
            return false;
        }
        Line line = (Line) o;
        return k == line.k && b == line.b && Objects.equals(axis, line.axis) && axisValue == line.axisValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(k, b, axis, axisValue);
    }


    public Line() {
    }

    public Line(double k, double b, String axis, double axisValue) {
        this.k = k;
        this.b = b;
        this.axis = axis;
        this.axisValue = axisValue;
    }

    public double getK() {
        return this.k;
    }

    public void setK(double k) {
        this.k = k;
    }

    public double getB() {
        return this.b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public String getAxis() {
        return this.axis;
    }

    public void setAxis(String axis) {
        this.axis = axis;
    }

    public double getAxisValue() {
        return this.axisValue;
    }

    public void setAxisValue(double axisValue) {
        this.axisValue = axisValue;
    }

    public Line k(double k) {
        setK(k);
        return this;
    }

    public Line b(double b) {
        setB(b);
        return this;
    }

    public Line axis(String axis) {
        setAxis(axis);
        return this;
    }

    public Line axisValue(double axisValue) {
        setAxisValue(axisValue);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " k='" + getK() + "'" +
            ", b='" + getB() + "'" +
            ", axis='" + getAxis() + "'" +
            ", axisValue='" + getAxisValue() + "'" +
            "}";
    }

}