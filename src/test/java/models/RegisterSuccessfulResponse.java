package models;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
public class RegisterSuccessfulResponse {
    @Expose
    int id;
    @Expose
    String token;
}
