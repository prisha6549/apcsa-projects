package robot;
import kareltherobot.*;

public class Roomba implements Directions {
    {
    Robot rom = new Robot(15,2,South,9);
    rom.move(); 
    rom.putBeeper();
    }
}
