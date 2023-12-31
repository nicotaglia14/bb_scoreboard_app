/**
 * A player on a basketball team plus the player's stats. 
 * @author Nicolas Tagliafichi 
 */
public class Player {

	/**
	 * The player's name.
	 */
	private String name;
	
	/**
	 * The player's jersey.
	 */
	private int jersey;
	
	/**
	 * The player's number of fouls.
	 */
	private int fouls;
	
	/**
	 * The player's number of 1pt field goals.
	 */
	private int fieldGoals_1pt;
	
	/**
	 * The player's number of 2pt field goals.
	 */
	private int fieldGoals_2pt;

	/**
	 * The player's number of 3pt field goals.
	 */
	private int fieldGoals_3pt;

	
	/**
	 * Set the Player's properties to default values.
	 */
	public Player() {
		this.name = "Unknown";
		this.jersey = 0;
		this.fouls = 0;
		this.fieldGoals_1pt = 0;
		this.fieldGoals_2pt = 0;
		this.fieldGoals_1pt = 0;
	}
	
	/**
	 * Allow's creating a Player by only setting the jersey number. <br>
	 * This is necessary when trying to find a Player in the Team's ArrayList.<br>
	 * The constructor calls this.setJersey method for data validation.
	 * @param jersey The jersey number of the player
	 * @throws Exception setJersey method could throw a data validation error.
	 */
	public Player (int jersey) throws Exception {
		this();
		this.setJersey(jersey);
	}

	/**
	 * Allow creating a Player plus setting their name and jersey number. <br>
	 * The constructor calls both the this.setName and setJersey methods for data validation. 
	 * @param name The player's name.
	 * @param jersey The player's jersey number 
	 * @throws Exception calling setJersey method could throw an error.
	 */
	public Player (String name, int jersey) throws Exception {
		this();
		this.setName(name);
		this.setJersey(jersey); 
	}
	
	/**
	 * Get the player's name.
	 * @return The player's name. 
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Get the Player's jersey number.
	 * @return The player's jersey number. 
	 */
	public int getJersey() {
		return this.jersey; 
	}

	/** 
	 * Get the Player's number of fouls.
	 * @return the number of fouls by the player.
	 */
	public int getFouls() {
		return this.fouls; 
	}

	/**
	 * Get the Player's number of 1pt field goals made. 
	 * @return the number of 1pt field goals made by the player.
	 */
	public int getFieldGoals_1pt() {
		return this.fieldGoals_1pt;
	}
	
	/**
	 * Get the Player's number of 2pt field goals made. 
	 * @return the number of 2pt field goals made by the player.
	 */
	public int getFieldGoals_2pt() {
		return this.fieldGoals_2pt;
	}

	/**
	 * Get the Player's number of 3pt field goals made. 
	 * @return the number of 3pt field goals made by the player.
	 */
	public int getFieldGoals_3pt() {
		return this.fieldGoals_3pt;
	}

	/**
	 * Get the Player's total points by calculating it by field goal types.
	 * @return the Player's total points. 
	 */
	public int getPoints() {
		return fieldGoals_1pt + (fieldGoals_2pt * 2) + (fieldGoals_3pt * 3);
	}
	
	/**
	 * Set the Player's name.
	 * @param name The player's name. 
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/** 
	 * Set the Player's jersey number if it's a number between 0 and 99.
	 * @param jersey The Player's jersey number.
	 * @throws Exception Invalid jersey number. 
	 */
	public void setJersey(int jersey) throws Exception {
		if (jersey >= 0 && jersey <= 99)
			this.jersey = jersey;
		else
			throw new Exception("Invalid jersey number. Must be between 0 and 99"); 
	}

	/**
	 * Increment the Player's fouls by 1. 
	 */
	public void foul() {
		this.fouls++;
	}

	/**
	 * Increment the appropriate field goal type, using a switch that also handles for invalid data. 
	 * @param shotType The shot type made 1=1pt field goal shot, 2=2pt field goal shot, 3=3pt field goal shot. 
	 * @throws Exception Invalid shotType.
	 */
	public void shot(int shotType) throws Exception {
		switch (shotType) {
		case 1:
			this.fieldGoals_1pt++;
			break;
		case 2:
			this.fieldGoals_2pt++;
			break;
		case 3:
			this.fieldGoals_3pt++;
			break;
		default:
			throw new Exception("Invalid shot type: " + shotType);			
		}
	}

	/**
	 * Display the Player's jersey number, name, number of fouls, and number of points via getPoints method. <br> <br>
	 * 
	 * Example: #1 Player 1 Fouls: 0 Points: 1
	 */
	public void displayStats() {
		System.out.println("#" + this.jersey + " " + this.name + " Fouls: " + this.fouls + " Points: " + getPoints());
	}

	/**
	 * Instead of verifying two players are identical by equal identities.<br>
	 * This method will verify to players are the same by only their jersey number.<br>
	 * This allows the ArrayList.getIndex() method to return a player's by only checking their jersey number.
	 * @param object A player object to check equality of only the jersey number.
	 * @return True if the two player's are equal.
	 */
	@Override
	public boolean equals(Object object){
		if(!(object instanceof Player))
			return false;

		Player other = (Player)object;

		if (this.jersey == other.getJersey())
			return true;
		else
			return false; 
	}

}
