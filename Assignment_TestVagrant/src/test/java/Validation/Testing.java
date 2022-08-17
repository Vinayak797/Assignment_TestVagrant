package Validation;

import Payload.Team;
import io.restassured.path.json.JsonPath;

public class Testing {

	public void ForeignPlayers()
	{
		JsonPath js = new JsonPath(Team.TeamRCB());
		int count = js.getInt("player.size()");
		
		int x=0;
		for(int i=0; i<count; i++)
		{
			String PlayerCountry = js.getString("player["+i+"].country");
		
			if(PlayerCountry.equalsIgnoreCase("India"))
			{
				x = x+1;
			}
		}
		if(x==7)
		{
			System.out.println("Team Has Only 4 Foreign Players");
			System.out.println("(QA Passed)");
		}
		else
		{
			System.out.println("Team Has More Than 4 Foreign Players");
			System.out.println("(QA Failed)");
		}
	}
	
	public void Wicketkeeper()
	{
		JsonPath js = new JsonPath(Team.TeamRCB());
		int count = js.getInt("player.size()");
		
		int x=0;
		for(int i=0; i<count; i++)
		{
			String PlayerCountry = js.getString("player["+i+"].role");
		
			if(PlayerCountry.equalsIgnoreCase("Wicket-keeper"))
			{
				x = x+1;
			}
		}
		if(x>=1)
		{
			System.out.println("Team Has Wicket-Keeper");
			System.out.println("(QA Passed)");
		}
		else
		{
			System.out.println("Team Has NO Wicket-Keeper");
			System.out.println("(QA Failed)");
		}
	}
	
	public static void main(String[] args) {
		Testing obj = new Testing();
		obj.ForeignPlayers();
		obj.Wicketkeeper();
	}
}
