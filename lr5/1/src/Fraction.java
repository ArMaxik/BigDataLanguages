public class Fraction {
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