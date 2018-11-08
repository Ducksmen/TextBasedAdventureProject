package Rooms;

import People.Person;

public class Survivors extends Room
{
    public boolean survivor = true;
    public Survivors(int x, int y)
{
    super(x,y);
    survivor = true;
}

    /**
     * Method controls the results when a person enters this room.
     * @param x the Person entering
     */
    public void enterRoom(Person x)
    {
        System.out.println("You find an injured crew member inside the room.");
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
