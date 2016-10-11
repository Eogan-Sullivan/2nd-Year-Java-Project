/**
 * @(#)Item.java
 *
 *
 * @author Eogan Sullivan
 * @version 1.00 2015/12/2
 */


public class Item {

    private String name;
    private int damage;
    
    public Item() {
    	
    	name= "unknown";
    	damage = 0;
    }
    
    public Item(String name,int damage)
    {
    	this.name=name;
    	this.damage = damage;
    }
    
    public String getName()
    {
    	return name;
    }
    
    public int getDamage()
    {
    	return damage;
    }  
    	
    public void setName(String name)
    {
    	this.name=name;
    }
    
    public void setDamage(int damage)
    {
    	this.damage = damage;
    }
    
    
}