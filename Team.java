import java.util.ArrayList;
import java.util.List;

/**
 * Used to keep track of a basketball Team that is made up with multiple Players <br>
 * along with the Team's stats.
 * @author Nicolas Tagliafichi
 *
 */
public class Team {

	/**
	 * The team's name.
	 */
	private String name;
	
	/**
	 * List of player's
	 */
	private List<Player> players;

	/**
	 * Set the Team's properties to the default values. 
	 */
	public Team() {
		this.name = "Unknown";
		this.players = new ArrayList<Player>();
	}

	/**
	 * Allows creating a Team with a name. 
	 * @param name The team's name. 
	 */
	public Team(String name) {
		this();
		this.setName(name);	
	}

	/**
	 * Get a Player by their jersey number using the ArrayList.indexOf method. <br>
	 * If the indexOf method returns -1 then this method returns null. Otherwise, <br>
	 * it returns the Player object associated with the jersey number. 
	 * @param jersey The player's jersey number.
	 * @return If a player is found, it will return the Player object, otherwise a null value.
	 * @throws Exception Creating a player with a invalid jersey number could throw an error. 
	 */
	public Player getPlayer(int jersey) throws Exception {

		int index = this.players.indexOf(new Player(jersey));

		if (index == -1)
			return null;
		else
			return this.players.get(index);
	}

	/**
	 * Add a player to the Team, by using the overload constructor that allows setting their name and jersey number too.<br>
	 * This method will verify that the jersey number is not already used by another player by calling the Team.getPlayer method.<br>
	 * and if it is, the it will throw an exception back to the calling method. 
	 * @param name The player's name
	 * @param jersey The Player's jersey number.
	 * @throws Exception Jersey number already assigned
	 */
	public void addPlayer(String name, int jersey) throws Exception {

		Player dup = this.getPlayer(jersey);

		if (dup == null)
			this.players.add(new Player(name, jersey));
		else
			throw new Exception("Jersey #" + jersey + " already assigned to " + dup.getName());
	}

	/**
	 * Displays each Player's detail stats for the entire Team using the Player's getter methods.<br>
	 * This method uses a printf method for proper stats alignment.
	 */
	public void displayDetailStats() {

		System.out.println("Jersey  Name             Fouls  1pt  2pt  3pt  Total");
		System.out.println("======  ===============  =====  ===  ===  ===  =====");
		
		for (int i = 0; i < this.players.size(); i++) {
			String name = this.players.get(i).getName();
			int jersey = this.players.get(i).getJersey();
			int fouls = this.players.get(i).getFouls();
			int fieldGoal_1pt = this.players.get(i).getFieldGoals_1pt();
			int fieldGoal_2pt = this.players.get(i).getFieldGoals_2pt();
			int fieldGoal_3pt = this.players.get(i).getFieldGoals_3pt();
			int totalPoints = this.players.get(i).getPoints(); 
		
			System.out.printf("%6d %16s %6d %4d %4d %4d %6d \n", jersey, name, fouls, fieldGoal_1pt, fieldGoal_2pt, fieldGoal_3pt, totalPoints);
		}
	}
	
	/**
	 * Display the Team's summary stats using the Team.getTeamFouls and getTeamPoints methods. 
	 */
	public void displayTeamStats() {
		
		System.out.println("Team " + this.name + " Fouls: " + getTeamFouls() + " Points: " + getTeamPoints());
		
	}
	
	/**
	 * Set the Team's name.
	 * @param name The Team's name.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the Team's name
	 * @return the Team's name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Get total number of fouls for the entire Team using the Player.getFouls method. 
	 * @return The total number of fouls for the team. 
	 */
	public int getTeamFouls() {
		int totalFouls = 0; 
		
		for (int i = 0; i < this.players.size(); i++) {
			totalFouls += this.players.get(i).getFouls();
		}
		
		return totalFouls; 
	}
	
	/**
	 * Get total number of points for the entire Team by calling the Player.getPoints method. 
	 * @return The Team's points.  
	 */
	public int getTeamPoints() {
		int totalPoints = 0; 
		
		for (int i = 0; i < this.players.size(); i++) {
			totalPoints += this.players.get(i).getPoints();
		}
		
		return totalPoints; 
	}
}
