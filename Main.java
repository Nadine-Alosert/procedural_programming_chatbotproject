/*
Author Nadine Alosert
A chat bot that imitates a human interaction
with a series of conversation topics covered
for the user mostly aimed at young adults
 */
import java.io.*;
import java.lang.module.FindException;
import java.util.Scanner;
class chatbot
{
    public static void main(String[] args)
    {
        String username= "";
        username = introduction(username);//returned value stored in variable username
        topic(username);//pass argument to save user's name
        String print ="";
        String byeBye = "";
        bye(byeBye);//say bye to user after conversations end
        System.exit(0);
    }//END main

    //Introduce chatbot and ask for user's name
    public static String introduction(String username)//greet user
    {
        String welcome;
        welcome="Hello there! I'm ChatterBox, What's your name?";
        System.out.println(welcome);
        Scanner w = new Scanner(System.in);
        username = w.nextLine();
        String reply = "Hello ";
        System.out.println(reply + username);
        return username;//return value, input from user
    }//End introduction

    //Ask what talking point to discuss
    public static void topic(String username)//pass argument to save user's name
    {
        System.out.println("So what do you want to talk about, "+ username +" ?");
        System.out.println("Choose between Sports or TV shows and movies");//give topic options to user to choose from
        Scanner t = new Scanner(System.in);
        String response;
        response = t.nextLine();
        //if else statements to call upon methods depending on answers given by user
        if (response.equalsIgnoreCase("TV shows and movies")){
            watch();
        }
        else if (response.equalsIgnoreCase("movies")) {
            watch();
        }
        else if (response.equalsIgnoreCase("TV shows")) {
            watch();
        }
        else if (response.equalsIgnoreCase("Sports")){
            sports();
        }
        else
            topic(username);//same method called upon to ensure the user chooses from within the options only
    }//END topic

    public static void watch() {
        print("Whats your favourite genre between RomCom, Action, Horror, Drama?");//give options for the user to pick
        Scanner g = new Scanner(System.in);
        String genre;
        genre = g.nextLine();
        //create new (empty ) record types (t/t2/t3/t4) to fill with new values, same structure
        // record accessed via setter and getter (accessor) methods (ADT-abstract data type)
        tvshows t = new tvshows();
        t = setGenre(t, "RomCom");//set to value eg'romcom' for eg String genre
        tvshows t2 = new tvshows();
        t2 = setGenre(t2,"Action" );
        tvshows t3 = new tvshows();
        t3 = setGenre(t3,"Horror" );
        tvshows t4 = new tvshows();
        t4 = setGenre(t4,"Drama" );

        String[] movie = new String[10];//string array created to store bulk data
        // if else statements to call methods dependent on option picked
        if (genre.equalsIgnoreCase(getGenre(t))) {
            romCom(movie);//array movie passed as an argument to other methods called
        } else if (genre.equalsIgnoreCase(getGenre(t2))) {
            action(movie);
        } else if (genre.equalsIgnoreCase(getGenre(t3))) {
            horror(movie);
        } else if (genre.equalsIgnoreCase(getGenre(t4))) {
            drama(movie);
        }
        else
            print("I don't watch that genre- Please try another option");
        watch();//call this method again to ensure user chooses an option
    }//END watch

