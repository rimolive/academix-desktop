import java.util.List;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.engines.ApacheHttpClient4Engine;

public class AcademixClient {

	private final String API_BASE_URL = "http://academix-rmartinelli.rhcloud.com/rest/";
	private final ResteasyClient client;

	public AcademixClient() {
		Credentials credentials = new UsernamePasswordCredentials("admin",
				"PWKsEwPcHyBr");
		DefaultHttpClient httpClient = new DefaultHttpClient();
		httpClient.getCredentialsProvider().setCredentials(
				new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT),
				credentials);

		client = new ResteasyClientBuilder().httpEngine(
				new ApacheHttpClient4Engine(httpClient)).build();

	}

	private String getCompleteUrl(String... resourceUri) {
		UriBuilder finalUri = UriBuilder.fromPath(API_BASE_URL);
		for (int i = 0; i < resourceUri.length; i++) {
			finalUri.path(resourceUri[i]);
		}
		return finalUri.build().toString();
				//.concat("/");
	}

	public List<Endereco> allEnderecos() {
		System.out.println(getCompleteUrl("enderecos"));
		return client
				.target(getCompleteUrl("enderecos"))
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Endereco>>(){});
	}
}
