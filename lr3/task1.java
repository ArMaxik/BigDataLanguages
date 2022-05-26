import java.util.*;
import java.text.*;

class ChainFraction {
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
        return this.value() / b.value();
    }

    public float value() {
        float val = 0.0f;
        
        for (int i = a.size()-1; i >= 0; i--) {
            val = x / (a.get(i) + val);
        }

        return val;
    }
}

class Fraction {
    // m
    // _
    // n
    Integer _m;
    Integer _n;

    public Fraction(Integer m, Integer n) {
        this._m = m;
        this._n = n;

        if (this._n == 0) {
            throw new ArithmeticException("Denominator can't be 0!");
        }
    }

    public Fraction(Fraction f) {
        this._m = f._m;
        this._n = f._n;
    }

    public Fraction add(Fraction b) {
        Integer r_m = this._m * b._n + b._m * this._n;
        Integer r_n = this._n * b._n;
        return new Fraction(r_m, r_n);
    }

    public Fraction sub(Fraction b) {
        Integer r_m = this._m * b._n - b._m * this._n;
        Integer r_n = this._n * b._n;
        return new Fraction(r_m, r_n);
    }

    public Fraction mul(Fraction b) {
        Integer r_m = this._m * b._m;
        Integer r_n = this._n * b._n;
        return new Fraction(r_m, r_n);
    }

    public Fraction div(Fraction b) {
        Integer r_m = this._m * b._n;
        Integer r_n = this._n * b._m;
        return new Fraction(r_m, r_n);
    }

    public float value() {
        return (float)this._m / this._n;
    }

}

public class task1 {
    public static void main(String[] args) {
        ChainFraction cf1 = new ChainFraction(2, new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
        ChainFraction cf2 = new ChainFraction(5, new ArrayList<Integer>(Arrays.asList(5, 3, 1)));
        System.out.println(cf1.value());
        System.out.println(cf2.value());
        System.out.println(cf1.add(cf2));
        System.out.println(cf1.sub(cf2));
        System.out.println(cf1.div(cf2));
        System.out.println(cf1.mul(cf2));

        System.out.println("\n\n=========================\n\n");

        Fraction f1 = new Fraction(3, 4);
        Fraction f2 = new Fraction(6, 10);
        System.out.println(f1.value());
        System.out.println(f2.value());
        System.out.println(f1.add(f2).value());
        System.out.println(f1.sub(f2).value());
        System.out.println(f1.mul(f2).value());
        System.out.println(f1.div(f2).value());
        
        try {
            Fraction f3 = new Fraction(1234, 0);
        }
        catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    
    
}