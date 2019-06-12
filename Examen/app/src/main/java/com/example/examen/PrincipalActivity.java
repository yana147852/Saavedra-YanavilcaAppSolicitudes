package com.example.examen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PrincipalActivity extends AppCompatActivity {
    private static final String TAG = PrincipalActivity.class.getSimpleName();
    private RecyclerView matriculasList;

    private static final int REGISTER_FORM_REQUEST = 100;

    public void showRegister(View view){
        startActivityForResult(new Intent(this, RegisterActivity.class), REGISTER_FORM_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REGISTER_FORM_REQUEST) {
            // refresh data
            initialize();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        matriculasList = findViewById(R.id.recyclerview);
        matriculasList.setLayoutManager(new LinearLayoutManager(this));
        matriculasList.setAdapter(new MatriculaAdapter());        
        initialize();
    }

    private void initialize() {
        ApiService service = ApiServiceGenerator.createService(ApiService.class);
        Call<List<Matricula>> call = service.getMatricula();
        call.enqueue(new Callback<List<Matricula>>() {
            @Override
            public void onResponse(Call<List<Matricula>> call, Response<List<Matricula>> response) {
                try {
                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);
                    if (response.isSuccessful()) {
                        List<Matricula> matriculas= response.body();
                        Log.d(TAG, "productos: " + matriculas);
                        MatriculaAdapter adapter = (MatriculaAdapter) matriculasList.getAdapter();
                        adapter.setMatriculas(matriculas);
                        adapter.notifyDataSetChanged();
                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }
                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(PrincipalActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }
            @Override
            public void onFailure(Call<List<Matricula>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(PrincipalActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
