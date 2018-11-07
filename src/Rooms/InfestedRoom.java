package Rooms;

import People.Person;

import java.util.Scanner;

public class InfestedRoom extends Room
{
    Person occupant;
    int xLoc,yLoc;

    public InfestedRoom(int x, int y)
    {
        super(x,y);
    }

    /**
     * Method controls the results when a person enters this room.
     * @param x the Person entering
     */
    public void enterRoom(Person x)
    {
        System.out.println("The room is filled to the brim with aliens. Do you run through them or use your pistol?([run] or [pistol]");

        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
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
