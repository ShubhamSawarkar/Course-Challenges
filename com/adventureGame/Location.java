package com.adventureGame;

import java.util.HashMap;
import java.util.Map;

public class Location {

	private final int locationId;
	private final String Description;
	private final Map<String, Integer> exits;
	
	public Location(int locationId, String description, Map<String, Integer> exists) {
		this.locationId = locationId;
		this.Description = description;
		if(exists != null)
		{
			this.exits = new HashMap<String, Integer>(exists);
		}else
		{
			this.exits = new HashMap<String, Integer>();
		}
		this.exits.put("Q", 0);
	}
	
	public int getLocationId() {
		return locationId;
	}

	public String getDescription() {
		return Description;
	}

	public Map<String, Integer> getExits() {
		return new HashMap<String, Integer>(exits);
	}
	
	
}
