/*
 * John Smith
 * CITC 1311 PO1 - Puretskiy
 * Contains resources/methods for Web Crawler.
 */
package Web_Crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

public class CrawlerResources {

    
    public static void parse(ArrayList<String> listOfTraversedURLs) throws IOException{
        Document document = Jsoup.connect(urlString).get();

        try{
            document = Jsoup.connect(urlString).get();
        }
        catch(IOException ex){
            System.out.println("Invalid URL.");
        }
        String body = document.text();
        
                System.out.println(body);
    }
    
    String text;
    HashMap<String, Integer> counter;
    ArrayList<Entry<String, Integer>>sorted;
    
    public void WordCount(Document document){
	
	counter = new HashMap<>();
	text = document.body().text();
        countWords();
        sorted = sortByValues(counter);
        }
    
    private ArrayList<Entry<String, Integer>> sortByValues(HashMap<String, Integer> map) {

	ArrayList<Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
	Comparator<Entry<String, Integer>> byMapValues;
        byMapValues = (Entry<String, Integer> left, Entry<String, Integer> right) -> right.getValue().compareTo(left.getValue());
        Collections.sort(list, byMapValues);
	return list;
    }

    private void countWords() {
	// TODO Auto-generated method stub
	StringTokenizer st = new StringTokenizer(text);
	while(st.hasMoreTokens()){
            String word = st.nextToken();
            int count = counter.containsKey(word) ? counter.get(word) : 0;
            System.out.println(counter.put(word, count + 1));
	}
    }
}
    

