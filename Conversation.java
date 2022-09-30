import java.util.Random;
import java.util.Scanner;
import java.util.*; 

public class Conversation {
 
  public static void main(String[] arguments) {
    /** Created an array of canned respones. Then created an array list for the transcript. */
    String [] answers = {"Tell me more", "Sounds interesting", "Hmmm","How are you doing?","Well I wish you luck"};
    ArrayList <String> transcript = new ArrayList<String>();

    /**  Start the conversation here by asking rounds of conversations. Created a scanner that takes in the user input. */
    Scanner input = new Scanner(System.in);
    
    /**  Asks user how many rounds they want, then declare a variable that takes the user input (int) */
    System.out.print("How many rounds of conversation do you want to have?");
    int numRounds  = input.nextInt();
    input.nextLine();

    /** Print statement that asks the user a question */
    System.out.println("Great! What do you want to talk about?");
    transcript.add("Great! What do you want to talk about?");


    Random  rand = new Random();
     
    /** Uses a while loop to check if the number of rounds have been satisfied. 
     * Takes the User Input and stores it in a varibale.Uses this variable to add their 
     * input to a transcript. Checks for mirror words in the user input and changes them 
     * or generated a random response.
    */
    while (numRounds > 0 ){
      String personRes= input.nextLine();
      transcript.add(personRes);
      int flag = 0;
     
      if (personRes.contains("my")){ 
        personRes = personRes.replace("my", "your");
        flag = 1;
  
      }
      else if (personRes.contains("your")){
        personRes = personRes.replace("your", "my");
        flag = 1;
      }
      if (personRes.contains("i ")){//problem when i is last letter in word1
        personRes = personRes.replace("i", "you");
        flag = 1; 
      }
      else if (personRes.contains("you")){
        personRes = personRes.replace("you", "i");
        flag = 1; 
      }
      if (personRes.contains("me")){
        personRes= personRes.replace("me", "you");
        flag = 1;  
      }
      if(personRes.contains("am")){
        personRes = personRes.replace("am", "are");
        flag = 1;  
      }
      if (flag == 0){
        int index = rand.nextInt(answers.length);
        System.out.println(answers[index]);
        transcript.add(answers[index]);
      }
      if (flag == 1){
        System.out.println(personRes); 
        transcript.add(personRes); 
      }
        
      numRounds -= 1;
      
    }
    
    System.out.println("Bye! Great having a conversation with you");
    transcript.add("Bye! Great having a conversation with you");
    System.out.print(transcript);
    input.close();

  }
}
