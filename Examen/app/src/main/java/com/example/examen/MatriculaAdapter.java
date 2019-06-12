package com.example.examen;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MatriculaAdapter extends RecyclerView.Adapter<MatriculaAdapter.ViewHolder> {
    private List<Matricula> matriculas;

    public MatriculaAdapter(){
        this.matriculas = new ArrayList<>();
    }
    public void setMatriculas(List<Matricula> matriculas){
        this.matriculas = matriculas;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView fotoImage;
        public TextView correotext;
        public TextView tituloText;
        public TextView tipodeproductoText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fotoImage = itemView.findViewById(R.id.imagen);
            correotext = itemView.findViewById(R.id.correo);
            tituloText = itemView.findViewById(R.id.titulo);
            tipodeproductoText = itemView.findViewById(R.id.tipodeproducto);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_productos, parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Matricula matricula= this.matriculas.get(position);
        viewHolder.correotext.setText(matricula.getCorreo());
        viewHolder.tipodeproductoText.setText(matricula.getTipo_solicitud());
        viewHolder.tituloText.setText(matricula.getSolicitud());
        String url = ApiService.API_BASE_URL + "/matriculas/images/" + matricula.getImagen();
        Picasso.with(viewHolder.itemView.getContext()).load(url).into(viewHolder.fotoImage);
    }
    @Override
    public int getItemCount() {
        return this.matriculas.size();
    }

  }


