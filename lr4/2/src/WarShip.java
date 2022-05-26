public abstract class WarShip implements IShip {
    public String[] weapons;

    public void fire(String position) {
        System.out.println("Я выстрелил в " + position);
    };

    WarShip(String[] weapons) {
        this.weapons = weapons;
    }

    WarShip(int weaponCount) {
        this.weapons = new String[weaponCount];
    }
}
