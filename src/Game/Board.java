package Game;

import Rooms.Room;
import People.Person;

public class Board
{
    private Room[][] rooms;
    int x = 0;
    int y = 0;
    public Board(Room[][] a)
    {
        this.rooms = a;
    }
    public Board(int x, int y)
    {
        rooms = new Room[x][y];
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
