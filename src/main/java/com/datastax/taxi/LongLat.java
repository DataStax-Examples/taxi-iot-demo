package com.datastax.taxi;

public class LongLat {
	private double lng;
	private double lat;

	public LongLat(double lng, double lat) {
		super();
		this.lng = lng;
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public double getLat() {
		return lat;
	}

	@Override
	public String toString() {
		return lat +"," + lng;
	}

	public void update() {
	
		if (Math.random()<.2) return;
		
		if (Math.random()<.5)
			lng += .00001d;
		else
			lng -= .00001d;
		
		if (Math.random()<.5)
			lat += .0001d;
		else
			lat -= .0001d;	
	}

}
