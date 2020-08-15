package com.lakue.roomsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText mTodoEditText;
    private TextView mResultTextViewl;
    private Button mAddButton;
    private Button mDeleteButton;
    private Button mUpdateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTodoEditText = findViewById(R.id.et_todo);
        mResultTextViewl = findViewById(R.id.tv_result);
        mAddButton = findViewById(R.id.btn_add);
        mDeleteButton = findViewById(R.id.btn_delete);
        mUpdateButton = findViewById(R.id.btn_update);


        MainViewModel viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainViewModel.class);

        //UI갱신
        viewModel.getAll().observe(this, todos -> mResultTextViewl.setText(todos.toString()));

        //버튼클릭시 DB에 Insert
        mAddButton.setOnClickListener(v ->
                viewModel.insert(new Todo(mTodoEditText.getText().toString()))
         );


    }


}