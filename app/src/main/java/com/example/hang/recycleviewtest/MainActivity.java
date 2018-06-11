package com.example.hang.recycleviewtest;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ContactListener {
    private RecyclerView mRecyclerView;
    private Button btn_test;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
//    private String[] myDataset = {"I", "love", "you"};
    private List<Contributor> contributors;

    @Override
    public void onContactClicked(Contact contact) {

    }

    @Override
    public void onMailClicked(String mail) {
        mail(mail);
    }

    void mail(String mail) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + mail));
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, getString(R.string.send_mail_error), Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.my_recycler_view);
        btn_test = findViewById(R.id.btn_test);

        contributors = new ArrayList<>();
        prepare();
        mLayoutManager = new LinearLayoutManager(this);

        mAdapter = new MyAdapter(contributors, this);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contributors.get(0).setName("Hang Du");
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    private void prepare() {
        Contributor a = new Contributor("Hang", "Good Great Awesome", R.drawable.donald_profile);
        a.setEmail("hustduhang@gmail.com");
        a.addSocial("Github", "https://github.com/hangdu");
        Contributor b = new Contributor("Donald", "I am 19 years old. I am a young software developer, " +
                "I like CS in general, and more specifically, I love learning and doing stuff with Linux and Android. " +
                "I also like TV Series.", R.drawable.donald_profile);
        b.setEmail("duh2@rose-hulman.edu");
        contributors.add(a);
        contributors.add(b);
    }
}
