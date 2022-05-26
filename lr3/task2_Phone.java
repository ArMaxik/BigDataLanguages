public class task2_Phone {
    private int _id;
    private String _last_name;
    private String _name;
    private String _patronymic;
    private String _address;
    private long _card_number;
    private double _debit;
    private double _credit;
    private int _intercity_calls;
    private int _intracity_calls;

    public task2_Phone(
        int id,
        String last_name,
        String name,
        String patronymic,
        String address,
        long card_number,
        double debit,
        double credit,
        int intercity_calls,
        int intracity_calls
    ) {
        this._id = id;
        this._last_name = last_name;
        this._name = name;
        this._patronymic = patronymic;
        this._address = address;
        this._card_number = card_number;
        this._debit = debit;
        this._credit = credit;
        this._intercity_calls = intercity_calls;
        this._intracity_calls = intracity_calls;
    }

    public int get_Id() {
        return this._id;
    }

    public String get_Last_name() {
        return this._last_name;
    }

    public String get_Name() {
        return this._name;
    }

    public String get_Patronymic() {
        return this._patronymic;
    }

    public String get_Address() {
        return this._address;
    }

    public long get_Card_number() {
        return this._card_number;
    }

    public double get_Debit() {
        return this._debit;
    }

    public double get_Credit() {
        return this._credit;
    }

    public int get_Intercity_calls() {
        return this._intercity_calls;
    }

    public int get_Intracity_calls() {
        return this._intracity_calls;
    }

    public void set_Address(String address) {
        this._address = address;
    }

    public void set_Card_number(long card_number) {
        this._card_number = card_number;
    }

    public void set_Credit(double credit) {
        this._credit = credit;
    }

    public void set_Debit(double debit) {
        this._debit = debit;
    }

    public void set_Id(int id) {
        this._id = id;
    }

    public void set_Intercity_calls(int intercity_calls) {
        this._intercity_calls = intercity_calls;
    }

    public void set_Intracity_calls(int intracity_calls) {
        this._intracity_calls = intracity_calls;
    }

    public void set_Last_name(String last_name) {
        this._last_name = last_name;
    }

    public void set_Name(String name) {
        this._name = name;
    }

    public void set_Patronymic(String patronymic) {
        this._patronymic = patronymic;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id:" + _id +
                ", last_name:" + _last_name +
                ", name:" + _name +
                ", patronymic:" + _patronymic +
                ", address:" + _address +
                ", card_number:" + _card_number +
                ", debit:" + _debit +
                ", credit:" + _credit +
                ", intercity_calls:" + _intercity_calls +
                ", intracity_calls:" + _intracity_calls +
                "}";
    }
}
