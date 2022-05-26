package task3;

import java.util.Objects;

public class Tree {
    public enum TreeState {
        BLOOM, FALLEN, SNOW, YELLOW
    }
    public Leaf[] leafs;
    TreeState state = TreeState.BLOOM;

    public Tree() {
        this.bloom();
    }

    public void bloom(){
        this.state = TreeState.BLOOM;
        leafs = new Leaf[5];

        for( int i = 0; i < 5; i++){
            leafs[i] = new Leaf("Green");
        }
    }
    public void fall(){
        this.state = TreeState.FALLEN;
        for (int i = 0; i < 5; i++){
            leafs[i] = null;
        }
    }
    public void snow(){
        this.state = TreeState.SNOW;
        for (int i = 0; i < 5; i++){
            leafs[i] = new Leaf("White");
        }
    }
    public void yellow(){
        this.state = TreeState.YELLOW;
        for (int i = 0; i < 5; i++){
            leafs[i] = new Leaf("Yellow");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tree tree = (Tree) o;
        return leafs.equals(tree.leafs) && state == tree.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(leafs[0]);
    }

    @Override
    public String toString() {
        String out = "Tree{statte="+state;

        for (int i = 0; i < 5; i++) {
            out += ", Leaf="+ leafs[i];
        }
        out += "}";

        return out;
    }

}
