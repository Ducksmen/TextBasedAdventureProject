package Rooms;

import java.util.Arrays;

public class Board
{
    private String [][] mansion;

    public Board (String[][] mansion)
    {
        this.mansion = mansion;
    }

    public void setMansion()
    {
        mansion[0][0] = "Room";
        mansion[0][1] = "Room";
        mansion[0][2] = "Room";
        mansion[0][3] = "Room";
        mansion[1][0] = "Room";
        mansion[1][1] = "Room";
        mansion[1][2] = "Room";
        mansion[1][3] = "Room";
        mansion[2][0] = "Room";
        mansion[2][1] = "Room";
        mansion[2][2] = "Room";
        mansion[2][3] = "Room";
        mansion[3][0] = "Room";
        mansion[3][1] = "Room";
        mansion[3][2] = "Room";
        mansion[3][3] = "Room";
    }

    public void print()
    {
        for (int i = 0;i<mansion.length;i++)
        {
            System.out.println(Arrays.deepToString(mansion[i]).replace("[","").replace("]","").replace(",",""));
        }
    }

    public String toString()
    {
        String n = "";
        for(int i = 0;i<mansion.length;i++)
        {
            for(int j = 0;j<mansion[i].length;j++)
            {
                System.out.println(mansion[i]);
            }
        }
        return n;
    }
}
