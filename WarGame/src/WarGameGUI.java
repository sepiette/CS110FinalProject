import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarGameGUI extends JFrame{
	//Declare Variables
	private JPanel gameContainer, leftTop, rightTop, leftBottom, 
   rightBottom, buttonBar, cardBar, winnerBar;
   
	private JButton flipButton, restartButton, exitButton;
   
	private ImageIcon userFront, userBack, compFront, compBack;
   
	private JLabel userPicBack, userPicFront, compPicBack, compPicFront, warBack1, warBack2;
   
	private JLabel userCards, compCards, winnerLabel;
   
	private WarGame war;
	
	public WarGameGUI()
	{
		//title JFrame
		super("Game of War");
		//Create a new War Game--the game guts
		war = new WarGame();
		
		//set layout of default container
		setLayout(new BorderLayout());
      
	   createPanels();
      createPanelLabels();
      createButtons();
      createImageIcons();
      addPanelsToFrames();
      addToMainFrame();	
		
	}
   /**
   *createPanels creates panels and panel containers
   */
   private void createPanels()
   {
      //create grid container for card panels
		gameContainer = new JPanel(new GridLayout(2,2));
		gameContainer.setSize(600,600);
		
		//create 4 top and bottom panels
		leftTop = new JPanel(new FlowLayout());
		rightTop = new JPanel(new FlowLayout());
		leftBottom = new JPanel(new FlowLayout());
		rightBottom = new JPanel(new FlowLayout());

		//create winner bar panel 
      winnerBar = new JPanel(new FlowLayout());
      winnerBar.setSize(700,100);
      
      //create card bar panel
		cardBar = new JPanel(new GridLayout(2,1));
		cardBar.setSize(100, 700);
      
      //create button bar panel
		buttonBar = new JPanel(new FlowLayout());

   }
   
   /**
   *createPanelLabels creates labels for winnerBar and cardBar panel
   */
   private void createPanelLabels()
   {
      //create label to display who wins each round
      winnerLabel = new JLabel();
      winnerLabel.setFont(new Font("Times",Font.BOLD,36));
      winnerBar.add(winnerLabel);

		//create card pile labels
		userCards = new JLabel();
		userCards.setText("User Cards:\n "+war.getUserNumCards());
		cardBar.add(userCards);
      
		
		compCards = new JLabel();
		compCards.setText("Computer Cards: \n "+war.getCompNumCards());
		cardBar.add(compCards);

   }
   
   /**
   *createButtons makes and activates JButtons for buttonBar panel 
   */
	private void createButtons()
   {
      //create flip button for user
		flipButton = new JButton("Flip Card");
		flipButton.addActionListener(new ButtonListener());
		buttonBar.add(flipButton);
		
		//create restartButton
		restartButton = new JButton("Restart");
		restartButton.addActionListener(new ResetListener());
		buttonBar.add(restartButton);
		
		//create Exit button
		exitButton = new JButton("Exit");
		exitButton.setForeground(Color.red);
		exitButton.addActionListener(new ExitListener());
		buttonBar.add(exitButton);

   }
   
   /**
   *createImageIcons creates all images and labels for images 
   *adds JLabels to frames
   */
   private void createImageIcons()
   {
      //create image icons
		userFront = null;
		userBack = new ImageIcon("/Users/sarapiette/Desktop/CS 110/cardpics/back.jpg");
		compFront = null;
		compBack = new ImageIcon ("/Users/sarapiette/Desktop/CS 110/cardpics/back.jpg");
      
      //create labels for image icons
		userPicFront = new JLabel();
      compPicFront = new JLabel();
		userPicBack = new JLabel(userBack);
		compPicBack = new JLabel(compBack);
      warBack1 = new JLabel();
      warBack2 = new JLabel();
      
      //add pictures to panels
		leftTop.add(userPicBack);
		leftBottom.add(compPicBack);
      rightTop.add(warBack1);
      rightBottom.add(warBack2);
		rightTop.add(userPicFront);
      rightBottom.add(compPicFront);

   }
   
   /**
   *adds subpanels to container panel
   */
   private void addPanelsToFrames()
   {
      //add all panels to proper frames
		gameContainer.add(leftTop);
		gameContainer.add(rightTop);
		gameContainer.add(leftBottom);
		gameContainer.add(rightBottom);
   }
   /**
   * adds all panels to main frame
   */
   private void addToMainFrame()
   {
      //add main container panels to large jFrame
		add(gameContainer, BorderLayout.CENTER);
		add(cardBar, BorderLayout.WEST);
		add(buttonBar, BorderLayout.NORTH);
      add(winnerBar, BorderLayout.SOUTH);
   }  
   
   
	/**
   *ButtonListener class implements methods for each card flip 
   *card flip activated by flipButton 
   */
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
         if (war.gameOver()==false)
         {
                  //set the text of each  card pile number based on winner
                  userCards.setText("User Cards:\n "+war.getUserNumCards());
         			compCards.setText("Computer Cards: \n "+war.getCompNumCards());
         			
                  //determine whether or not war cards must be laid out
                  if (war.getRoundWinner() == -1)
                  {  
                     warBack1.setIcon(userBack);
                     warBack2.setIcon(compBack);
                  }
                  else
                  {
                     warBack1.setIcon(null);
                     warBack2.setIcon(null);
                  }
                  
         			//flip the next card in each pile 
         			war.flipCard();
                  
                  //change the card icons
                  userFront = war.getUserCard().getIcon();
         			compFront = war.getCompCard().getIcon();
         
                  userPicFront.setIcon(userFront);
         			compPicFront.setIcon(compFront);
                  
                  //compare cards to determine winner
                  war.compareCards();
                           
                  if (war.getRoundWinner() == 1)
                  {
                     winnerLabel.setForeground(Color.green);
                     winnerLabel.setText("User wins round");
                     
                  }
                  else if(war.getRoundWinner() == 0)
                  {
                     winnerLabel.setForeground(Color.red);
                     winnerLabel.setText("Computer wins round");
                     
                  }
                  else if (war.getRoundWinner() == -1)
                  {
                     winnerLabel.setForeground(Color.black);
                     winnerLabel.setText("It's a War!");
                     
                  }
          }
          else if(war.gameOver() == true)
          {
                if (war.getRoundWinner() == 1)
                  {  
                     winnerLabel.setForeground(Color.blue);
                     winnerLabel.setText("Game over. User Wins!");
                     disableFlip();
                  }
                else if(war.getRoundWinner() == 0)
                  {
                     winnerLabel.setForeground(Color.blue);
                     winnerLabel.setText("Game over. Computer Wins.");
                     disableFlip();
                  }
          }
		}
      /**
      * disable flip method inactivates flipButton 
      * when one player runs out of cards--initiates game's end
      */
      public void disableFlip()
      {
         flipButton.setEnabled(false);
      }
	}
   
   
   /**
   * ExitListener class implements methods associated when exitButton activated
   * closes entire program
   */
	private class ExitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
   /**
   * ResetListener class implements methods for restartButton
   * starts a new game of war when clicked.
   */
	private class ResetListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			   war = new WarGame();
		
      		//set layout of default container
      		setLayout(new BorderLayout());
            
      	   createPanels();
            createPanelLabels();
            createButtons();
            createImageIcons();
            addPanelsToFrames();
            addToMainFrame();	

		}
	}
}
