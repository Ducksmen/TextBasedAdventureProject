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
    private int q = 0;
    int xVal[];
    int yVal[];
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
        xVal = new int[15];
        yVal = new int[15];
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
            System.out.println(xVal[i] + ", " + yVal[i]) ;
            rooms[x][y] = new Survivors(x,y);
            rooms[x][y].survivor = true;
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
        boolean ym = true;
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                if(p.getyLoc()==j && p.getxLoc()==i)
                {
                    a += " [X] ";
                }
                else if (rooms[i][j].survivor)
                {
                    while (ym) {
                        for (int t = 0; t < 15; t++) {
                            if (rooms[i][j] == rooms[xVal[t]][yVal[t]]) {
                                a += " [S] ";
                                ym = false;
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
