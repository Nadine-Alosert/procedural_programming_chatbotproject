/*
Author Nadine Alosert
A chat bot that imitates a human interaction
with a series of conversation topics covered
for the user mostly aimed at young adults
 */
import java.util.Scanner;
class chatbot
{
    public static void main(String[] args)
    {
        String username= "";
        username = introduction(username);
        topic(username);
        String print = " ";
        System.exit(0);
    }
    //Introduce chatbot and ask for user's name
    public static String introduction(String username)
    {
        tvshows t = new tvshows();
        String welcome;
        welcome="Hello there! I'm ChatterBox, What's your name?";
        System.out.println(welcome);
        Scanner w = new Scanner(System.in);
        username = w.nextLine();
        String reply = "Hello ";
        System.out.println(reply + username);
        return username;
    }//End introduction
    //Ask what talking point to discuss
    public static void topic(String username)
    {
        System.out.println("So what do you want to talk about, "+ username +" ?");
        System.out.println("Choose between Sports, play game or TV shows and movies");
        Scanner t = new Scanner(System.in);
        String response;
        response = t.nextLine();
        if (response.equalsIgnoreCase("TV shows and movies")){
            watch();
        }
        else if (response.equalsIgnoreCase("movies")) {
            watch();
        }
        else if (response.equalsIgnoreCase("TV shows")) {
            watch();
        }
        else if (response.equalsIgnoreCase("Sports")) {
            sports();
        }
        else
            other();
    }
    public static  void watch() {
        String username = "";
        print("Whats your favourite genre between RomCom, Action, Horror, Drama?");
        Scanner g = new Scanner(System.in);
        String genre;
        genre = g.nextLine();
        tvshows t = new tvshows();
        String[] movie = new String[10];
        if (genre.equalsIgnoreCase(t.genre= "RomCom")) {
            RomCom(movie);
        } else if (genre.equalsIgnoreCase(t.genre ="Action")) {
            Action(movie);
        } else if (genre.equalsIgnoreCase(t.genre= "Horror")) {
            Horror(movie);
        } else if (genre.equalsIgnoreCase(t.genre= "Drama")) {
            Drama(movie);
        }
        else
            print("I don't know or don't watch that genre");
    }
    public static void RomCom(String[] movie)
    {
        print("This is my personal top 10 favourite RomComs of all time:");
        print(" ");
        tvshows tv = new tvshows();
        int i;
        i=10;
        movie[0] = (tv.rank= 1)+ ": When Harry met Sally";
        movie[1] = (tv.rank= 2)+ ": OFFICE";
        movie[2] = (tv.rank= 3)+ ": Bridesmaids";
        movie[3] = (tv.rank= 4)+ ": Crazy, Stupid, Love";
        movie[4] = (tv.rank= 5)+ ": Love, Rosie";
        movie[5] = (tv.rank= 6)+ ": 50 first dates";
        movie[6] = (tv.rank= 7)+ ": 500 Days of Summer";
        movie[7] = (tv.rank= 8)+ ": 13 Going 30";
        movie[8] = (tv.rank= 9)+ ": That awkward moment";
        movie[9] = (tv.rank= 10)+ ": How to lose a guy in 10 days";

        for (int x=9; x>=0; x--)
        {
            print(movie[x]);
        }
        print("What about you? What's your favourite");
        String top10 = "";

           for(int n = 1; n<=10; n++)
            {
                Scanner m = new Scanner(System.in);
                String top;
                top = m.nextLine();
                top10 = ((tv.rank = n) + ":" + top +" "+ top10 + " ");
            }
            print("Your top 10 are: " );
            print(top10);
    }//END RomCom

