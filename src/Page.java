import java.util.Arrays;

/**
 * Created by exil33t on 9/1/2017.
 */
public class Page {
    private static final String pattern = "[wW]{3}\\.[a-zA-z]{1,40}.[a-zA-Z]{3,5}";
    private String fileName;
    private Links links;
    private Float pageRank = new Float("0.01");
    private Float finalPageRank = new Float("0.00");


    public Page(String txt, String path) {
        links = new Links();
        fileName = path.split("\\\\")[2].replace(".txt", "");
        makePage(txt);
    }

    private void makePage(String txt) {
        Arrays
            .stream(txt.toLowerCase().split(" "))
            .filter((w) -> w.matches(pattern) && !w.equals(fileName.toLowerCase()))
            .forEach((w)-> pushLink(w));
    }

    private void pushLink(String w) {
        links.pushLink(w);
    }

    public void printSelf() {
        System.out.println("--- Page: " + fileName + " ---");
        links.printLinks();
    }

    public void increasePageRanking(Float v) {
        pageRank += v;
    }

    public void increaseFinalPageRanking(Float v) {
        finalPageRank += v;
    }

    public Float calculateInitialPageRankingFor(Page p) {
        if(links.linksTo(p.getFileName())){
            return links.getInitialPageRankingFor(p.getFileName());
        }
        return new Float(0.0);
    }



    public void printPageRank() {
        System.out.println(fileName + ": " + pageRank);
    }

    public String getFileName() {
        return fileName;
    }

    public Float calculateFinalPageRankingFor(Page p) {
        if(links.linksTo(p.getFileName())){
            return new Float(pageRank / links.length());
        }
        return new Float(0.0);
    }

    public void printFinalPageRank() {
        System.out.println(fileName + ": " + finalPageRank);
    }
}
