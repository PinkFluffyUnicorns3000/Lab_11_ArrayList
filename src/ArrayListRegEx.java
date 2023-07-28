import java.util.Scanner;
import java.util.ArrayList;


public class ArrayListRegEx {
    public static void main(String[] args){

        ArrayList<String> myArrList = new ArrayList<>();
        boolean done = false;
        Scanner in = new Scanner(System.in);
        System.out.println("\nWelcome to list maker enter your option below:");

        do{
            String userInput = SafeInput.getRegExString(in,"A - add : D - delete : " +
                    "P : print : Q - Quit","[AaDdPpQq]");
            userInput = userInput.toUpperCase();

            switch(userInput){
                case "A":
                    myArrList.add(SafeInput.getNonZeroLenString(in,"What would you like to add?"));
                    break;
                case "D":
                    for(int x = 0; x < myArrList.size(); x++){
                        System.out.println(x + ": " + myArrList.get(x));
                    }
                    if(myArrList.size() == 0){
                        System.out.println("The list is empty...");
                        break;
                    }
                    int index = SafeInput.getRangedInt(in, "What item would you like to remove?",
                            0, myArrList.size()-1);
                    myArrList.remove(index);
                    break;
                case "P":
                    System.out.println(" ");
                    for(String f : myArrList){
                        System.out.println(f);
                    }
                    break;
                case "Q":
                    boolean confirm = SafeInput.getYNConfirm(in,"Are you sure you wat to quit?");
                    if(confirm) {
                        done = true;
                    }
                    break;
            }
        }while(!done);
    }
}
