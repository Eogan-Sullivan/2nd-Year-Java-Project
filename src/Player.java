/**
 * @(#)player.java
 *
 *
 * @author Eogan Sullivan
 * @version 1.00 2015/11/18
 */


public class  Player {
	
	private String username;
	private int health;
	private Item playItem;
    
	/**
	 *  initializes Player object
	 */
    public Player() {
    
    	username = "Unknown";
    	playItem = new Item();
    	health = 100;
    }
    /**
     * 
     * @param Username sets the player objects username
     */
     public Player(String username){
    	setUsername(username);
    	
    }
     /**
      * 
      * @return string of players username
      */
    public String getName(){
    	return username;
    }
    /**
     * 
     * @param username sets the username ofthe player object
     */
    public void setUsername(String username){
         this.username=username;
    }
    
    /*
     *  @return the health of the player
     */
    public int getHealth(){
    	return health;
    }
    /**
     * 
     * @param health sets the health of the player to this variable
     */
    public void setHealth(int health){
    	this.health = health;
    }
    	/**
    	 * 
    	 * @param playItem sets the Item for the player
    	 */
    public void setItem(Item playItem)
    {
    	this.playItem = playItem;
    }
    
    /*
     * 
     * @return gets the Item for the player
     */
    public Item getItem()
    {
     return  playItem;

    }
    /**
     * 
     * @return the name of the players Item
     */
    public String getItemName()
    {
    	return playItem.getName();
    }
    	
    }
  
