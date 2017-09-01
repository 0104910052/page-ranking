import java.util.ArrayList;

/**
 * Created by exil33t on 9/1/2017.
 */
public class PageRanking {

    private ArrayList<Page> pages;

    public PageRanking() {
        pages = new ArrayList<>();
        DataReader dr = new DataReader();
        pages = dr.getPages();
        printPages();
        calculateInitialRanking();
        printPagesPageRank();
        calculateFinalRanking();
        printPagesFinalRank();
    }

    private void printPagesFinalRank() {
        System.out.println("\n--- Final PR Calculation ---");
        pages.forEach(p-> p.printFinalPageRank());
    }

    private void calculateFinalRanking() {
        pages.forEach(p->{
            pages.forEach(p2->{
                p.increaseFinalPageRanking(p2.calculateFinalPageRankingFor(p));
            });
        });
    }

    private void printPagesPageRank() {
        System.out.println("\n--- Initial PR Calculation ---");
        pages.forEach(p -> p.printPageRank());
    }

    private void printPages(){
        pages.forEach(p -> p.printSelf());
    }

    private void calculateInitialRanking(){
        pages.forEach(p -> pages.forEach(p2-> p.increasePageRanking(p2.calculateInitialPageRankingFor(p))));
    }


}
