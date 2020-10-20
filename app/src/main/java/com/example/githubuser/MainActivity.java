package com.example.githubuser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collection;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvUser;
    private ArrayList<User> listUser = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvUser = findViewById(R.id.main_activity_user_list);
        rvUser.setHasFixedSize(true);

        listUser.addAll(getListUser());
        showRecycleList();
    }

    public ArrayList<User> getListUser(){
        TypedArray dataAvatar = getResources().obtainTypedArray(R.array.avatar);
        String[] dataUsername = getResources().getStringArray(R.array.username);
        String[] dataName = getResources().getStringArray(R.array.name);
        String[] dataCompany = getResources().getStringArray(R.array.company);
        String[] dataFollower = getResources().getStringArray(R.array.followers);
        String[] dataFollowing = getResources().getStringArray(R.array.following);
        String[] dataLocation = getResources().getStringArray(R.array.location);
        String[] dataRepository = getResources().getStringArray(R.array.repository);

        ArrayList<User>listUser = new ArrayList<>();
        for (int i = 0; i < dataUsername.length; i++){
            User user = new User();
            user.setAvatar(dataAvatar.getResourceId(i, -1));
            user.setUsername(dataUsername[i]);
            user.setName(dataName[i]);
            user.setCompany(dataCompany[i]);
            user.setFollowers(dataFollower[i]);
            user.setFollowing(dataFollowing[i]);
            user.setLocation(dataLocation[i]);
            user.setRepository(dataRepository[i]);

            listUser.add(user);
        }
        return listUser;
    }

    private void showRecycleList(){
        rvUser.setLayoutManager(new LinearLayoutManager(this));
        UserAdapter userAdapter = new UserAdapter(listUser);
        rvUser.setAdapter(userAdapter);

    }
}