# Vehicle Tracking App

This demo traces moving vehicles as they pass through geohash tiles. It also keeps track of a vehicle movements on a day to day basis. Similar to a vessel tracking or taxi application.  

Contributor(s): [Patrick Callaghan](https://github.com/PatrickCallaghan)

## Objectives
* To demonstrate how Cassandra and Datastax can be used to solve IoT data management issues.

## Project Layout
* [SchemaSetup.java](/src/main/java/com/datastax/demo/SchemaSetup.java) - Sets up the `current_location` and `vechile` tables.
* [Main.java](/src/main/java/com/datastax/banking/Main.java) - Continuously updates the locations of the vehicle.

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
* **Setup the schema**

To specify contact points use the contactPoints command line parameter e.g.
`-DcontactPoints=192.168.25.100,192.168.25.101'`
The contact points can take mulitple points in the IP,IP,IP (no spaces).

To create the schema, run the following

	mvn clean compile exec:java -Dexec.mainClass="com.datastax.demo.SchemaSetup" -DcontactPoints=localhost

* **Create the Solr core**

To create the solr core, run

	dsetool create_core datastax_taxi_app.current_location reindex=true schema=src/main/resources/solr/geo.xml solrconfig=src/main/resources/solr/solrconfig.xml

* **Update vehicle locations**

To continuously update the locations of the vehicles run

	mvn clean compile exec:java -Dexec.mainClass="com.datastax.taxi.Main" -DcontactPoints=localhost

* **Run the webservice**

To start the web server, in another terminal run

	mvn jetty:run  

* **Sample queries**

To find all movements of a vehicle use http://localhost:8080/datastax-taxi-app/rest/getmovements/{vehicle}/{date} e.g.

	http://localhost:8080/datastax-taxi-app/rest/getmovements/207/20200424

Alternatively, with CQL:

	select * from vehicle where vehicle = '207' and day='20200424';

To find all vehicle movement, use the rest command http://localhost:8080/datastax-taxi-app/rest/getvehicles/{tile} e.g.

	http://localhost:8080/datastax-taxi-app/rest/getvehicles/gcpm

Alternatively, with CQL:

	 select * from current_location where solr_query = '{"q": "tile1:gcpm"}' limit 1000;


To find all vehicles within a certain distance of a latitude and longitude, http://localhost:8080/datastax-taxi-app/rest/search/{lat}/{long}/{distance}

	http://localhost:8080/datastax-taxi-app/rest/search/52.53956077140064/-0.20225833920426117/5

Alternatively, with CQL:

	select * from current_location where solr_query = '{"q": "*:*", "fq": "{!geofilt sfield=lat_long pt=52.53956077140064,-0.20225833920426117 d=5}"}' limit 1000;

* **Remove the schema**

To remove the tables and the schema, run the following.

   mvn clean compile exec:java -Dexec.mainClass="com.datastax.demo.SchemaTeardown"
