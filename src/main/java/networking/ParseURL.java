package networking;

import java.net.URL;

public class ParseURL {

	public static void main(String[] args) throws Exception {
		
		URL aUrl = new URL("http://search.oreilly.com:80/index.html?q=kousen&x=0&y=0#REFERENCE");
		
		System.out.println("protocol = " + aUrl.getProtocol());
		System.out.println("authority = " + aUrl.getAuthority());
		System.out.println("host = " + aUrl.getHost());
		System.out.println("port = " + aUrl.getPort());
		System.out.println("path = " + aUrl.getPath() );
		System.out.println("query = " + aUrl.getQuery());
		System.out.println("filename = " + aUrl.getFile());
		System.out.println("ref = " + aUrl.getRef());

	}

}
