public class task2_House {
    private int _id;
    private int _number;
    private int _square;
    private int _floor;
    private int _room_count;
    private int _lifetime;
    private String _street;
    private String _building_type;

    public task2_House(
        int id,
        int number,
        int square,
        int floor,
        int room_count,
        String street, 
        String building_type,
        int lifetime
    ) {
        this._id = id;
        this._number = number;
        this._square = square;
        this._floor = floor;
        this._room_count = room_count;
        this._street = street; 
        this._building_type = building_type;
        this._lifetime = lifetime;
    }

    public void set_Id(int id) {
        this._id = id;
    }

    public void set_Building_type(String building_type) {
        this._building_type = building_type;
    }

    public void set_Floor(int floor) {
        this._floor = floor;
    }

    public void set_Lifetime(int lifetime) {
        this._lifetime = lifetime;
    }

    public void set_Number(int number) {
        this._number = number;
    }

    public void set_Room_count(int room_count) {
        this._room_count = room_count;
    }

    public void set_Square(int square) {
        this._square = square;
    }

    public void set_Street(String street) {
        this._street = street;
    }

    public int get_Id() {
        return this._id;
    }

    public double get_Square() {
        return this._square;
    }

    public int get_Floor() {
        return this._floor;
    }

    public int get_Lifetime() {
        return this._lifetime;
    }

    public int get_Number() {
        return this._number;
    }

    public int get_Room_count() {
        return this._room_count;
    }

    public String get_Building_type() {
        return this._building_type;
    }

    public String get_Street() {
        return this._street;
    }

    @Override
    public String toString() {
        return "House{" +
                "id: " + _id +
                ", number: " + _number +
                ", square: " + _square +
                ", floor: " + _floor +
                ", room_count: " + _room_count +
                ", lifetime: " + _lifetime +
                ", street: " + _street +
                ", building_type: " + _building_type +
                '}';
    }
}