package ca.stefanm.sayhi.model;

import java.util.ArrayList;

import ca.stefanm.sayhi.model.restpojo.Bizcard;

/**
 * Created by stefan on 8/8/15.
 */
public class BusinessCardLibrary {

    public BusinessCardLibrary() {
        BusinessCardList = new ArrayList<Bizcard>();
    }

    public BusinessCardLibrary(ArrayList<Bizcard> businessCardList) {
        BusinessCardList = businessCardList;
    }

    ArrayList<Bizcard> BusinessCardList;



}
