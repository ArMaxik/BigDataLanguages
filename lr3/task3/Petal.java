package task3;

import java.util.Objects;

public class Petal {
    public String color;

    public Petal(){
        this.color = "Glass";
    }

    public Petal(String color){
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Petal petal = (Petal) o;
        return this.color.equals(petal.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.color);
    }

    @Override
    public String toString() {
        return "Petal{" +
                "color: " + this.color +
                '}';
    }
}

