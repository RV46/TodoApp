package com.example.easy_todo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import adapters.TodoListAdapter;
import entities.Todo;
import todo_database.*;

import android.util.Log;
import android.view.View;
import android.widget.*;
import android.content.*;

import com.example.easy_todo.fragment.FragmentActivity;


public class HomeActivity extends AppCompatActivity {

    private Button button_add;
    private ListView listview_todo;
    TodoDB todoDB;
    private Button button_logout;
    private Button button_about;
    private Button Dashboard, OrmTodoButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.button_add = (Button) findViewById(R.id.button_add);

        this.button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Add Todos", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(HomeActivity.this, AddTodoActivity.class);
                startActivity(intent1);
            }
        });

        //logout button function
        this.button_logout = (Button) findViewById(R.id.button_logout);
        this.button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Logged out Successfully!", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent1);
                finish();
            }
        });

        //about button function
        this.button_about = (Button) findViewById(R.id.button_about);
        this.button_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "About and contact using Mvvm and recycleview", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(HomeActivity.this, MvvmActivity.class);
                startActivity(intent1);
                finish();
            }
        });


        //use orm to-do
        this.OrmTodoButton = (Button) findViewById(R.id.button_todoorm);
        this.OrmTodoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Using Todo with Orm and Mvvm", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(HomeActivity.this, MvvmMainActivity.class);
                startActivity(intent1);
            }
        });

        //dashboard button fragment and mvvm
        this.Dashboard = (Button) findViewById(R.id.button_Dashboard);
        this.Dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Fragments", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(HomeActivity.this, FragmentActivity.class);
                startActivity(intent1);
                finish();
            }
        });

        todoDB = new TodoDB(this);
        this.listview_todo = (ListView) findViewById(R.id.listview_todo);
        this.listview_todo.setAdapter(new TodoListAdapter(this, todoDB.findAll()));
        this.listview_todo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                Todo todo = todoDB.findAll().get(i);
                Intent intent1 = new Intent(HomeActivity.this, TodoDetailActivity.class);
                intent1.putExtra("todo", todo);
                startActivity(intent1);
            }
        });
    }

    protected void onStart(){
        super.onStart();
        Log.i("testlifecycle", "on create event" );
    }

    protected void onResume(){
        super.onResume();
        Log.i("testlifecycle", "on resume event" );
    }

    protected void onPause(){
        super.onPause();
        Log.i("testlifecycle", "on pause event" );
    }

    protected void onStop(){
        super.onStop();
        Log.i("testlifecycle", "on stop event" );
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.i("testlifecycle", "on destroy event" );
    }
}
