import java.util.ArrayList;

public class ChainFraction {
    int x;
    ArrayList<Integer> a;

    public ChainFraction(int x, ArrayList<Integer> a) {
        this.x = x;
        this.a = a;  
    }

    public float add(ChainFraction b) {
        return this.value() + b.value();
    }

    public float sub(ChainFraction b) {
        return this.value() - b.value();
    }

    public float mul(ChainFraction b) {
        return this.value() * b.value();
    }

    public float div(ChainFraction b) {
        if (b.value() == 0 ) throw new ArithmeticException("Can't divide by zero!");
        else return this.value() / b.value();
    }

    public float value() {
        float val = 0.0f;
        
        for (int i = a.size() - 1; i >= 0; i--) {
            val = x / (a.get(i) + val);
        }

        return val;
    }
}