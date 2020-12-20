import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
public class DogCollection {
    public static ArrayList<String> Arr = new ArrayList<String>();
    public static String breed(String args) {
        for (String i : Arr) {
            if (i.equals(args)) {
                return "The breed was already in the collection";
            }
        }
        Arr.add(args);
        return "The breed has been added to the collection";
    }
    public static void printer() {
        System.out.println("\r\n    Collection:");
        for (String i : Arr) {
            System.out.println("\r\n        " + i);
        }
        System.out.println("");
    }
    public static String input(String s) {
        Scanner sc = new Scanner(System.in);
        System.out.print(s);
        String str = sc.nextLine();
        if (s.equals("Finished Adding to collection (y/n)? ")) {
            if (str.equals("y")) {
                sc.close();
            }
        }
        return str;
    }
    public static void main(String[] args) throws IOException {
        try {
        ArrayList<String> list = new ArrayList<String>();
        File myObj = new File("/Users/tord/code/java/test/lib/stored.txt");
        Scanner scanner = new Scanner(myObj);
        while(scanner.hasNextLine()){
            String input = scanner.nextLine();
            list.add(input);
        }
        scanner.close();
        for(String i : list){
            Arr.add(i);
        }
        if(Arr.size() == 0){
        System.out.println("The Collection is empty");
        } else {
            System.out.println("The Collection is not empty");
        }
        } catch(Exception e) {
            System.out.println("The Collection is empty");
        }
        while(true) {
            String str = input("Enter a Breed for your collection: ");
            System.out.println(DogCollection.breed(str));
            
            String str2 = input("Do you want to see the collection (y/n)? ");
            if(str2.equals("y")) {
                printer();
            }
            String str3 = input("Finished Adding to collection (y/n)? ");
            
            if(str3.equals("y")) {
                try {
                FileWriter myWriter = new FileWriter("/Users/tord/code/java/test/lib/stored.txt");
                for(String i : Arr) {
                    myWriter.write(i+"\n");
                }
                myWriter.close();
                System.out.println("The Collection has been stored!");
                break;
                } catch(Exception e) {
                System.out.println("The Collection could not be stored");
                }
            }
        }
    }
}
