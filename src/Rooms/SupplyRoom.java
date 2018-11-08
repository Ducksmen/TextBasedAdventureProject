package Rooms;

import People.Person;

public class SupplyRoom extends Room
{
    public boolean survivor = false;
    public SupplyRoom(int x, int y)
    {
        super(x,y);
    }

    /**
     * Method controls the results when a person enters this room.
     * @param x the Person entering
     */
    public void enterRoom(Person x)
    {
        System.out.println("You find a supply room full of necessities. You fully repair your suit and obtain two extra clips.");
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
