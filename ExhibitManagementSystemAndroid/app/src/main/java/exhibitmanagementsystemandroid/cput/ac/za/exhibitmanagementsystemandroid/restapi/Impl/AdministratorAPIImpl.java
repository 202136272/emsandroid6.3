package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.restapi.Impl;

import java.io.IOException;

import com.google.gson.Gson;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.conf.util.AppUtil;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Administrator;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.restapi.AdministratorAPI;

/**
 * Created by Bonga on 5/7/2016.
 */
public class AdministratorAPIImpl implements AdministratorAPI {

    private static final String postUrl = AppUtil.getBaserURI() + "api/droid/admininistrator/post";
    private static final String updateUrl = AppUtil.getBaserURI() + "api/droid/person/update";

    @Override
    public Administrator createAdministrator(Administrator administrator) throws IOException {
        String json = new Gson().toJson(administrator);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);
        Request request = new Request.Builder()
                .url(postUrl)
                .post(body)
                .build();
        Response response = AppUtil.getConnection().newCall(request).execute();
        String value = response.body().string();
        Administrator administrator1 = new Gson().fromJson(value, Administrator.class);
        return administrator1;
    }

    @Override
    public Administrator updateAdministrator(Administrator administrator) throws IOException {
        String json = new Gson().toJson(administrator);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);
        Request request = new Request.Builder()
                .url(updateUrl)
                .post(body)
                .build();
        Response response = AppUtil.getConnection().newCall(request).execute();
        String value = response.body().string();
        Administrator administrator1= new Gson().fromJson(value, Administrator.class);
        return administrator1;

    }
}
