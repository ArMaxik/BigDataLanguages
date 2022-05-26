package task3;

import java.util.Objects;

public class Bud {
    public Petal[] petals;

    public Bud(String[] colors) {
        petals = new Petal[colors.length];

        for(int i = 0; i < colors.length; i++){
            petals[i] = new Petal(colors[i]);
        }
    }

    public Bud(String color, int num) {
        petals = new Petal[num];

        for(int i = 0; i < num; i++){
            petals[i] = new Petal(color);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bud bud = (Bud) o;
        return petals.equals(bud.petals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(petals[0]);
    }

    @Override
    public String toString() {
        return "Bud{" +
                "petal='" + petals[0].toString() + '\'' +
                '}';
    }
}
