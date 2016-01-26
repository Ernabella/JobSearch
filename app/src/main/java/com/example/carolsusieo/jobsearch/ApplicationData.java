package com.example.carolsusieo.jobsearch;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by carolsusieo on 1/21/16.
 */
class AppDataStruct {
    String companyName;
    String initialDate;
    String followupDate;
    boolean intermediate;
}

class AppData {
    private AppDataStruct appDataOnly = new AppDataStruct();
    String getCompanyName() {return appDataOnly.companyName;}
    String getInitialDate() { return appDataOnly.initialDate;}
    String getFollowDate() { return appDataOnly.followupDate;}
    boolean getIntermediate() { return appDataOnly.intermediate;}
    void setCompanyName(String name) {appDataOnly.companyName = name;}
    void setInitialDate(String date) {appDataOnly.initialDate = date;}
    void setFollowupDate(String date) {appDataOnly.followupDate = date;}
    void setIntermediate(boolean in) { appDataOnly.intermediate = in; }
    AppDataStruct getData() { return appDataOnly;}
    AppDataStruct  storeData(AppDataStruct in) {appDataOnly = in; return appDataOnly;}

}
public class ApplicationData {

    private AppData appData = new AppData();
    private ArrayList<AppDataStruct> arrayList = new ArrayList< >();

    public ArrayList<AppDataStruct> getAppArray(){return arrayList;}

    void storeData(AppDataStruct in) {
    //appData.storeData(in);
     arrayList.add(in) ;
    }

}
