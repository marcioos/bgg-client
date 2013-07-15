package co.yellowbricks.bggclient;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import co.yellowbricks.bggclient.domain.Items;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;

public class HttpTest {

	@Test
	public void testHttpConnection() {
		AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
		Future<Response> f;
		try {
			f = asyncHttpClient.prepareGet("http://www.boardgamegeek.com/xmlapi2/thing").addQueryParameter("id", "1").execute();
			JAXBContext jaxbContext = JAXBContext.newInstance(Items.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			
			System.out.println(unmarshaller.unmarshal(f.get().getResponseBodyAsStream()));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			asyncHttpClient.close();
		}
	}
}
