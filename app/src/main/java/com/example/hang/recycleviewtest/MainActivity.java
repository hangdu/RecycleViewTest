package com.example.hang.recycleviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
//    private String[] myDataset = {"I", "love", "you"};
    private List<Contributor> contributors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.my_recycler_view);

        contributors = new ArrayList<>();
        prepare();
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MyAdapter(contributors);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void prepare() {
        Contributor a = new Contributor("Hang", "Good Great Awesome", R.drawable.donald_profile);
        Contributor b = new Contributor("Donald", "I am 19 years old. I am a young software developer, " +
                "I like CS in general, and more specifically, I love learning and doing stuff with Linux and Android. " +
                "I also like TV Series.", R.drawable.donald_profile);
        contributors.add(a);
        contributors.add(b);
    }
}
