package Rooms;

import Game.Runner;
import People.Person;

public class Exit extends Room
{
    public boolean survivor = false;
    public boolean infested = false;
    public Exit(int x, int y)
    {
        super(x,y);
        survivor = false;
        infested = false;
    }

    /**
     * Method controls the results when a person enters this room.
     * @param x the Person entering
     */
    public void enterRoom(Person x)
    {
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("You escape the station with an emergency shuttle.");
        Runner.gameOff();
    }

    /**
     * Removes the player from the room.
     * @param x
     */
    public void leaveRoom(Person x)
    {
        occupant = null;
    }

}
