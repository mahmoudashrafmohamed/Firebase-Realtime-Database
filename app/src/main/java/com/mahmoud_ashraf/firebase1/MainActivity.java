package com.mahmoud_ashraf.firebase1;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mahmoud_ashraf.firebase1.model.Post;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // before read/write you need to get instance from the Database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
       /**
        * if you call it again it does overwrite on the previous value
        *
        // add key
        DatabaseReference myName = database.getReference("my_name");
        //add value
        myName.setValue("mahmouddd");
        */


        /**
        //add key
        DatabaseReference posts = database.getReference("posts");

        Post post = new Post();
        post.setTitle("How to eat pizza !");
        post.setWriter("Mahmoud Ashraf mohamed");
        post.setContent("all people love pizza but you can find I mac on the desc which in space what is this !  ");
        //add value from model class
        posts.setValue(post);
           */
        /**
         // if you want to add values without remove the previous using Push()
         */
        //add key
        DatabaseReference posts = database.getReference("posts");
        Post post = new Post();
        post.setTitle("How to eat pizza !");
        post.setWriter("mona");
        post.setContent("all people love pizza but you can find I mac on the desc which in space what is this !  ");

       /** //add value in addition to (under) unique key
        posts.push().setValue(post);
        */
        //you can add listener to check if value added succeed or fail
        posts.push().setValue(post).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Post Add Successfully", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Error : post not add  ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
