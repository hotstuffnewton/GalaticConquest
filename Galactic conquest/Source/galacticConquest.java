import java.io.*;
import java.util.*;
import java.text.*;

public class galacticConquest
{
    public static void main(String[] args)
    {

        int starShips = 1000;
        int conqueredPlanet = 100;
        int darkMatter = 10000;
        int fuelGainedPerPlanet = 100;
        int shipsGainedPerPlanet = 10; 
        int tradeRatePerPlanet = 1000;
        int tradeRatePerShip = 20;        
        int temp =0;
        int event =0;
        int attacks =0;
        

        Random generator = new Random ();

        System.out.println("Galactic Conquest - You are now in command...don’t fuck it up!");

        for (int year = 1; year < 10; year ++){
            System.out.println(" ");
            System.out.println("This is year "+year+" of the WAR");            
            System.out.println("You have " + starShips + " Star Ships");            
            System.out.println("You have "+conqueredPlanet+ " Planets under your control");           
            System.out.println("Dark Matter available " +darkMatter+"T");           
            System.out.println("For every planet sold into slavery you gain " +tradeRatePerPlanet+ "T of Dark Matter");
            System.out.println("For ever ship dismantled you gain " +tradeRatePerShip+ "T of Dark Matter");
            System.out.println("Dark Matter Harvested per planet this year "+fuelGainedPerPlanet+"T");           
            System.out.println("Star Ships constructed per planet this year "+shipsGainedPerPlanet);
            System.out.println(" ");            

            while(true){
                System.out.println("How many planets do you wish to sell?");
                temp = UserInput.readInt();
                if (temp > conqueredPlanet) {
                    System.out.println("Error Invalid Amount...idiot! ");
                    System.out.println(" ");
                }
                else if (temp <= conqueredPlanet) {
                    darkMatter +=(temp * tradeRatePerPlanet);
                    conqueredPlanet -=temp;
                    System.out.println("Dark Matter available " +darkMatter+"T");
                    System.out.println("You have "+conqueredPlanet+ " Planets under your control");
                    break;
                }
            }
            System.out.println(" ");

            while(true) {
                System.out.println("How many ships do you wish to dismantle?");
                temp = UserInput.readInt();
                if (temp >= starShips - (starShips/10)+1)  {
                    System.out.println("Error you cannot sell more then 90% of your fleet.....fool");
                    System.out.println(" ");
                }
                else if (temp <= starShips+1)  {
                    starShips -= temp;
                    darkMatter += (temp * tradeRatePerShip);
                    System.out.println("Dark Matter available " +darkMatter+"T");
                    System.out.println("You have " + starShips + " Star Ships");
                    break;
                }}
            System.out.println(" ");

            while(true){
                System.out.println("How many ships do you wish to commit to battle? (20T of Dark Matter is needed per ship)");
                temp = UserInput.readInt();
                if (temp >= (darkMatter/20)+1) {
                    System.out.println("Error not enough Dark Mattert...twinkle toes! ");
                    System.out.println(" ");
                }
                else if (temp >= starShips+1)  {
                    System.out.println("Error not enough ships....smart arse");
                    System.out.println(" ");
                }
                else if(temp <= (darkMatter/20)+1){
                    conqueredPlanet +=(temp/100);
                    darkMatter -= (temp*20);
                    System.out.println('\f'+" ");
                    System.out.println(" "); 
                    System.out.println("You have invaded a star system and enslaved "+(temp/100)+ " habitable  planets");
                    System.out.println(" ");
                    break;
                }
            }

            while(true){
                if (attacks >= starShips) {
                    attacks = 0;
                }
                else if (attacks <= starShips) {
                    starShips -= attacks;
                    System.out.println("Your attack on the star system inflicted losses on your fleet. you lost "+attacks+" ships");
                    System.out.println(" ");
                    break;
                }}

            while(true){
                System.out.println("During the time you were slaughtering billions for your own entertainment something happened within your empire that could affect the war effort");
                if (event <= 1)  {
                    System.out.println("Oops sorry nothing to worry about, false alarm. Turns out it was all a dream.");
                    break;
                }
                else if (event <= 2)  {
                    System.out.println("One of your ships Captains....Zapp Brannigan decided it would be a good idea to attack a planet on his own. you now own the pacifist planet of the cowardly zone.");
                    conqueredPlanet += 1;
                    break;
                }
                else if (event <=3)  {
                    System.out.println("The star system of Mordor has invaded your empire, to be honest with you..... You’re fucked");
                    System.out.println("Mordor has taken "+(conqueredPlanet /=2)+" planets");
                    break;

                }
                else if (event <=4)  {
                    System.out.println("Dark Matter can now be refined into element zero! Thanks to a new discovery on Mars");
                    System.out.println("your Dark Matter has doubled!");
                    break;
                }
                else if(event <=5)  {
                    System.out.println("You fell in love with one of the women severing on your personal star ship, but she got back with her boyfriend.");
                    System.out.println("You rain fiery death upon all you come across, nothing can quench your rage. That is until you come across the wenches and mead planet");
                    conqueredPlanet *=2;
                    starShips /=2;
                    System.out.println("Your planets doubled thanks to your heart broken rage but you left half your fleet to garrison the new headquarters on the wenches and mead planet");
                    break;
                }
                else if (event <=6)  {
                    System.out.println("Robot guy Fawkes tried to blow up your headquarters, good job he was running on a windows operating system and blue screened before he could start the countdown");
                    System.out.println("A small garrison of 1000 star ships from your fleet has been taken to keep the peace at your headquarters");
                    starShips -= 1000;
                    break;
                }
                else if (event <=7)  {
                    System.out.println("Dark matter shortage within your empire has angered the people so they have taken to steeling it");
                    System.out.println("You have lost 10000T of Dark Matter");
                    darkMatter -= 10000;
                    break;
                }
                else if (event <=8)  {
                    System.out.println("A star system recently conquered has rebelled and freed itself from your dominion");
                    System.out.println("You have lost 10 planets");
                    conqueredPlanet -= 10;
                    break;
                }
                else if (event <=9)  {
                    System.out.println("A new fleet has appeared ITS A TRAP!");
                    break;
                }}

            starShips +=(shipsGainedPerPlanet*conqueredPlanet);
            darkMatter +=(fuelGainedPerPlanet*conqueredPlanet);

            shipsGainedPerPlanet = generator.nextInt(29) + 1;
            fuelGainedPerPlanet = generator.nextInt(199) + 1;
            tradeRatePerPlanet = generator.nextInt(4999) + 1;
            event = generator.nextInt(9) + 1;
            attacks = generator.nextInt(999) + 1;
            tradeRatePerShip = generator.nextInt(49) + 1;

        }//End Year
        
        System.out.println(" ");
        System.out.println("You have " + starShips + " Star Ships");        
        System.out.println("You have "+conqueredPlanet+ " Planets under your control");        
        System.out.println("Dark Matter available " +darkMatter+"T");       
        System.out.println("For every planet sold into slavery you gain " +tradeRatePerPlanet+ "T of Dark Matter");
        System.out.println("For ever ship dismantled you gain " +tradeRatePerShip+ "T of Dark Matter");
        System.out.println("Dark Matter Harvested per planet this year "+fuelGainedPerPlanet+"T");        
        System.out.println("Star Ships constructed per planet this year "+shipsGainedPerPlanet);
        System.out.println(" ");

        while (true) {
            System.out.println("Your progress shall now be ranked.....");
            if (conqueredPlanet <= 10)  {
                System.out.println("Someone without hands could play this game better then you could!");
                break;
            }
            else if (conqueredPlanet <= 50)  {
                System.out.println("Get off this computer and never play this game again its insulting to be played with so badly");
                break;
            }
            else if (conqueredPlanet <= 100)  {
                System.out.println("Did you even bother to play? or were you too busy licking windows?");
                break;
            }
            else if (conqueredPlanet <= 150)  {
                System.out.println("A fluffy kitten would have been more brutal");
                break;
            }
            else if (conqueredPlanet <= 200) {
                System.out.println("You’re learning the ways of pointless killing... well done!");
                break;
            }
            else if (conqueredPlanet <= 250)  {
                System.out.println("We both know you can do better have another go!");
                break;
            }
            else if (conqueredPlanet <= 300)  {
                System.out.println("Finally a player worthy of Mordor");
                break;
            }
            else if (conqueredPlanet <=1000)  {
                System.out.println("I wouldn’t like to meet you in a dark alley way, slaughter of galaxies");
                break;
            }}

    }//End Main
}//End Class
