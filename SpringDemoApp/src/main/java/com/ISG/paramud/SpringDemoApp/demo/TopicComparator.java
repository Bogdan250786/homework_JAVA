package com.ISG.paramud.SpringDemoApp.demo;

import java.util.Comparator;

public class TopicComparator implements Comparator<Topic> {
    
    public int compare(Topic a, Topic b) {
        return b.getDate().compareTo(a.getDate());
    }
}
