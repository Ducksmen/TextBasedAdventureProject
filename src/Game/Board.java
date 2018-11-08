package Game;

import Rooms.*;
import People.Person;

public class Board
{
    private Room[][] rooms;
    int x = 0;
    int y = 0;
    private int r = 0;
    private int t = 0;
    private int o = 0;
    private int k = 0;
    public Board(Room[][] a)
    {
        this.rooms = a;
    }
    public Board(int x, int y)
    {
        rooms = new Room[x][y];
    }

    public void createRoom()
    {
        for (int i = 0;i<40;i++)
        {
            x = (int)(Math.random()*8);
            y = (int)(Math.random()*8);
            if (x == 0 && y == 0)
            {
                while (x == 0 && y == 0)
                {
                    x = (int)(Math.random()*8);
                    y = (int)(Math.random()*8);
                }
            }
            r = x;
            t = y;
            rooms[x][y] = new InfestedRoom(x,y);
        }

        for (int i = 0;i<20;i++)
        {
            x = (int)(Math.random()*8);
            y = (int)(Math.random()*8);
            if (x == r && y == t)
            {
                while (x == r)
                {
                    x = (int)(Math.random()*8);
                }
                while (y == t)
                {
                    y = (int)(Math.random()*8);
                }

            }
            o = x;
            k = y;
            rooms[x][y] = new Survivors(x,y);
        }

        for (int i = 0;i<2;i++)
        {
            x = (int)(Math.random()*8);
            y = (int)(Math.random()*8);
            if (x == r && y == t || x == o && y == k)
            {
                while (x == r && y == t || x == o && y == k)
                {
                    x = (int)(Math.random()*8);
                    y = (int)(Math.random()*8);
                }
            }

            rooms[x][y] = new SupplyRoom(x,y);
        }
    }


    public String toString(Person p)
    {
        String a = "";
        for(int i=0;i<rooms.length;i++)
        {
            for(int j=0;j<rooms[i].length;j++)
            {
                if(p.getyLoc()==j && p.getxLoc()==i)
                {
                    a += " [X] ";
                }
                else if (rooms[i][j] == rooms[x][y])
                {
                    a += " [S] ";
                }
                else
                {
                    a += " [ ] ";
                }
            }
            a += "\n";
        }
        return a;

    }






}
