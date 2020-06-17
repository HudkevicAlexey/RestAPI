package tests;

import adapters.RegisterAdapter;
import adapters.UnknownAdapter;
import adapters.UsersAdapter;
import models.*;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.testng.Assert.assertEquals;

public class APIRequests extends BaseTest {

    public APIRequests() throws FileNotFoundException {
    }

    @Test
    public void GetUsersListTestByPageNumberTest() {
        list = new UsersAdapter().getUsersByPage(2);
        assertEquals(list, expectedUserList);
    }

    @Test
    public void SuccessfulGettingUserByIdTest() {
        user = new UsersAdapter().getUserById(2, 200);
        assertEquals(user, expectedUser);
    }

    @Test
    public void UnsuccessfulGettingUserByIdTest() {
        user = new UsersAdapter().getUserById(23, 404);
    }

    @Test
    public void SuccessfulGettingResourcesList() {
        resourceList = new UnknownAdapter().GetList();
        assertEquals(resourceList, expectedResourcesList);
    }

    @Test
    public void SuccessfulGettingResourcesDataById() {
        resourceData = new UnknownAdapter().GetResourceById(2, 200);
        assertEquals(resourceData, expectedResourcesData);
    }

    @Test
    public void UnsuccessfulGettingResourcesDataById() {
        resourceData = new UnknownAdapter().GetResourceById(23, 404);
    }

    @Test
    public void SuccessfulUserCreationTest() {
        UserCreationResponse user = new UsersAdapter().postUser(new UserCreationResponse("morpheus", "leader", "", ""));
        expectedUserCreationResponse.setCreatedAt(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(new Date()));
        assertEquals(user, expectedUserCreationResponse, "Data is not matching");
        //TODO переписать проверку CreatedAt:
    }

    @Test
    public void SuccessfulUserUpdateTest() {
        UserCreationResponse user = new UsersAdapter().putUser(new UserCreationResponse("morpheus", "zion resident", null, null));
        expectedUserCreationResponse.setCreatedAt(null);
        expectedUserCreationResponse.setJob("zion resident");
        assertEquals(user, expectedUserCreationResponse, "Data is not matching");
    }

    @Test
    public void SuccessfulUserPatchTest() {
        UserCreationResponse user = new UsersAdapter().patchUser(new UserCreationResponse("morpheus", "zion resident", null, null));
        expectedUserCreationResponse.setCreatedAt(null);
        expectedUserCreationResponse.setJob("zion resident");
        assertEquals(user, expectedUserCreationResponse, "Data is not matching");
    }

    @Test
    public void SuccessfulUserDeleteTest() {
        UsersAdapter.deleteUserById(2);
    }

    @Test
    public void SuccessfulRegistration(){
        RegisterSuccessfulResponse user = new RegisterAdapter().registerUser(new RegistrationData("eve.holt@reqres.in", "pistol"), 200);
        assertEquals(user,expectedRegisterResponse, "Data is not matching");
    }

    @Test
    public void UnsuccessfulRegistration(){
        RegisterSuccessfulResponse user = new RegisterAdapter().registerUser(new RegistrationData("eve.holt@reqres.in", null), 400);
        //TODO дописать проверку сообщения
    }
}
