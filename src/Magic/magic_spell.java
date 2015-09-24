package Magic;

public interface magic_spell {
	public interface Spell {
	    int LUNAR_PARENT_INDEX = 430;
	    int MODERN_PARENT_INDEX = 192;

	    /**
	     * @return The parent index of the Interface
	     */
	    int getParentIndex();

	    /**
	     * @return The InterfaceChild index of the spell
	     */
	    int getChildIndex();

	    /**
	     * @return The level required to cast the spell
	     */
	    int getLevel();
	}
}
