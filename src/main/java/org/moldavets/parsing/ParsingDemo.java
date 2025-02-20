package org.moldavets.parsing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParsingDemo {

    private static List<String> JOB_LIST = new ArrayList<>();

    public static void main(String[] args) {
        try {

            String URL = "https://justjoin.it/job-offers/all-locations/javascript?experience-level=mid&orderBy=DESC&sortBy=published";

            int offers = scrapJobsCount(URL);
            int offset = 0;

            int iterationsCount = offers / 2;

            System.out.println(offers);
            System.out.println(iterationsCount);

            for (int i = 0; i <= iterationsCount; i++) {
                scrapJobLinks(URL ).stream().forEach(link -> {
                    System.out.println(link);
                });
                offset += 20;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static List<String> scrapJobLinks(String URL) {
        try {

            List<String> jobList = new ArrayList<>();

            Document document = Jsoup.connect(URL).get();
            Elements el = document.select("a[href^='/job-offer/']");

            System.out.println(URL);

            for (int i = 0; i <= el.size()-1; i++) {
//                System.out.println(i + el.get(i).attr("src"));
//                jobList.add(el.get(i).attr("src"));
                jobList.add(i + " " + el.get(i).attr("href"));
            }
            return jobList;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int scrapJobsCount(String URL) {

        try {
            Elements elements = Jsoup.connect(URL)
                    .get()
                    .select("h1");

            String[] responseText = elements.getFirst()
                    .text()
                    .split(" ");

            return Integer.parseInt(responseText[4]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
