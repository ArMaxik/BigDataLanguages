package task4;

import java.util.Objects;

public class WorkersTeam {
    public String task;

    public WorkersTeam(String task) {
        this.task = task;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkersTeam t = (WorkersTeam) o;
        return task.equals(t.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(task);
    }

    @Override
    public String toString() {
        return "Workers team works on" + task;
    }
}