    public static void romCom(String[] movie)
    {
        print("This is my personal top 10 favourite RomComs of all time");
        //records and ADT
        //create new record types to fill
        //setter methods set 'ranks' to a new value
        tvshows t1 = new tvshows();
        t1 = setRank(t1, 1) ;
        tvshows t2 = new tvshows();
        t2 = setRank(t2, 2) ;
        tvshows t3 = new tvshows();
        t3 = setRank(t3, 3) ;
        tvshows t4 = new tvshows();
        t4 = setRank(t4, 4) ;
        tvshows t5 = new tvshows();
        t5 = setRank(t5, 5) ;
        tvshows t6 = new tvshows();
        t6 = setRank(t6, 6) ;
        tvshows t7 = new tvshows();
        t7 = setRank(t7, 7) ;
        tvshows t8 = new tvshows();
        t8 = setRank(t8, 8) ;
        tvshows t9 = new tvshows();
        t9 = setRank(t9, 9) ;
        tvshows t10 = new tvshows();
        t10 = setRank(t10, 10) ;

        movie= new String[10];//string array created, 10 new spaces created

        //getter methods to take values set previous to be used
        movie[0] = getRank(t1) + ": When Harry met Sally";
        movie[1] = getRank(t2) + ": Love, Rosie";
        movie[2] = getRank(t3) + ": Bridesmaids";
        movie[3] = getRank(t4) + ": Crazy, Stupid, Love";
        movie[4] = getRank(t5) + ": 500 Days of Summer";
        movie[5] = getRank(t6)+ ": 50 first dates";
        movie[6] = getRank(t7) + ": 13 Going 30";
        movie[7] = getRank(t8) + ": That awkward moment";
        movie[8] = getRank(t9) + ": How to lose a guy in 10 days";
        movie[9] = getRank(t10) + ": 17 Again";

        String directory = "C:/Users/Hope/IdeaProjects/Chat3/movies/";//location of this program
        String fileName = "movies";//store data in file movies
        String fullPath = directory + fileName + ".txt";//store the file in .txt file
        try {
            FileWriter file = new FileWriter(fullPath, true);// adding to the file, true to add to end file, false to overwrite
            for (int x=0; x<10; x++) {
                file.write(movie[x]+"\n");//write data of movies string array line by line onto file movies
            }
            file.close();//to save and close and NOT overwrite next time this file is opened
        }
        catch (IOException e)
        {
            System.out.println("NOT FOUND");// when no lines to print or wrong data typed
        }
        String[] top10array = inputFile(fullPath);//input method called to be stored in string array top10array

        for (int x=0; x < top10array.length; x++)
        {
            print(top10array[x]);//print data of array from input file to output
        }

        print("What about you? What's your favourite movies (from 10 to 1)");
        String top = "";

        for(int n = 1; n<=10; n++)
        {
            Scanner m = new Scanner(System.in);
            top = m.nextLine();
        }
        print("Your top movie is: " );
        print(top);
    }//END romCom
    public static void action(String[] movie)
    {
        print("This is my personal top 10 favourite Action movies of all time");

        //records and ADT
        //create new record types to fill
        //setter methods set 'ranks' to a new value
        tvshows t1 = new tvshows();
        t1 = setRank(t1, 1) ;
        tvshows t2 = new tvshows();
        t2 = setRank(t2, 2) ;
        tvshows t3 = new tvshows();
        t3 = setRank(t3, 3) ;
        tvshows t4 = new tvshows();
        t4 = setRank(t4, 4) ;
        tvshows t5 = new tvshows();
        t5 = setRank(t5, 5) ;
        tvshows t6 = new tvshows();
        t6 = setRank(t6, 6) ;
        tvshows t7 = new tvshows();
        t7 = setRank(t7, 7) ;
        tvshows t8 = new tvshows();
        t8 = setRank(t8, 8) ;
        tvshows t9 = new tvshows();
        t9 = setRank(t9, 9) ;
        tvshows t10 = new tvshows();
        t10 = setRank(t10, 10) ;

        movie = new String[10];
        //getter methods to take values set previous to be used
        movie[0] = getRank(t1) + " John Wick";
        movie[1] = getRank(t2) + " Rush Hour";
        movie[2] = getRank(t3) + " Dark Knight Rises";
        movie[3] = getRank(t4) + " Taken";
        movie[4] = getRank(t5) + " Unknown";
        movie[5] = getRank(t6)+ " Baby Driver";
        movie[6] = getRank(t7) + " Bad Boys";
        movie[7] = getRank(t8) + " 2 Fast 2 Furious";
        movie[8] = getRank(t9) + " Face off";
        movie[9] = getRank(t10) + " Escape Plan";

        String directory = "C:/Users/Hope/IdeaProjects/Chat3/movies/";//location of this program
        String fileName = "movies";//store data in file movies
        String fullPath = directory + fileName + ".txt";//store the file in .txt file
        try {
            FileWriter file = new FileWriter(fullPath, true);// adding to the file, true to add to end file, false to overwrite
            for (int x=0; x<10; x++) {
                file.write(movie[x]+"\n");//write data of movies string array line by line onto file movies
            }
            file.close();//to save and close and NOT overwrite next time this file is opened
        }
        catch (IOException e)
        {
            System.out.println("NOT FOUND");// when no lines to print or wrong data typed
        }
        String[] top10array = inputFile(fullPath);//input method called to be stored in string array top10array

        for (int x=0; x < top10array.length; x++)
        {
            print(top10array[x]);//print data of array from input file to output
        }

        print("What about you? What's your favourite movies");

        String top="";
        for(int n = 1; n<=10; n++)
        {
            Scanner m = new Scanner(System.in);

            top = m.nextLine();
        }
        print("Your top movie is  " );
        print(top);
    }//END action
    public static void horror(String[] movie)
    {
        print("This is my personal top 10 favourite Horror movies of all time");

        //records and ADT
        //create new record types to fill
        //setter methods set 'ranks' to a new value
        tvshows t1 = new tvshows();
        t1 = setRank(t1, 1) ;
        tvshows t2 = new tvshows();
        t2 = setRank(t2, 2) ;
        tvshows t3 = new tvshows();
        t3 = setRank(t3, 3) ;
        tvshows t4 = new tvshows();
        t4 = setRank(t4, 4) ;
        tvshows t5 = new tvshows();
        t5 = setRank(t5, 5) ;
        tvshows t6 = new tvshows();
        t6 = setRank(t6, 6) ;
        tvshows t7 = new tvshows();
        t7 = setRank(t7, 7) ;
        tvshows t8 = new tvshows();
        t8 = setRank(t8, 8) ;
        tvshows t9 = new tvshows();
        t9 = setRank(t9, 9) ;
        tvshows t10 = new tvshows();
        t10 = setRank(t10, 10) ;

        movie= new String[10];
        //getter methods to take values set previous to be used
        movie[0] = getRank(t1) + ": Mama";
        movie[1] = getRank(t2) + ": The Conjuring";
        movie[2] = getRank(t3) + ": The Nun";
        movie[3] = getRank(t4) + ": Get Out";
        movie[4] = getRank(t5) + ": The Shining";
        movie[5] = getRank(t6) + ": Sinister";
        movie[6] = getRank(t7) + ": Insidious";
        movie[7] = getRank(t8) + ": The Grudge";
        movie[8] = getRank(t9) + ": Drag Me To Hell";
        movie[9] = getRank(t10) + ": Saw";

        String directory = "C:/Users/Hope/IdeaProjects/Chat3/movies/";//location of this program
        String fileName = "movies";//store data in file movies
        String fullPath = directory + fileName + ".txt";//store the file in .txt file
        try {
            FileWriter file = new FileWriter(fullPath, true);// adding to the file, true to add to end file, false to overwrite
            for (int x=0; x<10; x++) {
                file.write(movie[x]+"\n");//write data of movies string array line by line onto file movies
            }
            file.close();//to save and close and NOT overwrite next time this file is opened
        }
        catch (IOException e)
        {
            System.out.println("NOT FOUND");// when no lines to print or wrong data typed
        }
        String[] top10array = inputFile(fullPath);//input method called to be stored in string array top10array

        for (int x=0; x < top10array.length; x++)
        {
            print(top10array[x]);//print data of array from input file to output
        }

        print("What about you? What's your favourite");
        String top = "";

        for(int n = 1; n<=10; n++)
        {
            Scanner m = new Scanner(System.in);
            top = m.nextLine();
        }
        print("Your top movie is " );
        print(top);

    }//END horror
    public static void drama(String[] movie)
    {
        print("This is my personal top 10 favourite Drama movies of all time");

        //records and ADT
        //create new record types to fill
        //setter methods set 'ranks' to a new value
        tvshows t1 = new tvshows();
        t1 = setRank(t1, 1) ;
        tvshows t2 = new tvshows();
        t2 = setRank(t2, 2) ;
        tvshows t3 = new tvshows();
        t3 = setRank(t3, 3) ;
        tvshows t4 = new tvshows();
        t4 = setRank(t4, 4) ;
        tvshows t5 = new tvshows();
        t5 = setRank(t5, 5) ;
        tvshows t6 = new tvshows();
        t6 = setRank(t6, 6) ;
        tvshows t7 = new tvshows();
        t7 = setRank(t7, 7) ;
        tvshows t8 = new tvshows();
        t8 = setRank(t8, 8) ;
        tvshows t9 = new tvshows();
        t9 = setRank(t9, 9) ;
        tvshows t10 = new tvshows();
        t10 = setRank(t10, 10) ;

        movie= new String[10];
        //getter methods to take values set previous to be used
        movie[0] = getRank(t1) + ": The Help";
        movie[1] = getRank(t2) + ": Titanic";
        movie[2] = getRank(t3) + ": Room";
        movie[3] = getRank(t4) + ": 12 years a slave";
        movie[4] = getRank(t5) + ": Forrest Gump";
        movie[5] = getRank(t6) + ": Still Alice";
        movie[6] = getRank(t7) + ": Fences";
        movie[7] = getRank(t8) + ": The Accountant";
        movie[8] = getRank(t9) + ": Notebook";
        movie[9] = getRank(t10) + ": Southpaw";

        String directory = "C:/Users/Hope/IdeaProjects/Chat3/movies/";//location of this program
        String fileName = "movies";//store data in file movies
        String fullPath = directory + fileName + ".txt";//store the file in .txt file
        try {
            FileWriter file = new FileWriter(fullPath, true);// adding to the file, true to add to end file, false to overwrite
            for (int x=0; x<10; x++) {
                file.write(movie[x]+"\n");//write data of movies string array line by line onto file movies
            }
            file.close();//to save and close and NOT overwrite next time this file is opened
        }
        catch (IOException e)
        {
            System.out.println("NOT FOUND");// when no lines to print or wrong data typed
        }
        String[] top10array = inputFile(fullPath);//input method called to be stored in string array top10array

        for (int x=0; x < top10array.length; x++)
        {
            print(top10array[x]);//print data of array from input file to output
        }

        print("What about you? What's your favourite");
        String top = "";

        for(int n = 1; n<=10; n++)
        {
            Scanner m = new Scanner(System.in);
            top = m.nextLine();
        }
        print("Your top movie is " );
        print(top);
    }//END drama

