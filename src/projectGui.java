/**
 * @(#)TestGui.java
 *
 *
 * @author Eogan Sullivan
 * @version 1.00 2015/12/3
 */

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class projectGui  extends JFrame  {

   private JMenu myMenu,saveMenu;
   private JMenuBar myMenuBar;
   private Player player1,enemy;
   private JPanel myPanel,panel2;
   private JButton performAction,closeProg;
   private JTextField playerInput;
   private JLabel playerImage,playUsername;
   private JTextArea textPane;
   private JScrollPane myScroll;
   private File saveFile1;

  
   
   private Item startItem;
   private Chest chest1;

    public projectGui(){
    	
      //add my Class objects
      player1 = new Player();
      enemy = new Player();
      startItem = new Item ();
      chest1 = new Chest();
 
      
      //initalize JTextField
      playerInput = new JTextField();
      
    	//Set Frame
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\resources\\myicon.png"));
		setTitle("Dungeon Master");
		setBounds(100, 100, 410, 270);
		setSize(410,270);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		// Panel Editing
		myPanel = new JPanel();
		myPanel.setBounds(112, 0, 284, 33);
		add(myPanel);
		
		panel2 =  new JPanel();
		panel2.setBounds(0, 0, 111, 212);
		add(panel2);
		
		//adding the scrolling text Pane
	    textPane = new JTextArea();
	    textPane.setBounds(122, 36, 262, 163);
	    myScroll = new JScrollPane(textPane);
	    myScroll.setBounds(122, 36, 262, 163);
	    myScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        myScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    add(myScroll);
		
		//adding player1 image
		 playerImage = new JLabel();
		 playerImage.setIcon(new ImageIcon("C:\\resources\\player1_m.png"));
		 panel2.add(playerImage);
		
		 //adding player username under image
		 playUsername = new JLabel("Enter Username");
		 panel2.add(playUsername);
		
		//adding to Menu/MenuBar
		myMenu = new JMenu("Character");
		saveMenu = new JMenu("File");
		JMenuItem editUserName = new JMenuItem("Change Username");
		JMenuItem changeGender = new JMenuItem("Change Gender");
		JMenuItem openFile = new JMenuItem("Open");
		JMenuItem saveFile = new JMenuItem("Save");
		myMenu.add(editUserName);
		myMenu.add(changeGender);
		saveMenu.add(openFile);
		saveMenu.add(saveFile);
	
	   //adding to Menu/MenuBar
		myMenuBar = new JMenuBar();
		myMenuBar.add(myMenu);
		myMenuBar.add(saveMenu);
	
	    //Add menuBar to Frame
		 setJMenuBar(myMenuBar);
		  
		 // JTextField
		 playerInput.setText("Enter Command ");
		 myPanel.add(playerInput);
		 
		 //initalize and add JButton
		 performAction = new JButton();
		 closeProg = new JButton();
		 performAction.setText("Do This");
		 closeProg.setText("Close");
		 myPanel.add(performAction,BorderLayout.CENTER);
		 myPanel.add(closeProg,BorderLayout.CENTER);
	
		 	
		 	
		 	//Adding Action Listeners
		 	editUserName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			player1.setUsername(JOptionPane.showInputDialog("Enter Username"));
			 playUsername.setText(player1.getName());
			 playerInput.setText("Enter Command ");
			 textPane.append(player1.getName()+" has entered the dungeon\n "
			 		+ "A door is infront of them \n "
			 		+  "What will they do?\n");
		 
			}
		});
		 	
		 	changeGender.addActionListener(new ActionListener(){
		 		public void actionPerformed(ActionEvent e){
		 			String gender = JOptionPane.showInputDialog("Enter Desired Gender");
		 			if(gender.equalsIgnoreCase("male")){
		 				playerImage.setIcon(new ImageIcon("H:\\resources\\player1_m.png"));}
		 				else if(gender.equalsIgnoreCase("female"))
		 				{
		 				playerImage.setIcon(new ImageIcon("H:\\resources\\player1_f.png"));}
		 			}
		 	});
		
			closeProg.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
				System.exit(0);
				}
				
			});
			
			
			saveFile.addActionListener(new ActionListener(){
				private PrintWriter mywriter;
				public void actionPerformed(ActionEvent e){
					String mySave = JOptionPane.showInputDialog(null,"Enter name of Save File");
					saveFile1 = new File(mySave+".txt");
					try {
						mywriter = new PrintWriter(saveFile1);
						mywriter.write(textPane.getText());
						mywriter.close();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			});
			
			openFile.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String fileName = JOptionPane.showInputDialog("Enter Filename");
				try {
					FileReader myFileReader = new FileReader(fileName+".txt");
					textPane.read(myFileReader,fileName+".txt");
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			});
			
			
		performAction.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				getInput();
			}
		});
				   
 

    }
    
    
    
    public void getInput()
    {
    	String input = playerInput.getText();
    	String output = "";
    	if (input.equalsIgnoreCase("Enter Room")||input.equalsIgnoreCase("Open Door"))
    	{
    		output =player1.getName() +" has entered a room.\n"
    				+ "An Enemy Goblin has spotted you\n"
    				+ "You have spotted a chest\n"; 
    		textPane.append(output);
    	}
    	
    	else if(input.equalsIgnoreCase("Leave Room"))
    	{
    		output = player1.getName()+" has left the room.\n";
    		textPane.append(output);
    	}
    	
    	else if(input.equalsIgnoreCase("Attack Enemy"))
    	{
    		if(enemy.getHealth()>0 && player1.getHealth()>0 )
    		{
    		playerAttack();
    		enemyAttack();
    		}
    		else if(player1.getHealth()<=0)
    		{
    		   textPane.append("GAME OVER\n");	
    		}
    	}
    	
    	else if(input.equalsIgnoreCase("Open Chest"))
    	{
    		openChest();
    	}
    	
    	else
    		textPane.append("Invalid Input\n");
    }
    
    public void playerAttack()
    {
       if(player1.getItemName()== "Unknown")
       {
       startItem.setDamage(1);
       enemy.setHealth(enemy.getHealth()- startItem.getDamage());
       String enemyHealth = enemy.getHealth() + ": Goblins Health.\n";
       textPane.append(enemyHealth);
    }
       else if(player1.getItemName() == "Sword")
       {
    	   enemy.setHealth(enemy.getHealth()- player1.getItem().getDamage());
           String enemyHealth = enemy.getHealth() + ": enemys Health.\n";
           textPane.append(enemyHealth);
           if(enemy.getHealth()==0)
           {
        	   textPane.append("Goblin is Dead\n");
        	   if(enemy.getHealth()<0)
        	   		textPane.append("You Have Won\n");
           }
       }
       
       
    }
    
    public void enemyAttack()
    {
         Item enemyItem = new Item("Axe",10);

    		player1.setHealth(player1.getHealth()-enemyItem.getDamage());
    		String playHealth =  player1.getName() +"'s remaining health: "+ player1.getHealth() +"\n";
    		textPane.append(playHealth);
    }
    
    public void openChest()
    {
    	Item sword1= new Item("Sword",15);
    	chest1.setChestItem(sword1);
    	textPane.append(player1.getName()+" opened the chest\n");
    	textPane.append(player1.getName()+" took an item:"+sword1.getName() +"\n");
    	player1.setItem(sword1);
    	
    	
    }
    
    
    public static void main(String []args)
    {
    	 projectGui myGui = new projectGui();
    	myGui.setVisible(true);
    }
}
    
    
