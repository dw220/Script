package Magic;

import org.tbot.methods.combat.magic.Spell;
import org.tbot.methods.combat.magic.SpellBooks.SpellBook;
import org.tbot.util.requirements.RunePowerRequirement;



	public final class Spellbooks {

	    /**
	     * Credits to TheScrub for the required level info
	     */
	    public enum Modern implements Spell {
	        HOME_TELEPORT(0),
	        WIND_STRIKE(1),
	        CONFUSE(3),
	        ENCHANT_CROSSBOW_BOLT(4),
	        WATER_STRIKE(5),
	        LVL_1_ENCHANT(7),
	        EARTH_STRIKE(9),
	        WEAKEN(11),
	        FIRE_STRIKE(13),
	        BONES_TO_BANANAS(15),
	        WIND_BOLT(17),
	        CURSE(19),
	        BIND(20),
	        LOW_LEVEL_ALCHEMY(21),
	        WATER_BOLT(23),
	        VARROCK_TELEPORT(25),
	        LVL_2_ENCHANT(27),
	        EARTH_BOLT(29),
	        LUMBRIDGE_TELEPORT(31),
	        TELEKINETIC_GRAB(33),
	        FIRE_BOLT(35),
	        FALADOR_TELEPORT(37),
	        CRUMBLE_UNDEAD(39),
	        HOUSE_TELEPORT(40),
	        WIND_BLAST(41),
	        SUPERHEAT_ITEM(43),
	        CAMELOT_TELEPORT(45),
	        WATER_BLAST(47),
	        LVL_3_ENCHANT(49),
	        IBAN_BLAST(50),
	        SNARE(50),
	        MAGIC_DART(50),
	        ARDOUGNE_TELEPORT(51),
	        EARTH_BLAST(53),
	        HIGH_LEVEL_ALCHEMY(55),
	        CHARGE_WATER_ORB(56),
	        LVL_4_ENCHANT(57),
	        WATCHTOWER_TELEPORT(58),
	        FIRE_BLAST(59),
	        CHARGE_EARTH_ORB(60),
	        BONES_TO_PEACHES(60),
	        SARADOMIN_STRIKE(60),
	        CLAWS_OF_GUTHIX(60),
	        FLAMES_OF_ZAMORAK(60),
	        TROLLHEIM_TELEPORT(61),
	        WIND_WAVE(62),
	        CHARGE_FIRE_ORB(63),
	        TELEPORT_TO_APE_ATOLL(64),
	        WATER_WAVE(65),
	        CHARGE_AIR_ORB(66),
	        VULNERABILITY(66),
	        LVL_5_ENCHANT(68),
	        EARTH_WAVE(70),
	        ENFEEBLE(73),
	        TELEOTHER_LUMBRIDGE(74),
	        FIRE_WAVE(75),
	        ENTANGLE(79),
	        STUN(80),
	        CHARGE(80),
	        TELEOTHER_FALADOR(82),
	        TELE_BLOCK(85),
	        LVL_6_ENCHANT(87),
	        TELEOTHER_CAMELOT(90);
	        private final int level;

	        private Modern(final int level) {
	            this.level = level;
	        }

	        @Override
	        public int getChildIndex() {
	            return this.ordinal();
	        }


	        @Override
	        public int getParentIndex() {
	            return MODERN_PARENT_INDEX;
	        }

	        @Override
	        public String toString() {
	            final String name = super.name();
	            return name.charAt(0) + name.substring(1).toLowerCase().replace("_", " ");
	        }

			@Override
			public int getRequiredLevel() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public RunePowerRequirement[] getRunes() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public SpellBook getSpellBook() {
				// TODO Auto-generated method stub
				return null;
			}
	    }

	    public enum Lunar implements Spell {
	        BARBARIAN_TELEPORT(75),
	        CURE_OTHER(68),
	        FERTILE_SOIL(83),
	        CURE_GROUP(74),
	        NPC_CONTACT(67),
	        ENERGY_TRANSFER(91),
	        MONSTER_EXAMINE(66),
	        HUMIDITY(68),
	        HUNTER_KIT(71),
	        STAT_SPY(75),
	        DREAM(79),
	        PLANK_MAKE(86),
	        SPELLBOOK_SWAP(96),
	        MAGIC_IMBUE(82),
	        VENGEANCE(94),
	        BAKE_PIE(65),
	        LUNAR_HOME_TELEPORT(0),
	        FISHING_GUILD_TELEPORT(85),
	        KHAZARD_TELEPORT(78),
	        VENGEANCE_OTHER(93),
	        MOONCLAN_TELEPORT(69),
	        CATHERBY_TELEPORT(87),
	        STRING_JEWELLERY(80),
	        CURE_ME(71),
	        WATERBIRTH_TELEPORT(72),
	        SUPERGLASS_MAKE(77),
	        BOOST_POTION_SHARE(84),
	        STAT_RESTORE_POTION_SHARE(81),
	        ICE_PLATEAU_TELEPORT(89),
	        HEAL_OTHER(92),
	        HEAL_GROUP(95),
	        CURE_PLANT(66),
	        TELE_GROUP_MOONCLAN(70),
	        TELE_GROUP_WATERBIRTH(73),
	        TELE_GROUP_BARBARIAN(76),
	        TELE_GROUP_KHAZARD(79),
	        TELE_GROUP_FISHING_GUILD(86),
	        TELE_GROUP_CATHERBY(88),
	        TELE_GROUP_ICE_PLATEAU(90),
	        KILL_CAT(1337);
	        private final int level;

	        private Lunar(final int level) {
	            this.level = level;
	        }

	        @Override
	        public int getChildIndex() {
	            return this.ordinal();
	        }


	        @Override
	        public int getParentIndex() {
	            return LUNAR_PARENT_INDEX;
	        }

	        @Override
	        public String toString() {
	            final String name = super.name();
	            return name.charAt(0) + name.substring(1).toLowerCase().replace("_", " ");
	        }

			@Override
			public int getRequiredLevel() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public RunePowerRequirement[] getRunes() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public SpellBook getSpellBook() {
				// TODO Auto-generated method stub
				return null;
			}
	    }
}

