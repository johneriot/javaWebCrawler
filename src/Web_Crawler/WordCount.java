/*
 * John Smith   
 * CITC 1311 PO1 - Puretskiy
 * Contains Parsing resources from Jsoup
 */
package Web_Crawler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

import org.jsoup.nodes.Document;


public class WordCount{
    

    
    String text;
    HashMap<String, Integer> counter;
    ArrayList<Entry<String, Integer>>sorted;
    
    public WordCount(Document document){
	
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
