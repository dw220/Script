package utill;

import org.tbot.internal.handlers.LogHandler;
import org.tbot.methods.Players;
import org.tbot.methods.Time;
import org.tbot.methods.tabs.Inventory;
import org.tbot.wrappers.Item;

import setup.Lambda;

public class Eating implements Lambda{
	private String food;
	
	/**
	 * Cast bones to peaches spell
	 */
	public void makePeaches(){
		if(hasTabs() && hasBones()){
			if(getTab().interact("Break")){
				LogHandler.log("Bones to peaches has been cast.");
			} else
				LogHandler.log("Spell hasn't been cast");
		}
	}
	
	/**
	 * Cast bones to peaches spell
	 */
	public void eatPeaches(){
		if(hasPeaches()){
			if(getPeache().interact("Eat")){
				Time.sleep(333, 435);
				LogHandler.log("Peach has been eaten");
			} else
				LogHandler.log("Peach hasn't been eaten");
		}
	}
	/**
	 * Get tab to cast on bones
	 */
	public Item getTab(){
		return Inventory.getItem("Bones to peaches");
	}
	
	/**
	 * Get tab to cast on bones
	 */
	public Item getPeache(){
		return Inventory.getItem("Peach");
	}
	
	/**
	 * Check if player has bones to peaches tabs in inventory
	 */
	public boolean hasPeaches(){
		if(Inventory.contains("Peach"))
			return true;
		else 
			return false;
	}
	
	/**
	 * Check if player has bones to peaches tabs in inventory
	 */
	public boolean hasTabs(){
		if(Inventory.contains("Bones to peaches"))
			return true;
		else 
			return false;
	}
	
	/**
	 * Check if player has bones
	 */
	public boolean hasBones(){
		if(Inventory.contains("Big bones"))
			return true;
		else 
			return false;
	}
	
	/**
	 * Return the current players health percent
	 */
	public int getHealth(){
		return Players.getLocal().getHealthPercent();
	}

	@Override
	public void check() {
		
		
	}
}
