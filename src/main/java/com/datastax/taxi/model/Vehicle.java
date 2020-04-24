package com.datastax.taxi.model;

import java.util.Date;

import com.github.davidmoten.geo.LatLong;

public class Vehicle {
	private String vehicle;
	private Date date;
	private LatLong latLong;
	private String tile;
	private String tile2;

	public Vehicle(String vehicle, Date date, LatLong latLong, String tile, String tile2) {
		super();
		this.vehicle = vehicle;
		this.date = date;
		this.latLong = latLong;
		this.tile = tile;
		this.tile2 = tile2;
	}

	public String getVehicle() {
		return vehicle;
	}

	public Date getDate() {
		return date;
	}

	public LatLong getLatLong() {
		return latLong;
	}

	public String getTile() {
		return tile;
	}
	
	public String getTile2() {
		return tile2;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicle=" + vehicle + ", date=" + date + ", latLong=" + latLong + ", tile=" + tile
				+ ", tile2=" + tile2 + "]";
	}

}
