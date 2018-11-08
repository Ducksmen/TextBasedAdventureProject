package Game;

import People.Person;
import Rooms.InfestedRoom;
import Rooms.Room;
import Rooms.SupplyRoom;
import Rooms.Survivors;

import java.util.Scanner;

public class Runner {

    private static boolean gameOn = true;

    public static void main(String[] args) {
        boolean input = true;
        int sSize = 0;
        double iChance = 0;
        int infested = 0;
        int survivors = 0;
        int supplyRooms = 0;
        System.out.println("Aliens have invested your space station and you must escape." + "\n" +
                "You are equipped with a suit that can take 5 hits before breaking and a laser pistol with 2 clips" + "\n" +
                "Navigate through the station save as many survivors as you can" + "\n" +
                "Although you can see the survivors distress beacons you don't know where the aliens are, so be careful!" + "\n" +
                "If you encounter an infested room you can either clear the room with 1 clip or take damage and run out the the room." + "\n" +
                "If your lucky and find a supply room your suit is repaired fully and you gain 2 additional clips." + "\n" +
                "Infested rooms spread to the rooms adjacent to them randomly, they can infest survivors without you knowing so watch out!"
                );

        while (input)
        {
            Scanner in = new Scanner(System.in);
            System.out.println("What room size do you want?([small], [medium] or [large])");
            String size = in.nextLine();
            {
                if (size.equals("small") || size.equals("medium") || size.equals("large"))
                {
                    if (size.equals("small")) {
                        sSize = 4;
                        infested = 5;
                        survivors = 2;
                        supplyRooms = 1;
                    }
                    if (size.equals("medium")) {
                        sSize = 6;
                        infested = 16;
                        survivors = 4;
                        supplyRooms = 2;
                    }
                    if (size.equals("large")) {
                        sSize = 10;
                        infested = 45;
                        survivors = 6;
                        supplyRooms = 4;

                    }
                    input = false;
                }
                else {
                    System.out.println("Please choose a valid input.");
                }
            }
        }

        input = true;
        while (input)
        {
            Scanner in = new Scanner(System.in);
            System.out.println("What do you want the infestation chance to be?([small], [medium] or [large])");
            String chance = in.nextLine();
            if (chance.equals("small") || chance.equals("medium") || chance.equals("large")) {
                if (chance.equals("small")) {
                    iChance = .2;
                }
                if (chance.equals("medium")) {
                    iChance = .4;
                }
                if (chance.equals("large")) {
                    iChance = .6;
                }
                input = false;
            }
                else {
                    System.out.println("Please choose a valid input.");
                }
        }

        Room[][] building  = new Room[sSize][sSize];
        Board station = new Board(building);

        for (int x = 0; x < building.length; x++)
        {
            for (int y = 0; y < building[x].length; y++)
            {
                building [x][y] = new Room(x, y);
            }
        }
        int x = 0;
        int y = 0;
        int r = 0;
        int t = 0;
        int o = 0;
        int p = 0;

        for (int i = 0;i<infested;i++)
        {
            x = (int)(Math.random()*sSize);
            y = (int)(Math.random()*sSize);
            r = x;
            t = y;
            building[x][y] = new InfestedRoom(x,y);
        }

        for (int i = 0;i<survivors;i++)
        {
            x = (int)(Math.random()*sSize);
            y = (int)(Math.random()*sSize);
            if (x == r)
            {

            }
            building[x][y] = new Survivors(x,y);
        }

        for (int i = 0;i<supplyRooms;i++)
        {
            x = (int)(Math.random()*sSize);
            y = (int)(Math.random()*sSize);

            building[x][y] = new SupplyRoom(x,y);
        }

        //Setup player 1 and the input scanner
        Person player1 = new Person("FirstName", "FamilyName", 0, 0,5,2);
        building [0][0].enterRoom(player1);
        Scanner in = new Scanner(System.in);
        System.out.println(station.toString(player1));
        while (gameOn)
        {
            System.out.println("Where would you like to move? (Choose N, S, E, W)");
            String move = in.nextLine();
            if (validMove(move, player1, building )) {
                System.out.println(station.toString(player1));

            } else {
                System.out.println("Please choose a valid move.");
            }


        }
        in.close();
    }

    /**
     * Checks that the movement chosen is within the valid game map.
     * @param move the move chosen
     * @param p person moving
     * @param map the 2D array of rooms
     * @return
     */
    public static boolean validMove(String move, Person p, Room[][] map)
    {
        move = move.toLowerCase().trim();
        switch (move) {
            case "n":
                if (p.getxLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()-1][p.getyLoc()].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }
            case "e":
                if (p.getyLoc()< map[p.getyLoc()].length -1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "s":
                if (p.getxLoc() < map.length - 1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()+1][p.getyLoc()].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "w":
                if (p.getyLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()][p.getyLoc()-1].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }
            default:
                break;

        }
        return true;
    }
    public static void gameOff()
    {
        gameOn = false;
    }



}
