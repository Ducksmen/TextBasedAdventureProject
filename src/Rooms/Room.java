package Rooms;

import People.Person;

/**
 * boolean survivor and infested says if the room has a survivor or is infested.
 *
 */
public class Room {
    Person occupant;
    int xLoc,yLoc;
    public boolean survivor = false;
    public boolean infested = false;

    public Room(int x, int y)
    {
        xLoc = x;
        yLoc = y;
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
        System.out.println("You enter an empty room, luckily aliens haven't invested it yet.");
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
