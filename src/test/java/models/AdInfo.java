package models;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdInfo {
    @Expose
    String company;
    @Expose
    String url;
    @Expose
    String text;
}
