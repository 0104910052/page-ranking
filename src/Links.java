import java.util.HashMap;

/**
 * Created by exil33t on 9/1/2017.
 */
public class Links {
    private HashMap links;

    public Links() {
        links = new HashMap();
    }


    public void pushLink(String w) {
        links.put(w, links.containsKey(w) ? (int) links.get(w) + 1 : 1);
    }

    public void printLinks() {
        links.forEach((k,v)-> System.out.println("\tLink to: " + k + " frequency: " + v));
    }

    public boolean linksTo(String fileName) {
        return links.containsKey(fileName);
    }

    public Float getInitialPageRankingFor(String fileName) {
        return new Float((int)links.get(fileName) * 0.01);
    }

    public int length() {
        return links.size();
    }

}