    public static void Action(String[] movie)
    {
        System.out.println("This is my personal top 10 favourite Action movies of all time");
        tvshows tv = new tvshows();
        int i;
        i=10;

        movie[0] = (tv.rank= 1)+ " John Wick";
        movie[1] = (tv.rank= 2)+ " Rush Hour";
        movie[2] = (tv.rank= 3)+ " Dark Knight Rises";
        movie[3] = (tv.rank= 4)+ " Taken";
        movie[4] = (tv.rank= 5)+ " Unknown";
        movie[5] = (tv.rank= 6)+ " Baby Driver";
        movie[6] = (tv.rank= 7)+ " Bad Boys";
        movie[7] = (tv.rank= 8)+ " 2 Fast 2 Furious";
        movie[8] = (tv.rank= 9)+ " Face off";
        movie[9] = (tv.rank= 10)+ " Escape Plan";

        for (int y=9; y>=0; y--)
        {
           print(movie[y]);
        }
        print("What about you? What's your favourite");
        Scanner go = new Scanner(System.in);
        String goBack;
        goBack = go.nextLine();
        String top10 = "";


        for(int n = 1; n<=10; n++)
        {
            Scanner m = new Scanner(System.in);
            String top;
            top = m.nextLine();
            top10 = ((tv.rank = n) + ":" + top +" "+ top10 + " ");
        }
        print("Your top 10 are: " );
        print(top10);
    }
    public static void Horror(String[] movie)
    {
        print("This is my personal top 10 favourite Horror movies of all time");
        tvshows tv = new tvshows();
        int i;
        i=10;

        movie[0] = (tv.rank= 1)+ ": Mama";
        movie[1] = (tv.rank= 2)+ ": The Conjuring";
        movie[2] = (tv.rank= 3)+ ": The Nun";
        movie[3] = (tv.rank= 4)+ ": Get Out";
        movie[4] = (tv.rank= 5)+ ": The Shining";
        movie[5] = (tv.rank= 6)+ ": Sinister";
        movie[6] = (tv.rank= 7)+ ": Insidious";
        movie[7] = (tv.rank= 8)+ ": The Grudge";
        movie[8] = (tv.rank= 9)+ ": Drag Me To Hell";
        movie[9] = (tv.rank= 10)+ ": Saw";

        for (int z=9; z>=0; z--)
        {
            print(movie[z]);
        }
        print("What about you? What's your favourite");
        Scanner go = new Scanner(System.in);
        String goBack;
        goBack = go.nextLine();
        String top10 = "";


        for(int n = 1; n<=10; n++)
        {
            Scanner m = new Scanner(System.in);
            String top;
            top = m.nextLine();
            top10 = ((tv.rank = n) + ":" + top +" "+ top10 + " ");
        }
        print("Your top 10 are: " );
        print(top10);
    }
    public static void Drama(String[] movie)
    {
        print("This is my personal top 10 favourite Drama movies of all time");
        tvshows tv = new tvshows();
        int i;
        i=10;

        movie[0] = (tv.rank= 1)+ ": The Help";
        movie[1] = (tv.rank= 2)+ ": Titanic";
        movie[2] = (tv.rank= 3)+ ": Room";
        movie[3] = (tv.rank= 4)+ ": 12 years a slave";
        movie[4] = (tv.rank= 5)+ ": Forrest Gump";
        movie[5] = (tv.rank= 6)+ ": Still Alice";
        movie[6] = (tv.rank= 7)+ ": Fences";
        movie[7] = (tv.rank= 8)+ ": The Accountant";
        movie[8] = (tv.rank= 9)+ ": Notebook";
        movie[9] = (tv.rank= 10)+ ": Southpaw";
        for (int a=9; a>=0; a--)
        {
            print(movie[a]);
        }
        print("What about you? What's your favourite");
        Scanner go = new Scanner(System.in);
        String goBack;
        goBack = go.nextLine();
        String top10 = "";


        for(int n = 1; n<=10; n++)
        {
            Scanner m = new Scanner(System.in);
            String top;
            top = m.nextLine();
            top10 = ((tv.rank = n) + ":" + top +" "+ top10 + " ");
        }
        print("Your top 10 are: " );
        print(top10);
    }
    // If picked Sports then user will be asked a series of questions and 'guessing games'
    //using while and for loops and the user's input
    public static void sports()
    {
        print("How many sports do you watch?");
        Scanner many = new Scanner(System.in);
        int numberOfSports;
        numberOfSports = many.nextInt();

        print("What sports do you watch?");
        Scanner s = new Scanner(System.in);
        String watch;
        watch = s.nextLine();

        //User has 5 tries before revealing the correct answer of the chatbot
        print("Can you guess my favourite sport to watch?I'll give you 5 guesses till you guess");
        String favourite;
        favourite = s.nextLine();
        for(int guesses=5; guesses>0; guesses--) {
            if (!(favourite.equalsIgnoreCase("Rugby")))
            {
                print("Nope! Try again!");
                print("You have " + guesses + " guesses left!");
                favourite = s.nextLine();
            }
            else
            print("YES! You got it!");// congratulate when user answers correctly
        }
        print("The answer is rugby!");// state what the answer regardless if lost or not

        print("What about you? What's your favourite sport?");
        Scanner f = new Scanner(System.in);
        String sport;
        sport = f.nextLine();

    }


    public static String print(String print)
    {
             System.out.println(print);
             return print;
    }
    public static void other()
    {

    }
}//END class chatbot
class tvshows
{
    String genre;
    int rank;
}
class input
{

        }