    public static String[] inputFile(String fullPath)//input method
    {
        String [] inputArray = new String[10];//create new array with data inputted
        try {
            BufferedReader file = new BufferedReader(new FileReader(fullPath));//buffer acts as a middle median to avoid
            //issues eg overflow - too fast
            String line;
            while((line = file.readLine()) != null) {//the while loop works if line read isn't empty(null)
                for (int i = 0; i < inputArray.length; i++){//for loop to go through every array value
                    inputArray[i] = file.readLine();//read every line of the array (until null)
                }
            }
            }
        catch(FileNotFoundException e)
            {
            print("FILE NOT FOUND");//when file is unrecognised
            }
        catch(IOException e)
            {
            print("FILE READ ERROR");//misreading of file
            }
        return inputArray;//return input
     }//END inputFile

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
        favourite = "";

        guessingGame(favourite);//method called with while loop inside a for loop(loop in a loop)

        print("The answer is rugby!");// state what the answer regardless if lost or not

        print("What about you? What's your favourite sport?");//answer to this question will call a unique method
        //sports mentioned here are most popular sports
        String sport;
        sport = s.nextLine();
        int [] rank =new int[10];
        if (sport.equalsIgnoreCase("football"))
        {
            print("Rate these players out of 10!");
            rank =footballPlayers(rank);

        }
        else if (sport.equalsIgnoreCase("basketball"))
        {
            print("Rate these players out of 10!");
            rank = basketballPlayers(rank);

        }
        else if (sport.equalsIgnoreCase("cricket"))
        {
            print("Rate these players out of 10!");
            rank =cricketPlayers(rank);

        }
        else if (sport.equalsIgnoreCase("rugby")) {
            print("Rate these players out of 10!");
            rank =rugbyPlayers(rank);

        }
        else if (sport.equalsIgnoreCase("tennis"))
        {
            print("Rank these players out of 10!");
            rank =tennisPlayers(rank);

        }
        else if (sport.equalsIgnoreCase("boxing"))
        {
            print("Rate these boxers out of 10!");
            rank = boxers(rank);

        }
        else {
            print("Oh cool! I dont know that sport, who's your favourite player?");
            String player = s.nextLine();
        }

    }//END sports

    public static String guessingGame(String favourite)//Sports topic
    {
        Scanner s = new Scanner(System.in);
        favourite = s.nextLine();
        for (int guesses = 5; guesses > 0; guesses--)//while loop in a for loop
        {
        while ((favourite.equalsIgnoreCase("")))//The user must participate/Lack of
        //input from the user is not acceptable
        {
            System.out.println("you have to try!");
            favourite = s.nextLine();
        }
        if (!(favourite.equalsIgnoreCase("Rugby")))//if else statements with responses
        //accordingly to their answers
        {

            print("Nope! Try again!");
            print("You have " + (guesses-1) + " guesses left!");// the number of guesses will reduce when guesses
            // are wrong until guesses available run out
            favourite = s.nextLine();//give another try for user till run out of guesses
        }
        else
            print("YES! You got it!");// congratulate when user answers correctly
        }
        return favourite;
    }//END guessingGame

    public static int [] footballPlayers(int[] rank)
    {
        final int top = 10;//constant
        Scanner s = new Scanner(System.in);
        rank = new int[10];
        String [] player = new String[10];

        //each player is named and a rank is given to each player to be reorganised in a list of ordered players
        player[0]="Cristiano Ronaldo";
        print( player[0]);
        rank[0] = s.nextInt();

        player[1]="Lionel Messi";
        print( player[1]);
        rank[1] = s.nextInt();

        player[2]="Neymar Jr.";
        print(player[2]);
        rank[2] = s.nextInt();

        player[3]="Kylian Mbappé";
        print( player[3]);
        rank[3] = s.nextInt();

        player[4]="Mohamed Salah";
        print(player[4]);
        rank[4] = s.nextInt();

        player[5]="Gareth Bale";
        print( player[5]);
        rank[5] = s.nextInt();

        player[6]="Harry Kane";
        print( player[6]);
        rank[6] = s.nextInt();

        player[7]="Eden Hazard";
        print( player[7]);
        rank[7] = s.nextInt();

        player[8]="Paulo Dybala";
        print( player[8]);
        rank[8] = s.nextInt();

        player[9]="Steven Gerrard";
        print(player[9]);
        rank[9] = s.nextInt();

        print("Your top" + top + "players are: " );
        for (int n= 10-1;n>=0;n-- )//bubble sort algorithm
        {
            for (int m = 0; m<n; m++)
            {
                if (rank[m] > rank[m+1])//checks next array neighboring whether larger or smaller
                {
                    int swapTemp = rank[m+1];//swap arrays if smaller till sorted whole array
                    rank[m+1]= rank[m];
                    rank [m] = swapTemp;
                }
            }
            print(rank[n]+ ": " + player[n]);//print
        }

        return rank;
    }
    public static int[] basketballPlayers(int[]rank)
    {
        final int top = 10;//constant
        print("You can choose a value once and can't repeat the same rating");
        Scanner s = new Scanner(System.in);
        rank = new int[10];
        String []player = new String[10];

        //each player is named and a rank is given to each player to be reorganised in a list of ordered players
        player[0]="LeBron James";
        print(player[0]);
        rank[0] = s.nextInt();

        player[1]="Kevin Durant";
        print(player[1]);
        rank[1] = s.nextInt();

        player[2]="James Harden";
        print(player[2]);
        rank[2] = s.nextInt();

        player[3]="Chris Paul";
        print(player[3]);
        rank[3] = s.nextInt();

        player[4]="Kobe Bryant";
        print(player[4]);
        rank[4] = s.nextInt();

        player[5]="Stephen Curry";
        print(player[5]);
        rank[5] = s.nextInt();

        player[6]="Anthony Davis";
        print(player[6]);
        rank[6] = s.nextInt();

        player[7]="Russell Westbrook";
        print(player[7]);
        rank[7] = s.nextInt();

        player[8]="Kawhi Leonard";
        print(player[8]);
        rank[8] = s.nextInt();

        player[9]="Giannis Antetokounmpo";
        print(player[9]);
        rank[9] = s.nextInt();

        print("Your top" + top + "players are: " );
        for (int n= 10-1;n>=0;n-- )//bubble sort algorithm
        {
            for (int m = 0; m<n; m++)
            {
                if (rank[m] > rank[m+1])//checks next array neighboring whether larger or smaller
                {
                    int swapTemp = rank[m+1];//swap arrays if smaller till sorted whole array
                    rank[m+1]= rank[m];
                    rank [m] = swapTemp;
                }
            }
            print(rank[n]+ ": " + player[n]);//print
        }

        return rank;
    }

    public static int[] cricketPlayers(int []rank)
    {
        final int top = 10;//constant
        print("You can choose a value once and can't repeat the same rating");
        Scanner s = new Scanner(System.in);
        rank = new int[10];
        String[]player= new String[10];

        //each player is named and a rank is given to each player to be reorganised in a list of ordered players
        player[0] ="Virat Kohli";
        print(player[0]);
        rank[0] = s.nextInt();

        player[1]="Joe Root";
        print(player[1]);
        rank[1] = s.nextInt();

        player[2]="Ben Stokes";
        print(player[2]);
        rank[2] = s.nextInt();

        player[3]="David Warner";
        print(player[3]);
        rank[3] = s.nextInt();

        player[4] ="Rohit Sharma";
        print(player[4]);
        rank[4] = s.nextInt();

        player[5]="Ravichandran Ashwin";
        print(player[5]);
        rank[5] = s.nextInt();

        player[6]="K. L. Rahul";
        print(player[6]);
        rank[6] = s.nextInt();

        player[7]="Alex Hales";
        print(player[7]);
        rank[7] = s.nextInt();

        player[8]="Rashid Khan";
        print(player[8]);
        rank[8] = s.nextInt();

        player[9]="Adil Rashid";
        print(player[9]);
        rank[9] = s.nextInt();

        print("Your top" + top + "players are: " );
        for (int n= 10-1;n>=0;n-- )//bubble sort algorithm
        {
            for (int m = 0; m<n; m++)
            {
                if (rank[m] > rank[m+1])//checks next array neighboring whether larger or smaller
                {
                    int swapTemp = rank[m+1];//swap arrays if smaller till sorted whole array
                    rank[m+1]= rank[m];
                    rank [m] = swapTemp;
                }
            }
            print(rank[n]+ ": " + player[n]);//print
        }
        return rank;
    }

    public static int[] rugbyPlayers(int[] rank)
    {
        final int top = 10;//constant
        print("You can choose a value once and can't repeat the same rating");
        Scanner s = new Scanner(System.in);
        rank = new int[10];
        String [] player = new String[10];

        //each player is named and a rank is given to each player to be reorganised in a list of ordered players
        player[0]="Owen Farrell";
        print(player[0]);
        rank[0] = s.nextInt();

        player[1]="Alun Wyn Jones";
        print(player[1]);
        rank[1] = s.nextInt();

        player[2]="Beauden Barrett";
        print(player[2]);
        rank[2] = s.nextInt();

        player[3]="Israel Folau";
        print(player[3]);
        rank[3] = s.nextInt();

        player[4] ="Chris Robshaw";
        print(player[4]);
        rank[4] = s.nextInt();

        player[5]="Jonathan Sexton";
        print(player[5]);
        rank[5] = s.nextInt();

        player[6]="Tom Curry";
        print(player[6]);
        rank[6] = s.nextInt();

        player[7]="Billy Vunipola";
        print(player[7]);
        rank[7] = s.nextInt();

        player[8]="Maro Itoje";
        print(player[8]);
        rank[8] = s.nextInt();

        player[9]="Kieran Read";
        print(player[9]);
        rank[9] = s.nextInt();

        print("Your top" + top + "players are: " );
        for (int n= 10-1;n>=0;n-- )//bubble sort algorithm
        {
            for (int m = 0; m<n; m++)
            {
                if (rank[m] > rank[m+1])//checks next array neighboring whether larger or smaller
                {
                    int swapTemp = rank[m+1];//swap arrays if smaller till sorted whole array
                    rank[m+1]= rank[m];
                    rank [m] = swapTemp;
                }
            }
            print(rank[n]+ ": " + player[n]);//print
        }

        return rank;
    }
    public static int[] tennisPlayers(int [] rank)
    {
        final int top = 10;//constant
        print("You can choose a value once and can't repeat the same rating");
        Scanner s = new Scanner(System.in);
        rank = new int[10];
        String [] player = new String[10];

        //each player is named and a rank is given to each player to be reorganised in a list of ordered players
        player[0]="Roger Federer";
        print(player[0]);
        rank[0] = s.nextInt();

        player[1]="Andy Murray";
        print(player[1]);
        rank[1] = s.nextInt();

        player[2]="Novak Djokovic";
        print(player[2]);
        rank[2] = s.nextInt();

        player[3]="Rafael Nadal";
        print(player[3]);
        rank[3] = s.nextInt();

        player[4]="Serena Williams";
        print(player[4]);
        rank[4] = s.nextInt();

        player[5]="Caroline Wozniacki";
        print(player[5]);
        rank[5] = s.nextInt();

        player[6]="Nick Kyrgios";
        print(player[6]);
        rank[6] = s.nextInt();

        player[7]="Maria Sharapova";
        print(player[7]);
        rank[7] = s.nextInt();

        player[8]="Venus Williams";
        print(player[8]);
        rank[8] = s.nextInt();

        player[9]= "Stan Wawrinka";
        print(player[9]);
        rank[9] = s.nextInt();

        print("Your top" + top + "players are: " );
        for (int n= 10-1;n>=0;n-- )//bubble sort algorithm
        {
            for (int m = 0; m<n; m++)
            {
                if (rank[m] > rank[m+1])//checks next array neighboring whether larger or smaller
                {
                    int swapTemp = rank[m+1];//swap arrays if smaller till sorted whole array
                    rank[m+1]= rank[m];
                    rank [m] = swapTemp;
                }
            }
            print(rank[n]+ ": " + player[n]);//print
        }

        return rank;
    }
    public static int[] boxers(int[] rank)
    {
        final int top = 10;//constant
        print("You can choose a value once and can't repeat the same rating");
        Scanner s = new Scanner(System.in);
        rank = new int[10];
        String [] player = new String[10];

        //each player is named and a rank is given to each player to be reorganised in a list of ordered players
        player[0]="Roger Federer";
        print(player[0]);
        rank[0] = s.nextInt();

        player[1]="Andy Murray";
        print(player[1]);
        rank[1] = s.nextInt();

        player[2]="Novak Djokovic";
        print(player[2]);
        rank[2] = s.nextInt();

        player[3]="Rafael Nadal";
        print(player[3]);
        rank[3] = s.nextInt();

        player[4]="Serena Williams";
        print(player[4]);
        rank[4] = s.nextInt();

        player[5]="Caroline Wozniacki";
        print(player[5]);
        rank[5] = s.nextInt();

        player[6]="Nick Kyrgios";
        print(player[6]);
        rank[6] = s.nextInt();

        player[7]="Maria Sharapova";
        print(player[7]);
        rank[7] = s.nextInt();

        player[8]="Venus Williams";
        print(player[8]);
        rank[8] = s.nextInt();

        player[9]= "Stan Wawrinka";
        print(player[9]);
        rank[9] = s.nextInt();

        print("Your top" + top + "boxers are: " );
        for (int n= 10-1;n>=0;n-- )//bubble sort algorithm
        {
            for (int m = 0; m<n; m++)
            {
                if (rank[m] > rank[m+1])//checks next array neighboring whether larger or smaller
                {
                    int swapTemp = rank[m+1];//swap arrays if smaller till sorted whole array
                    rank[m+1]= rank[m];
                    rank [m] = swapTemp;
                }
            }
            print(rank[n]+ ": " + player[n]);//print
        }

        return rank;
    }


    public static String print(String print)//print method/for ease and speed when programming
    {
        System.out.println(print);
        return print;
    }//END print

    public static tvshows setGenre(tvshows t, String genre)//setter method (ADT) for tvShows;Genre
    {
        t.genre = genre;
        return t;
    }//END setGenre
    public static String getGenre(tvshows t)//getter method (ADT) for tvShows;Genre
    {
        return t.genre;
    }//END getGenre
    public static tvshows setRank(tvshows t, int rank)//setter method (ADT) for tvShows;Rank
    {
        t.rank = rank;
        return t;
    }//END setRank
    public static int getRank(tvshows t)//getter method (ADT) for tvShows;Rank
    {
        return t.rank;
    }//END getRank

    public static String bye(String bye)// Final method to say goodbye after either topic points
    {
        print("Bye!Have a nice rest of your day");
        return bye;
    }//END bye

}//END class chatbot

class tvshows// start class tvshows/ record Tv shows with empty structure
        //tvshows topic
{
    //Empty structure of this record type can be created and accessed via ADT
    String genre;
    int rank;
}//END class tvShows


