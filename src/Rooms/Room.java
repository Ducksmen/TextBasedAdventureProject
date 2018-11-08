package Rooms;

import People.Person;

public class Room {
    Person occupant;
    int xLoc,yLoc;
    public boolean survivor = false;

    public Room(int x, int y)
    {
        xLoc = x;
        yLoc = y;
        survivor = false;
    }

    /**
     * Method controls the results when a person enters this room.
     * @param x the Person entering
     */
    public void enterRoom(Person x)
    {
        System.out.println("");
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
