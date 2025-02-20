package org.moldavets.parsing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParsSkills {
    public static List<String> ParsSkillsFromURL(String url) {

        //String URL = "https://justjoin.it/job-offer/avsystem-internship-at-avsystem-krakow-java";

        List<String> skills = new ArrayList<String>();
        try {
            Document document = Jsoup.connect(url).get();
            Elements el = document.select("h4");
            for (Element el1 : el) {
                skills.add(el1.text());
            }
            return skills;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
