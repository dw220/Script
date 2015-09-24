package utill;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import org.tbot.bot.TBot;
import org.tbot.client.Widget;
import org.tbot.graphics.SkillPaint;
import org.tbot.internal.AbstractScript;
import org.tbot.internal.Manifest;
import org.tbot.internal.event.listeners.PaintListener;
import org.tbot.internal.handlers.LogHandler;
import org.tbot.methods.Bank;
import org.tbot.methods.Camera;
import org.tbot.methods.Game;
import org.tbot.methods.GameObjects;
import org.tbot.methods.Menu;
import org.tbot.methods.Mouse;
import org.tbot.methods.Npcs;
import org.tbot.methods.Players;
import org.tbot.methods.Random;
import org.tbot.methods.Skills;
import org.tbot.methods.Skills.Skill;
import org.tbot.methods.Time;
import org.tbot.methods.Widgets;
import org.tbot.methods.combat.magic.Magic;
import org.tbot.methods.combat.magic.Spell;
import org.tbot.methods.combat.magic.SpellBooks;
import org.tbot.methods.tabs.Inventory;
import org.tbot.methods.walking.Path;
import org.tbot.methods.walking.Walking;
import org.tbot.methods.web.banks.WebBank;
import org.tbot.util.Condition;
import org.tbot.util.Filter;
import org.tbot.wrappers.Area;
import org.tbot.wrappers.GameObject;
import org.tbot.wrappers.Item;
import org.tbot.wrappers.Locatable;
import org.tbot.wrappers.NPC;
import org.tbot.wrappers.Tile;
import org.tbot.wrappers.Timer;

import setup.C;

/**
 * Created by home on 27/07/15.
 */
@Manifest(name = "DazGiants", authors = "dazsta", version = 1.0)
public class Main extends AbstractScript implements PaintListener {
	private Combat combat;
	private Looting looting;
	private long startTime;
	private long startXp;
	private Eating eating;
	/**
	 * Different states the bot can be in.
	 * @author home
	 *
	 */
	static enum Action {
		SLEEP, COMBAT, IDLE, ALCH, LOOT, WALK, CASTSPELL, EAT;
	}


	/**
	 * return the current action the bot should do
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public Action getAction() {
		Action state = Action.IDLE;
		if( !combat.onTile() && Players.getLocal().getInteractingEntity() != null && !looting.checkGround() )
			return Action.WALK;
		if( eating.getHealth() < 30 && eating.hasPeaches() )
			return Action.EAT;
		if(Players.getLocal().getInteractingEntity() != null)
			return Action.SLEEP;
		if(eating.hasBones() && !looting.checkAmountBones())
			return Action.CASTSPELL;
		if(looting.itemToAlch() != null && Players.getLocal().getInteractingEntity() == null && !Players.getLocal().isHealthBarVisible())
			return Action.ALCH;
		if(looting.checkGround() && Players.getLocal().getInteractingEntity() == null && looting.hasRoom() && !Players.getLocal().isHealthBarVisible())
			return Action.LOOT;
		if(Players.getLocal().getInteractingEntity() == null && !looting.checkGround())//// added check ground before work
			return Action.COMBAT;
		return state;
	}

	@Override
	public boolean onStart() {		
		Mouse.setSpeed(Random.nextInt(18, 23));
		this.startTime = System.currentTimeMillis();
		this.startXp   = Skills.getExperience(Skill.RANGED);
		combat 	= new Combat();
		looting = new Looting(C.loot);
		eating  = new Eating();
		
		return true;
	}


	/**
	 * Do the current action in here.
	 */
	public int loop() {
		switch (getAction()) {
		case WALK:
			combat.walkTile();
			break;
		case SLEEP:
			Time.sleep(2134, 2444);
			break;
		case COMBAT:
			combat.start();
			break;
		case ALCH:
			looting.alch();;
			break;
		case LOOT:
			looting.pickUp();
			break;
		case CASTSPELL:
			eating.makePeaches();
			break;
		case EAT:
			eating.eatPeaches();
		default:
			break;
		}
		return Random.nextInt(133, 190);
	}

	@Override
	public void onRepaint(Graphics g1) {
		long xpGained= (Skills.getExperience(Skill.RANGED) - startXp);
		Long xp = Math.round(xpGained * 3600000D / (System.currentTimeMillis() - startTime));
		Graphics2D g = (Graphics2D) g1;
		g.setFont(new Font("Serif", Font.BOLD, 25));
		g.setColor(Color.BLACK);
		g.drawString("---DFireGiants---", 170, 380);
		g.setFont(new Font("Serif", Font.BOLD, 20));
		g.drawString( "Time Running: " + getFormattedTime(System.currentTimeMillis() - startTime), 170, 400);
		g.drawString("xp p/h: " + xp, 170, 415);
		//---------------------------------------//
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Serif", Font.BOLD, 20));
		g.drawString("	---Items Looted---", 10, 15);
		g.drawString("	Scimmys looted	: ", 10, 30);
		g.drawString("	Rune arrows		: ", 10, 45);
		g.drawString("	Mith sq			:" , 10, 60);
		g.drawString("	Fire runes		:", 10, 75);
		g.drawString("	chaos runes		:", 10, 90);
		g.drawString("	blood runes		:", 10, 105);
		g.drawString("	Dragon med		:", 10, 120);
		g.drawString("	Shield left		:", 10, 135);




	}
	

	private String getFormattedTime(final long timeMillis) {
		long millis 			= timeMillis;
		final long seconds2	 	= millis / 1000;
		final long hours 		= millis / (1000 * 60 * 60);
		millis 					-= hours * 1000 * 60 * 60;
		final long minutes 		= millis / (1000 * 60);
		millis 					-= minutes * 1000 * 60;
		final long seconds 		= millis / 1000;
		String hoursString 		= "";
		String minutesString 	= "";
		String secondsString 	= seconds + "";
		String type 			= "seconds";

		if (minutes > 0) {
			minutesString 	= minutes + ":";
			type 			= "minutes";
		} 
		else if (hours > 0 && seconds2 > 0) {
			minutesString 	= "0:";
		}
		if (hours > 0) {
			hoursString = hours + ":";
			type = "hours";
		}
		if (minutes < 10 && !type.equals("seconds")) {
			minutesString = "0" + minutesString;
		}
		if (hours < 10 && type.equals("hours")) {
			hoursString = "0" + hoursString;
		}
		if (seconds < 10 && !type.equals("seconds")) {
			secondsString = "0" + secondsString;
		}
		if (timeMillis == 1000) {
			type = "second";
		} else if (timeMillis == 60000) {
			type = "minute";
		} else if (timeMillis == 3600000) {
			type = "hour";
		}
		return hoursString + minutesString + secondsString;
	}



}
