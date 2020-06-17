package tests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.*;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class BaseTest {

    Gson gson;
    UsersList list;
    UsersList expectedUserList;
    User expectedUser;
    User user;
    ResourceList resourceList;
    ResourceList expectedResourcesList;
    ResourceData resourceData;
    ResourceData expectedResourcesData;
    UserCreationResponse expectedUserCreationResponse;
    RegisterSuccessfulResponse expectedRegisterResponse;

    public BaseTest() throws FileNotFoundException {

        gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        expectedUserList = gson.fromJson(new FileReader("src/test/resources/expectedJson/ExpectedJsonGetUsers"), UsersList.class);
        expectedUser = gson.fromJson(new FileReader("src/test/resources/expectedJson/ExpectedJsonGetSingleUser"), User.class);
        expectedResourcesList = gson.fromJson(new FileReader("src/test/resources/expectedJson/ExpectedJsonGetListResources"), ResourceList.class);
        expectedResourcesData = gson.fromJson(new FileReader("src/test/resources/expectedJson/ExpectedJsonGetResource"), ResourceData.class);
        expectedUserCreationResponse = gson.fromJson(new FileReader("src/test/resources/expectedJson/ExpectedJsonUserCreation"), UserCreationResponse.class);
        expectedRegisterResponse = gson.fromJson(new FileReader("src/test/resources/expectedJson/ExpectedRegistrationResponse"), RegisterSuccessfulResponse.class);
    }
}
