package nl.hu.v1wac.firstapp.webservices;

import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nl.hu.v1wac.firstapp.model.Country;
import nl.hu.v1wac.firstapp.model.ServiceProvider;
import nl.hu.v1wac.firstapp.model.WorldService;
import nl.hu.v1wac.firstapp.persistence.CountryDAO;

@Path("/countries")
public class WorldResource {
	private ServiceProvider sp;
	WorldService service = sp.getWorldService();
	JsonArrayBuilder jab = Json.createArrayBuilder();
	JsonObjectBuilder job = Json.createObjectBuilder();
	CountryDAO cdao = new CountryDAO();
@GET
@Produces("application/json")
public String getCountries(){
	for (Country c: service.getAllCountries()){
		
		job.add("name", c.getName());
		job.add("lat",c.getLatitude());
		job.add("lon", c.getLongitude());
		job.add("countryCode", c.getIso3Code() );
		job.add("capital", c.getCapital());
		job.add("government", c.getGovernment());
		job.add("population", c.getPopulation());
		job.add("region", c.getRegion());
		job.add("surface", c.getSurface());
		job.add("continent", c.getContinent());
		jab.add(job);
	}
	JsonArray array = jab.build();
	return array.toString();
	
}





	@GET
	@Path("/{code}")
	@Produces("application/json")
	public String getCountryByCode(@PathParam("code") String id){
		Country c = cdao.findByCode(id);
		job.add("iso2", c.getCode());
		job.add("code", c.getIso3Code());
		job.add("name", c.getName());
		job.add("continent", c.getContinent());
		job.add("capital", c.getCapital());
		job.add("region", c.getRegion());
		job.add("surface", c.getSurface());
		job.add("population", c.getPopulation());
		job.add("government", c.getGovernment());
		job.add("lat", c.getLatitude());
		job.add("lng", c.getLongitude());
		jab.add(job);
		JsonArray array = jab.build();
		return array.toString();
		
	}
@GET
@Path("/largestsurfaces")
@Produces("application/json")

public String getBiggestSurface(){
	for (Country c: service.get10LargestSurfaces()){
		
		job.add("name", c.getName());
		jab.add(job);
	}
	JsonArray array = jab.build();
	return array.toString();
	
}


@GET
@Path("/largestpopulations")
@Produces("application/json")


public String getBiggestPop(){
	for (Country c: service.get10LargestPopulations()){
		
		job.add("name", c.getName());
		jab.add(job);
	}
	JsonArray array = jab.build();
	return array.toString();
	
}

@PUT	
@Path("{updatecode}")
@Produces("application/json")

public String updateCountry(@PathParam("updatecode") String code,
	@FormParam("nameUpdate") String name,
	@FormParam("iso2Update") String iso2,
	@FormParam("capitalUpdate") String capital,
	@FormParam("continentUpdate") String continent,
	@FormParam("regionUpdate") String region,
	@FormParam("surfaceUpdate") Double surface,
	@FormParam("populationUpdate") Integer population,
	@FormParam("governmentUpdate") String government,
	@FormParam("latUpdate") Double lat,
	@FormParam("lngUpdate") Double lng){


Country newCountry = new Country(iso2,code,name,capital,continent,region,surface,population,government,lat,lng);
System.out.println(newCountry);
cdao.update(newCountry);
System.out.println(newCountry);
return newCountry.toString();
}

@DELETE
@Path("{iso3}")
@Produces("application/json")
public String deleteCountry(@PathParam("iso3") String code,
		@FormParam("nameUpdate") String name,
		@FormParam("iso2Update") String iso2,
		@FormParam("capitalUpdate") String capital,
		@FormParam("continentUpdate") String continent,
		@FormParam("regionUpdate") String region,
		@FormParam("surfaceUpdate") Double surface,
		@FormParam("populationUpdate") Integer population,
		@FormParam("governmentUpdate") String government,
		@FormParam("latUpdate") Double lat,
		@FormParam("lngUpdate") Double lng){


	Country newCountry = new Country(iso2,code,name,capital,continent,region,surface,population,government,lat,lng);
	System.out.println(newCountry);
	cdao.delete(newCountry);
	System.out.println(newCountry);
	return newCountry.toString();
	}

@POST

@Produces("application/json")

public String createCountry(@FormParam("code") String code,
		@FormParam("name") String name,
		@FormParam("iso2") String iso2,
		@FormParam("capital") String capital,
		@FormParam("continent") String continent,
		@FormParam("region") String region,
		@FormParam("surface") Double surface,
		@FormParam("population") Integer population,
		@FormParam("government") String government,
		@FormParam("lat") Double lat,
		@FormParam("lng") Double lng){
	Country newCountry = new Country(iso2,code,name,capital,continent,region,surface,population,government,lat,lng);
	cdao.save(newCountry);
	System.out.println(newCountry);
	return newCountry.toString();

}

@GET
@Path("search/{value}")
@Produces("application/json")
public String search(@PathParam("value")String value){
for (Country c: cdao.searchCountry(value)){
	
	job.add("iso2", c.getCode());
	job.add("code", c.getIso3Code());
	job.add("name", c.getName());
	job.add("continent", c.getContinent());
	job.add("capital", c.getCapital());
	job.add("region", c.getRegion());
	job.add("surface", c.getSurface());
	job.add("population", c.getPopulation());
	job.add("government", c.getGovernment());
	job.add("lat", c.getLatitude());
	job.add("lng", c.getLongitude());
	jab.add(job);
	}
	JsonArray array = jab.build();
	return array.toString();
}
@GET
@Path("population")
@Produces("application/json")
public String getPop(){
	for (Country c: cdao.find10LargestPopulations()){
		
		job.add("name", c.getName());
		job.add("lat",c.getLatitude());
		job.add("lon", c.getLongitude());
		job.add("countryCode", c.getIso3Code() );
		job.add("capital", c.getCapital());
		job.add("government", c.getGovernment());
		job.add("population", c.getPopulation());
		job.add("region", c.getRegion());
		job.add("surface", c.getSurface());
		job.add("continent", c.getContinent());
		jab.add(job);
	}
	JsonArray array = jab.build();
	return array.toString();
	
}
@GET
@Path("surface")
@Produces("application/json")
public String getSur(){
	for (Country c: cdao.find10LargestSurfaces()){
		
		job.add("name", c.getName());
		job.add("lat",c.getLatitude());
		job.add("lon", c.getLongitude());
		job.add("countryCode", c.getIso3Code() );
		job.add("capital", c.getCapital());
		job.add("government", c.getGovernment());
		job.add("population", c.getPopulation());
		job.add("region", c.getRegion());
		job.add("surface", c.getSurface());
		job.add("continent", c.getContinent());
		jab.add(job);
	}
	JsonArray array = jab.build();
	return array.toString();
	
}

}
