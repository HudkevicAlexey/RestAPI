package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResourceData {
    @Expose
    int id;
    @Expose
    String name;
    @Expose
    int year;
    @Expose
    String color;
    @SerializedName("pantone_value")
    @Expose
    String pantoneValue;
    @Expose
    List<AdInfo> AdData;
}
