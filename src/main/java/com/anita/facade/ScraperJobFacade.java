package com.anita.facade;

import org.jsoup.nodes.Document;


import java.util.ArrayList;
import java.util.List;

public class ScraperJobFacade {
    public List<JobDetail> scrap(String site, String jobName)  {
        List<JobDetail> allJobs = new ArrayList<>();
        if (site.equals("merojob")) {
            WebCaller webCaller = new WebCaller();
            int i = 1;
            boolean exists = true;
            while (exists) {
                Document document = webCaller.call("https://merojob.com/search/?q=" + jobName + "&page=" + (i++));
                if(document!=null)
                {
                    Scraper scraper = new ScraperMeroJob();
                    List<JobDetail> jobs = (List<JobDetail>) scraper.scrap(document);
                    allJobs.addAll(jobs);
                    exists = !jobs.isEmpty();
                }else{
                    exists = false;
                }
            }
        }

        return allJobs;
    }
}
