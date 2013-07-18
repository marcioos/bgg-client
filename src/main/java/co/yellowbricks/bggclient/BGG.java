package co.yellowbricks.bggclient;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import co.yellowbricks.bggclient.config.SpringContext;
import co.yellowbricks.bggclient.fetch.FetchService;
import co.yellowbricks.bggclient.search.SearchService;

public final class BGG {
	
	private static ApplicationContext applicationContext;
	
	private BGG() {
	}

	public static SearchService getSearchService() {
		return getApplicationContext().getBean(SearchService.class);
	}
	
	public static FetchService getFetchService() {
		return getApplicationContext().getBean(FetchService.class);
	}
	
	private static ApplicationContext getApplicationContext() {
		if (applicationContext == null) {
			applicationContext = new AnnotationConfigApplicationContext(SpringContext.class);
		}
		return applicationContext;
	}
	
}
