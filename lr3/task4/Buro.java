package task4;

import java.util.LinkedList;
import java.util.Objects;

public class Buro {
    public LinkedList<WorkersTeam> teams;
    public Buro() {
        teams = new LinkedList<WorkersTeam>();
    }

    public int processTask(String task) {
        teams.add(new WorkersTeam(task));
        return task.length()*(task.length() % 7 + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buro b = (Buro) o;
        return teams.equals(b.teams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teams);
    }

    @Override
    public String toString() {
        return "Buro{teams: " + teams + "}";
    }
    
}
