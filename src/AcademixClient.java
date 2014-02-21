import java.util.List;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jboss.resteasy.client.jaxrs.engines.ApacheHttpClient4Engine;

public class AcademixClient {

	private final String API_BASE_URL = "https://academix-rmartinelli.rhcloud.com/";
	
	private AcademixApiService service;

	public AcademixClient() {
		Credentials credentials = new UsernamePasswordCredentials("admin", "PWKsEwPcHyBr");
		
		DefaultHttpClient httpClient = new DefaultHttpClient();
        httpClient.getCredentialsProvider().setCredentials(
                        new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT), credentials);
        service = new AcademixApiServiceImpl(API_BASE_URL,
                        new ApacheHttpClient4Engine(httpClient));
	}

	public List<Endereco> allEnderecos() {
		return service.allEnderecos();
	}
}
