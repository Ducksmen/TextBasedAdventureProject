package Game;

import People.Person;
import Rooms.Room;

import java.util.Scanner;

public class Runner {

    private static boolean gameOn = true;

    public static void main(String[] args) {
        System.out.println("Aliens have invested your space station and you must escape." + "\n" +
                "You are equipped with a suit that can take 4 hits before breaking and a laser pistol with 4 clips" + "\n" +
                "You can see the survivors distress beacons you don't know where the aliens are, so be careful!" + "\n" +
                "If you encounter an infested room you can either use your pistol or run." + "\n" +
                "Using your pistol doesn't kill all of the aliens so they will return if you go back to that room but you will take no damage." + "\n" +
                "Running leaves the aliens still in there and your suit will take damage." + "\n" +
                "If you save a survivor, they will give you 1 clip and repair your suit by 1." + "\n" +
                "If your lucky and find a supply room your suit is repaired fully and you gain 2 additional clips." + "\n" +
                "Survivor rooms may become infected randomly."
                );

        Room[][] building  = new Room[8][8];
        Board station = new Board(building);

        for (int x = 0; x < building.length; x++)
        {
            for (int y = 0; y < building[x].length; y++)
            {
                building [x][y] = new Room(x, y);
            }
        }
        station.createRoom();
        //Setup player 1 and the input scanner
        Person player1 = new Person("FirstName", "FamilyName", 0, 0,5,4);
        building [0][0].enterRoom(player1);
        Scanner in = new Scanner(System.in);
        System.out.println(station.toString(player1));
        while (gameOn)
        {
            System.out.println("Where would you like to move? (Choose N, S, E, W)" + "(Suit Hp: " + (player1.hp - 1)  + " Pistol Clips: " + player1.clips + ")");
            String move = in.nextLine();
            if (validMove(move, player1, building )) {
                System.out.println(station.toString(player1));
                station.infectSpread();

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
