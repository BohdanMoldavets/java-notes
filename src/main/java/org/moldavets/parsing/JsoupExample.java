package org.moldavets.parsing;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.moldavets.parsing.ParsingDemo.scrapJobsCount;

public class JsoupExample {
    public static void main(String[] args) {

        String URL = "https://justjoin.it/job-offers/all-locations/php?experience-level=mid&orderBy=DESC&sortBy=published";
        int offers = scrapJobsCount(URL);
        System.out.println(offers);

        List<String> jobList = new ArrayList<>();
        List<String> jobSkills = new ArrayList<>();
        Map<String, Integer> rate = new HashMap<>();

        try {
            Document document = Jsoup.connect(URL).get();
            Elements el = document.select("a[href^='/job-offer/']");

            for (int i = 0; i <= el.size()-1; i++) {
                jobList.add(el.get(i).attr("href"));
            }

            for (String job : jobList) {
//                jobSkills.addAll(ParsSkills.ParsSkillsFromURL("https://justjoin.it" + job));
                for(String s : ParsSkills.ParsSkillsFromURL("https://justjoin.it" + job)) {
                    if(rate.containsKey(s)) {
                        rate.put(s, rate.get(s) + 1);
                    } else {
                        rate.put(s, 1);
                    }
                }
            }

            System.out.println(jobSkills);
            System.out.println(rate);

//           generowanie wykresu

            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            for(String skill : rate.keySet()) {
                dataset.addValue(rate.get(skill), "Skills", skill);
            }

            JFreeChart barChart = ChartFactory.createBarChart(
                    "Stat",
                    "Tech",
                    "Count",
                    dataset
            );

            CategoryPlot plot = barChart.getCategoryPlot();
            CategoryAxis axis = plot.getDomainAxis();
            axis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);

            NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
            yAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

            int width = 1920;
            int height = 1080;
            File chartFile = new File("chart.png");
            ChartUtilities.saveChartAsPNG(chartFile, barChart, width, height);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
