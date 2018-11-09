package Rooms;

import People.Person;

public class Survivors extends Room
{
    public boolean survivor = true;
    public boolean infested = false;
    public boolean surprise = false;
    public Survivors(int x, int y)
{
    super(x,y);
    survivor = true;
    infested = false;
    surprise = false;
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
        System.out.println("You find a crew member who repairs your suit and gives you an extra clip.");
        x.clips++;
        x.hp++;
        if(x.hp>3)
        {
            x.hp = 3;
        }
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
