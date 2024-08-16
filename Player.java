import java.util.ArrayList;

public class Player {
    int points = 0;
    String name = "";
    boolean hasAceAs11 = false;

    public Player(String name){
        this.name = name;
    }

    public void drawCard(ArrayList<Card> deck){
        if(!(deck.isEmpty())){
            Card card = deck.get(0);
            if(hasAceAs11 == false && card.points==1 && points<=10){ //ace has 11 points or 1
                points+=11;
                hasAceAs11 = true;
            }

            else{
                points+=card.points;
                if(points>21 && hasAceAs11 == true){ //subtract 10 points so person doesn't burn.  Eg having 20 points and getting an ace.  20+11 = 31  31-10 = 21
                    points-=10;
                    hasAceAs11 = false;
                }
            }
          if(name.equalsIgnoreCase("player")) {
                System.out.println(name + " draw " + card.name + ": " + card.points + " points");
                deck.remove(0);
            }
            deck.remove(0);


        }
    }
}
