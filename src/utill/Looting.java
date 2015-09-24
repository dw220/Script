package utill;

import org.tbot.internal.handlers.LogHandler;
import org.tbot.methods.GroundItems;
import org.tbot.methods.Time;
import org.tbot.methods.combat.magic.Magic;
import org.tbot.methods.combat.magic.SpellBooks;
import org.tbot.methods.tabs.Inventory;
import org.tbot.wrappers.GroundItem;
import org.tbot.wrappers.Item;

import setup.C;

public class Looting {
	private String[] items;
	
	private int mithSq;
	private int runeScim;
	private int fireRune;
	private int bloodRune;
	private int chaosRune;
	private int runeArrow;
	
	public Looting(String[] items){
		this.items = items;
	}
	
	/**
	 * Start looting process
	 */
	public void start(){
		LogHandler.log("Looting componet");
		pickUp();
	}
	
	/**
	 * Start Alching items
	 */
	public void startAlch(){
		LogHandler.log("Starting Alching component");
		alch();
	}
	
	/**
	 * Check ground for items that can be looted
	 */
	public boolean checkGround(){
			GroundItem[] items = GroundItems.getLoaded();
			for(GroundItem i: items){
				String item = i.getName();
				if(C.southWest.contains(i)){
				if(item.equals("Rune scimitar") || item.equals("Fire battlestaff")|| item.equals("Mithril sq shield")
						|| item.equals("Rune arrow") || item.equals("Fire rune") || item.equals("Blood rune") || item.equals("Chaos rune")
						){
					LogHandler.log("Item found to alch: " + i.getName());
					return true;
				}
				}
			}
			return false;
	}
	
	/**
	 * Loot the items
	 */
	public void pickUp(){
		Eating e = new Eating();
		GroundItem[] items = GroundItems.getLoaded();
		for(GroundItem i: items){
			String item = i.getName();
			if(item.equals("Rune scimitar") || item.equals("Fire battlestaff")|| item.equals("Mithril sq shield")
					|| item.equals("Rune arrow") || item.equals("Fire rune") || item.equals("Blood rune") || item.equals("Chaos rune")){
					LogHandler.log("Item found to loot: " + i.getName() );
					i.interact("Take");
					Time.sleep(543,655);
				}
			} 
		}
	
	/**
	 * Alch items in inventory
	 */
	public void alch(){
		if(itemToAlch() != null){
			if(Magic.cast(SpellBooks.Modern.HIGH_LEVEL_ALCHEMY)){
				itemToAlch().interact("Cast High Level Alchemy");
				LogHandler.log("Alch has been done");
				Time.sleep(1234, 1344);
			}
		}
	}
	
	/**
	 * Check free slots in the players inventory
	 * @return
	 */
	public boolean hasRoom(){
		if (Inventory.getEmptySlots() == 0){
			LogHandler.log("Not enough room to loot");
			return false;
		}
		LogHandler.log("Enough room to loot");
		return true;
	}
	
	
	
	/**
	 * Check amount of bones in players inventory
	 */
	public boolean checkAmountBones(){
		if(Inventory.getCount("Big bones") <= 12){
			return true;
		}else
			return false;
	}
	
	
	/**
	 * Return item to alch
	 * @return
	 */
	public Item itemToAlch(){
		for (Item i : Inventory.getItems()) {
			String item = i.getName();
			if(item.equals("Rune scimitar") || item.equals("Fire battlestaff")|| item.equals("Mithril sq shield") ){
				LogHandler.log("Item found to alch: " + i.getName());
				return i;
			}
			
		}
		return null;
	}
	
}
