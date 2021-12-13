package com.hipradeep.learnandroid.androidbasics.lists;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.hipradeep.learnandroid.R;
import com.hipradeep.learnandroid.androidbasics.models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<UserModel> userList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView=findViewById(R.id.rv_simple);

        createUsersList();
        recyclerAdd();
    }

    private void recyclerAdd() {

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(RecyclerViewActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        RecyclerViewAdapter adapter=new RecyclerViewAdapter(userList, RecyclerViewActivity.this);
        recyclerView.setAdapter(adapter);


    }

    private void createUsersList() {
        //using setter
        UserModel newUser=new UserModel();
        newUser.setImage(R.drawable.car);
        newUser.setName("New User");
        newUser.setMobile("0123456789");
        newUser.setAddress("abd");
        userList.add(newUser);


        //using constructor
        UserModel user1=new UserModel(R.drawable.car, "User 1", "1234567890", "lko");
        userList.add(user1);

        UserModel user2=new UserModel(R.drawable.car, "User 2", "1234567890", "lko");
        userList.add(user2);


        userList.add(new UserModel(R.drawable.car, "User 3", "1234567890", "lko"));
        userList.add(new UserModel(R.drawable.car, "User 4", "1234567890", "lko"));
        userList.add(new UserModel(R.drawable.car, "User 5", "1234567890", "lko"));
        userList.add(new UserModel(R.drawable.car, "User 6", "1234567890", "lko"));
        userList.add(new UserModel(R.drawable.car, "User 7", "1234567890", "lko"));

    }
}


//1. simple list view
//2. on double tap
//3. left right swap
//4. delete item
//5. add item
//7. update item