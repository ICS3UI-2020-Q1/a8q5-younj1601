import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JLabel introLabel;
  JLabel answerLabel;

  JTextField guessInput;

  JButton submitButton;
  JButton restartButton;

  Random rand = new Random();
  //create random number
  int randNum = rand.nextInt(100) + 1;

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
 
    //initialize the main panel 
    mainPanel = new JPanel();
    //disable layout helpers
    mainPanel.setLayout(null);

    

    //create labels
    introLabel = new JLabel("Guess the number between 0 and 100:");
    answerLabel = new JLabel();

    //set the location and size of labels
    introLabel.setBounds(150,150,300,20);
    answerLabel.setBounds(150,270,300,20);

    //create text field 
    guessInput = new JTextField();

    //set the location and size of the text field 
    guessInput.setBounds(150,190,300,20);

    //create buttons
    submitButton = new JButton("Submit");
    restartButton = new JButton("New Number");

    //set the location and size of the buttons
    submitButton.setBounds(150,230,100,20);
    restartButton.setBounds(260,230,190,20);

    //add action listener to buttons
    submitButton.addActionListener(this);
    restartButton.addActionListener(this);

    //set action command to buttons
    submitButton.setActionCommand("submit");
    restartButton.setActionCommand("new number");

    //add labels to the panel 
    mainPanel.add(introLabel);
    mainPanel.add(answerLabel);

    //add text field to the panel
    mainPanel.add(guessInput);

    //add the buttons to the panel
    mainPanel.add(submitButton);
    mainPanel.add(restartButton);

    //add the mainPanel to the frame
    frame.add(mainPanel);
    
    
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    if(command.equals("new number")){
      //create new random number
      randNum = rand.nextInt(100) + 1;

      //erase previous guess
      guessInput.setText("");
      answerLabel.setText("");
    }

    if(command.equals("submit")){
    
      //get the text from the text field
      String firstText = guessInput.getText();
      //convert text into integer
      int guess = Integer.parseInt(firstText);

      if(guess > randNum){
        answerLabel.setText("Your guess of " + guess + " is too high!");
      }else if(guess < randNum){
        answerLabel.setText("Your guess of " + guess + " is too low!");
       }else if(guess == randNum){
         answerLabel.setText("Your guess of " + guess + " is correct!");
       }
      }
    
    
      
    

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
