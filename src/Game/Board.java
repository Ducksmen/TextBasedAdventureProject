package Game;

import Rooms.*;
import People.Person;

public class Board
{
    private Room[][] rooms;
    int x = 0;
    int y = 0;
    private int t = 0;
    int xVal[];
    int yVal[];
    public Board(Room[][] a)
    {
        this.rooms = a;
    }

    /**
     * xVal and yVal will save int x and y values of survivor rooms
     * While creating rooms it only checks for the starting and exit room.
     * Infested and supply rooms may be replaced because of this so I over compensated the amount of infested rooms.
     * When I made sure each room didn't get replaced sometimes the board wouldn't print as it would take too long to find an unused room.
     *
     */
    public void createRoom()
    {
        xVal = new int[12];
        yVal = new int[12];
        rooms[7][7] = new Exit(7,7);
        //Creating infested rooms
        for (int i = 0;i<40;i++)
        {
            x = (int)(Math.random()*8);
            y = (int)(Math.random()*8);
            if (x == 0 && y == 0 || x == 7 && y == 7)
            {
                while (x == 0 && y == 0 || x == 7 && y == 7)
                {
                    x = (int)(Math.random()*8);
                    y = (int)(Math.random()*8);
                }
            }
            rooms[x][y] = new InfestedRoom(x,y);
        }
        //Creating supply rooms
        for (int i = 0;i<5;i++)
        {
            x = (int)(Math.random()*8);
            y = (int)(Math.random()*8);
            if (x == 0 && y == 0 || x == 7 && y == 7)
            {
                while (x == 0 && y == 0 || x == 7 && y == 7)
                {
                    x = (int)(Math.random()*8);
                    y = (int)(Math.random()*8);
                }
            }
            rooms[x][y] = new SupplyRoom(x,y);
        }
        //Creating survivor rooms
        for (int i = 0;i<12;i++)
        {
            x = (int)(Math.random()*8);
            y = (int)(Math.random()*8);
            if (x == 0 && y == 0 || x == 7 && y == 7)
            {
                while (x == 0 && y == 0 || x == 7 && y == 7)
                {
                    x = (int)(Math.random()*8);
                    y = (int)(Math.random()*8);
                }
            }
            xVal[i] = x;
            yVal[i] = y;
            rooms[x][y] = new Survivors(x,y);
            rooms[x][y].survivor = true;
        }
    }

    /**
     * infectChance gets a random number between 0.0 and 1.0
     * randomSurvivor gets a random array location
     * There is a 50% chance that 6 or less survivor rooms become surpriseInfected rooms
     */
    public void infectSpread()
    {
        double infectChance = Math.random();
        int randomSurvivor;
        if(infectChance < .51)
        {
            for (int i = 0;i<6;i++)
            {
                randomSurvivor = (int)(Math.random()*12);
                rooms[xVal[randomSurvivor]][yVal[randomSurvivor]] = new surpriseInfected(xVal[randomSurvivor],yVal[randomSurvivor]);
            }
        }

    }

    /**
     * Prints the player location as [X] on the map
     * If the room is a survivor room it runs a while loop that finds that exact room and prints [S]
     * Every other room is [ ].
     * @param p Is needed for their x and y location
     * @return Returns the board as a string
     */
    public String toString(Person p)
    {
        String a = "";
        boolean ym = true;
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                if(p.getyLoc()==j && p.getxLoc()==i)
                {
                    a += " [X] ";
                }
                else if (rooms[i][j] == rooms[7][7])
                {
                    a += " [E] ";
                }
                else if (rooms[i][j].survivor)
                {
                    while (ym) {
                        if (rooms[i][j] == rooms[xVal[t]][yVal[t]])
                        {
                            a += " [S] ";
                            ym = false;
                            t = 0;
                        }
                        else
                        {
                            if (t<12)
                            {
                                t++;
                            }
                        }
                    }
                }
                else
                {
                    {
                        a += " [ ] ";
                    }
                }
                ym = true;
            }
            a += "\n";
        }
        return a;

    }
}
