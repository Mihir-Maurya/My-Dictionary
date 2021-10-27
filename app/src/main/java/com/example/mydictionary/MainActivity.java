package com.example.mydictionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mydictionary.Models.ApiResponse;
import com.example.mydictionary.ViewHolders.Adapters.MeaninAdapter;
import com.example.mydictionary.ViewHolders.Adapters.PhonoticsAdapter;

public class MainActivity extends AppCompatActivity {
 SearchView search_view;
 TextView textView_word;
 ProgressDialog progressDialog;
 RecyclerView reycler_phonotics,reycler_meanings;
 PhonoticsAdapter phonoticsAdapter;
 MeaninAdapter meaningAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        search_view = findViewById(R.id.search_view);
        textView_word = findViewById(R.id.textView_word);
        reycler_phonotics = findViewById(R.id.reycler_phonotics);
        reycler_meanings = findViewById(R.id.reycler_meanings);
         progressDialog = new ProgressDialog(this);

        progressDialog.setTitle("Loading... ");
        progressDialog.show();
        RequestManager requestManager = new RequestManager(MainActivity.this);
        requestManager.getWordMeaning(listener, "Welcome");


        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                progressDialog.setTitle("Fetching response for " + query);
                progressDialog.show();
                RequestManager requestManager = new RequestManager(MainActivity.this);
                requestManager.getWordMeaning(listener,query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }

    private final onFetchDataListner listener = new onFetchDataListner() {
        @Override
        public void onFetchData(ApiResponse apiResponse, String message) {
            progressDialog.dismiss();
            if(apiResponse==null){
                Toast.makeText(MainActivity.this,"No data Found" ,Toast.LENGTH_SHORT);
            }
            showData(apiResponse);

        }

        @Override
        public void onError(String message) {
      progressDialog.dismiss();
      Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
        }
    };

    private void showData(ApiResponse apiResponse) {
        textView_word.setText("Word: " + apiResponse.getWord());
        reycler_phonotics.setHasFixedSize(true);
        reycler_phonotics.setLayoutManager(new GridLayoutManager(this,1));
        phonoticsAdapter = new PhonoticsAdapter(this,apiResponse.getPhonetics());
        reycler_phonotics.setAdapter(phonoticsAdapter);

        reycler_meanings.setHasFixedSize(true);
        reycler_meanings.setLayoutManager(new GridLayoutManager(this,1));
        meaningAdapter = new MeaninAdapter(this,apiResponse.getMeanings());
        reycler_meanings.setAdapter(meaningAdapter);


    }
}









