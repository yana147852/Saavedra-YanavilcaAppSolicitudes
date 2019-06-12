package com.example.examen;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {
    String API_BASE_URL="http://10.200.175.179:8080";
    @GET("/matriculas")
    Call<List<Matricula>> getMatricula();

    @FormUrlEncoded
    @POST("/matriculas")
    Call<ResponseMessage> createMatricula(
            @Field("correo") String nombre,
            @Field("solicitud") String solicitud,
            @Field("tipo_solicitud") String detalles);

    @Multipart
    @POST("/matriculas")
    Call<ResponseMessage> createMatriculaWithImage(
            @Part("correo") RequestBody nombre,
            @Part("tipo_solicitud") RequestBody solicitud,
            @Part("solicitud") RequestBody detalles,
            @Part MultipartBody.Part imagen
    );
}
