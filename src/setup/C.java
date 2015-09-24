package setup;

import java.util.ArrayList;

import org.tbot.methods.combat.magic.SpellBooks;
import org.tbot.wrappers.Area;
import org.tbot.wrappers.Tile;

/**
 * Different variables/Areas/Tiles used by the script, this
 * should not be changed under any circumstances.
 * @author Dazsta
 *
 */
public class C {
	public static final Area northEast 	= new Area(new Tile[]  {new Tile(2571,9887,0),new Tile(2566,9886,0),new Tile(2566,9890,0),new Tile(2569,9890,0)});
	public static final Area southWest 	= new Area(new Tile[]  {new Tile(2560,9887,0),new Tile(2563,9890,0),new Tile(2567,9888,0),new Tile(2567,9884,0),new Tile(2562,9884,0)});
	public static final String[] loot 	= 
		{"Fire rune", "Blood rune", "Chaos rune", "Rune arrow",
		 "Rune scimitar", "Shield left half", "Dragon med helm"};
	public static final String[] inventory 	= 
		{"Fire rune", "Blood rune", "Chaos rune", "Rune arrow",
		 "Rune scimitar", "Shield left half", "Dragon med helm", "Nature rune", "Camelot teleport", "Bones to peaches",
		 "Rope", "Big bones", "Peach", "Coins", "Iron arrow"};
	
	public static final Tile west		= new Tile(2565,9889,0);
	public static final Tile north		= new Tile(2566,9890,0);
	public static final Tile door		= new Tile(2568,9893,0);
	
	public static final String arrows	= "Iron arrows";
	public static final String npc		= "Fire giant";
	public static final String food		= "Lobster";

}
