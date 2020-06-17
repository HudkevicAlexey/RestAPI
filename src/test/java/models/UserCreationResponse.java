package models;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserCreationResponse {
    @Expose
    String name;
    @Expose
    String job;
    String id;
    @Expose
    String createdAt;
}
