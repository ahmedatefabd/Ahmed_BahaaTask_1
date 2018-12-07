package com.example.engahmedatef.ahmed_bahaatask_1.repository;

public class Factory {


    //use getData method to get object of type data
    public Repositry.RepoData_Api_DB getData(String dataType){

        if(dataType == null){
            return null;
        }
        //get data from api
        if(dataType.equalsIgnoreCase("api")){
            return new RepoGetDataApi();
        }
        //get data from room DB
        else if(dataType.equalsIgnoreCase("db")){
            return new RepoGetDataDB ();
        }
        //get data from DB
//        else if(dataType.equalsIgnoreCase("db")){
//            return new RepoGetDataDB ();
//        }

        return null;
    }
}
