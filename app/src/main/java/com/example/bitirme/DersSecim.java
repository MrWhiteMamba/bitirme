package com.example.bitirme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
//import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DersSecim extends AppCompatActivity {


    private RecyclerView mlistitem;
    private DatabaseReference mDatabase;
    private ArrayList<Blog> arrayList;
    private FirebaseRecyclerOptions<Blog> options;
    private FirebaseRecyclerAdapter<Blog,FirebaseViewHolder> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ders_secim);
        mDatabase= FirebaseDatabase.getInstance().getReference().child("Dersler");
        mDatabase.keepSynced(true);

        mlistitem=(RecyclerView)findViewById(R.id.recyclerv_view);
        mlistitem.setHasFixedSize(true);
        mlistitem.setLayoutManager(new LinearLayoutManager(this));

        arrayList = new ArrayList<Blog>();
        options = new FirebaseRecyclerOptions.Builder<Blog>().setQuery(mDatabase,Blog.class).build();

        adapter = new FirebaseRecyclerAdapter<Blog, FirebaseViewHolder>(options) {
            @SuppressLint("SetTextI18n")
            @Override
            protected void onBindViewHolder(@NonNull FirebaseViewHolder holder, int position, @NonNull Blog model) {

                holder.ders.setText(model.getDers());
                holder.derskodu.setText(model.getDerskodu());

                // final Integer id = model.getId();
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view){

                        Intent intent = new Intent(DersSecim.this,Scanner.class);
                        startActivity(intent);
                    }

                });

            }





            // if(currentScanData.equal(lessonScanData))
            @NonNull
            @Override
            public FirebaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new FirebaseViewHolder(LayoutInflater.from(DersSecim.this).inflate(R.layout.listitem,parent,false));
            }
        };
        mlistitem.setAdapter(adapter);
        adapter.startListening();
    }

}
