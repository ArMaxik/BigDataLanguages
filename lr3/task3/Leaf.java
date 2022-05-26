package task3;

import java.util.Objects;

public class Leaf {
    String color;

    public Leaf(String color) {
        this.color = color;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leaf leaf = (Leaf) o;
        return color.equals(leaf.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }

    @Override
    public String toString() {
        return "Leaf{" +
                "color=" + this.color +
                '}';
    }
}
