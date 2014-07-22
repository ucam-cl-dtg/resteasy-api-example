package uk.ac.cam.cl.dtg.teaching.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import uk.ac.cam.cl.dtg.teaching.api.ExampleApi;
import uk.ac.cam.cl.dtg.teaching.models.Fruit;

public class ExampleController implements ExampleApi {

	@Override
	public Fruit load(String type) throws Exception {
		if (type.equals("chocolate")) {
			throw new Exception("Not a fruit");
		}
		return new Fruit(type);
	}

	@Override
	public List<Fruit> loadList() {
		return Arrays.asList(new Fruit[] { new Fruit("apple"),
				new Fruit("orange"), new Fruit("pear") });
	}

	@Override
	public Map<String, ?> exception() throws Exception {
		throw new Exception("Test");
	}

	@Override
	public Fruit proxy(String type) throws Exception {
		ResteasyClient c = new ResteasyClientBuilder().build();
		ResteasyWebTarget t = c
				.target("http://localhost:8080/resteasy-api-example/api");
		ExampleApi proxy = t.proxy(ExampleApi.class);
		Fruit apple = proxy.load(type);
		return apple;
	}

}
