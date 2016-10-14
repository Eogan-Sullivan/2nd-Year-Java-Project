/**
 * @(#)Chest.java
 *
 *
 * @author Eogan Sullivan
 * @version 1.00 2015/12/2
 */
//upload test

public class Chest {
 
 private boolean locked;
 private Item chestItem;
 
 
    public Chest() {
    	locked = false;
    	chestItem = new Item();
    }
    
    public Chest(boolean locked,Item chestItem)
    {
    	this.locked = locked;
    	this.chestItem = chestItem;
    }
    
    public Item getChestItem()
    {
    	return chestItem;
    }
    
    public boolean isLocked()
    {
    	return locked;
    }
    
    public void setLocked(boolean locked)
    {
    	this.locked = locked;
    }
    
    public void setChestItem(Item chestItem)
    {
    	this.chestItem = chestItem;
    }
    
}