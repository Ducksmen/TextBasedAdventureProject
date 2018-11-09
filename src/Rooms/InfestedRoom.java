package Rooms;

import Game.Runner;
import People.Person;

import java.util.Scanner;

public class InfestedRoom extends Room
{
    public boolean survivor = false;
    public boolean infested = true;
    public boolean surprise = false;
    public InfestedRoom(int x, int y)
    {
        super(x,y);
        survivor = false;
        infested = true;
        surprise = false;
    }

    /**
     * Method controls the results when a person enters this room.
     * @param x the Person entering
     */

    /**
     * while active is true the player must either run or use their pistol
     * @param x the Person entering
     */
    public void enterRoom(Person x)
    {
        boolean active = true;
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        Scanner in = new Scanner(System.in);
        System.out.println("The room is filled to the brim with aliens. Do you run through them or use your pistol?([run] or [pistol]");
        while (active)
        {
            String move = in.nextLine();
            if (move.equals("run"))
            {
                x.hp--;
                if(x.hp ==0)
                {
                    System.out.println("You are overwhelmed by the aliens and die."+ "\n" + "GAME OVER");
                    Runner.gameOff();
                    active = false;
                }
                else if(x.hp ==1)
                {
                    System.out.println("Your suit is broken as you run out of the room, one more hit and your done.");
                    active = false;
                }

                else
                {
                    System.out.println("You escape the alien infested room but parts of your suit break.");
                    active = false;
                }

            }
            else if (move.equals("pistol"))
            {
                if(x.clips == 0)
                {
                    System.out.println("You are out of clips for your pistol!");
                }
                else
                {
                    x.clips--;
                    System.out.println("Using your laser pistol you clear parts of the room and run out.");
                    active = false;
                }
            }
            else
            {
                System.out.println("Please put a valid input.");
            }
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
