# Vehicle Tracking App

This demo traces moving vehicles as they pass through geohash tiles. It also keeps track of a vehicle movements on a day to day basis. Similar to a vessel tracking or taxi application.  

Contributor(s): [Patrick Callaghan](https://github.com/PatrickCallaghan)

## Objectives
* To demonstrate how Cassandra and Datastax can be used to solve IoT data management issues.

## Project Layout
* [SchemaSetup.java](/src/main/java/com/datastax/demo/SchemaSetup.java) - Sets up the banking IoT schema with transaction tables.
* [Main.java](/src/main/java/com/datastax/banking/Main.java) - Creates transactions.

## How this Works
This application:

1. Allows the user to track a vehicles movements per day. The location is stored in a Cassandra table.

2. Find all vehicles per tile. Tiles have 2 sizes. Tile1 is large, Tile2 is small.

3. Find all vehicles within a given radius of any vehicle.

## Setup and Running

### Prerequisites
The prerequisites required for this application to run

e.g.
* Java 8
* A running DSE cluster
* Maven to compile and run code

### Running
The steps and configuration needed to run and build this application

e.g.
To run this application use the following command:

`node app.js`

This will produce the following output:

`Connected to cluster with 3 host(s) ["XX.XX.XX.136:9042","XX.XX.XX.137:9042","XX.XX.XX.138:9042"]`
