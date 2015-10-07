import java.util.Scanner;

public class Main{
    public static void main (String[] args){
        Tasks taskList = new Tasks();
        Scanner in = new Scanner(System.in);
        
        boolean shouldCont = true;
        while (shouldCont){
            shouldCont = ProcessInput.interpretInput(taskList, in);
        }
    }
}
