package utill;

import org.tbot.internal.handlers.LogHandler;
import org.tbot.methods.Camera;
import org.tbot.methods.GameObjects;
import org.tbot.methods.Npcs;
import org.tbot.methods.Players;
import org.tbot.methods.Time;
import org.tbot.methods.walking.Path;
import org.tbot.methods.walking.Walking;
import org.tbot.util.Filter;
import org.tbot.wrappers.GameObject;
import org.tbot.wrappers.NPC;

import setup.C;
import setup.Lambda;

public class Combat implements Lambda{
	private NPC giant;
	
	public Combat(){
		if(!onTile()){
			walkTile();
		}
	}
	
	public void start(){
			if(getGiant() != null){
				if(!getGiant().isOnScreen()){
					LogHandler.log("Moving Camera");
					Camera.turnTo(getGiant());
				}else{
					if( onTile() && getGiant()!=null )
					getGiant().interact("Attack");
				}
			} 
		if(!Players.getLocal().getLocation().equals(C.north)){
			walkTile();
			LogHandler.log("Not at safe spot walking back!");
		}
	}

	/**
	 * return a Fire giant for the player to attack.
	 * @return
	 */
	public NPC getGiant(){		
		NPC g = Npcs.getNearest(new Filter<NPC>(){
			@Override
			public boolean accept(NPC n) {
				if(n.getName().equals("Fire giant") && C.southWest.contains(n))
						if( !n.isHealthBarVisible())
					return true;
				
					return false;
			}
		});	
		return g;
	}

	
	/**
	 * Check if player is on north tile
	 */
	public boolean onTile(){
		if(Players.getLocal().getLocation().equals(C.north)){
			LogHandler.log("Player on correct safe spot");
			return true;
		}
		else 
			LogHandler.log("Player not on the correct spot");
			return false;
	}
	
	/**
	 * Move player to north tile
	 */
	public void walkTile(){
		Path p = Walking.findLocalPath(C.north);
			if(p !=null ){
				p.traverse();
				LogHandler.log("Moving player to north safe spot");
				Time.sleep(345, 655);
			}
	}

	@Override
	public void check() {
		// TODO Auto-generated method stub
		
	}
	
	
}
