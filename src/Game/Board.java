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
    private int xVal[];
    private int yVal[];
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
        for (int i = 0;i<30;i++)
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

        for (int i = 0;i<15;i++)
        {
            xVal = new int[15];
            yVal = new int[15];
            x = (int)(Math.random()*8);
            y = (int)(Math.random()*8);
            if (x == r && y == t)
            {
                while (x == r && y == t || x == 0 && y == 0)
                {
                    x = (int)(Math.random()*8);
                    y = (int)(Math.random()*8);
                }
            }
            o = x;
            k = y;
            xVal[i] = x;
            yVal[i] = y;
            rooms[x][y] = new Survivors(x,y);
        }

        for (int i = 0;i<2;i++)
        {
            x = (int)(Math.random()*8);
            y = (int)(Math.random()*8);
            if (x == r && y == t || x == o && y == k)
            {
                while (x == r && y == t || x == o && y == k || x == 0 && y == 0)
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
                else for(int k = 0;k<15;k++)
                {
                    if (rooms[i][j] == rooms[xVal[i]][yVal[i]])
                    {
                        a += " [S] ";
                    }
                    else
                    {
                        a += " [ ] ";
                    }
                }
            }
            a += "\n";
        }
        return a;

    }






}
