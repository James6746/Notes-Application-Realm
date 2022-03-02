package com.example.notesapplicationrealm;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application {
    public static RealmConfiguration config;

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        config = new RealmConfiguration.Builder()
                .allowQueriesOnUiThread(true)
                .allowWritesOnUiThread(true)
                .build();

        Realm.setDefaultConfiguration(config);

//        Realm realm = Realm.getDefaultInstance();

        //insert method1
//        realm.beginTransaction();
//        RealmModelExample user = realm.createObject(RealmModelExample.class);
//        user.setName("James");
//        user.setAge(22);
//        realm.commitTransaction();

        //insert method1
//        RealmModelExample user = new RealmModelExample("James", 21);
//
//        realm.beginTransaction();
//        realm.copyToRealm(user);
//        realm.commitTransaction();

//        inserting List
//        List<RealmModelExample> users = Arrays.asList(new RealmModelExample("James", 21), new RealmModelExample("Otabek", 23));
//        realm.beginTransaction();
//        realm.insert(users);
//        realm.commitTransaction();

        //query looking at all users
//        RealmQuery<RealmModelExample> users = realm.where(RealmModelExample.class);
//
//        //conditions
//        users.equalTo("name", "john");
//        users.or().equalTo("name", "James");
//
//        //execute
//        RealmResults<RealmModelExample> results = users.findAllAsync();
//        results.get(0);
//        results.size();


    }
}
