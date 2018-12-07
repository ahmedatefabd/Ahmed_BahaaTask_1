package com.example.engahmedatef.ahmed_bahaatask_1.repository;

public class RepoGetDataDB implements Repositry.RepoData_Api_DB {

    private RepositoryImp repositoryImp;

    public RepoGetDataDB() {
        repositoryImp = new RepositoryImp();
    }

    // get data from DB
    @Override
    public void getData() {
        repositoryImp.getAllPosts();

    }
}
