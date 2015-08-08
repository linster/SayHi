package ca.stefanm.sayhi.model;

import java.util.ArrayList;

/**
 * Created by stefan on 8/8/15.
 */
public class BusinessCardLibrary {

    public BusinessCardLibrary() {
        BusinessCardList = new ArrayList<BusinessCardItem>();
    }

    public BusinessCardLibrary(ArrayList<BusinessCardItem> businessCardList) {
        BusinessCardList = businessCardList;
    }

    ArrayList<BusinessCardItem> BusinessCardList;



}
