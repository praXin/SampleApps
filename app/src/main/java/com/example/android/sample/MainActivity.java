package com.example.android.sample;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.ui.FirebaseListAdapter;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;
    ListView mListView;
    Firebase mRootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRootRef=new Firebase("http://student-zone-5aa6e.firebaseio.com/contact us");
        mTextView=(TextView)findViewById(R.id.TextView1);
        mListView=(ListView)findViewById(R.id.ListView1);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Firebase messagesRef = mRootRef.child("contact us");
        FirebaseListAdapter<String> adapter = new FirebaseListAdapter<String>(this, String.class, android.R.layout.simple_list_item_1, messagesRef) {
            @Override
            protected void populateView(View view, String s, int i) {
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                textView.setText(s);
            }
        };
            mListView.setAdapter(adapter);
    }
    }
