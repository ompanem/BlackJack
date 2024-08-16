public class Card {
    String name;
    int points;

    public Card(String name, int points) {
        this.name = name;
        this.points = points;
    }



    public String toString() {
        return name + ": " + points;
    }
}
