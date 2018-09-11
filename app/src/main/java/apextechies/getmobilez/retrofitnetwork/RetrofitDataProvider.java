package apextechies.getmobilez.retrofitnetwork;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import apextechies.getmobilez.common.ConstantValue;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDataProvider extends AppCompatActivity implements ServiceMethods {
    private Context context;

    private ApiRetrofitService createRetrofitService() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantValue.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiRetrofitService.class);

    }

    public  RetrofitDataProvider(Context context)
    {
        this.context = context;
    }

  /*  @Override
    public void productList(final DownlodableCallback<ProductListModel> callback) {
        createRetrofitService().productList().enqueue(
                new Callback<ProductListModel>() {
                    @Override
                    public void onResponse(@NonNull Call<ProductListModel> call, @NonNull final Response<ProductListModel> response) {
                        if (response.code()==200) {

                            ProductListModel mobileRegisterPojo = response.body();
                            callback.onSuccess(mobileRegisterPojo);

                        } else

                        {
                            if (response.code() == 401)
                            {
                                callback.onUnauthorized(response.code());
                            }
                            else {

                            }
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<ProductListModel> call, @NonNull Throwable t) {
                        Log.d("Result", "t" + t.getMessage());
                        callback.onFailure(t.getMessage());

                    }
                }
        );
    }

    @Override
    public void saveProduct(String user_id, String product_code, String sku, String name, String price, String discount, String selling_price, String image, String quantity, String category, final DownlodableCallback<SaveDataModel> callback) {
        createRetrofitService().saveProduct(user_id, product_code, sku,  name, price, discount, selling_price, image, quantity, category ).enqueue(
                new Callback<SaveDataModel>() {
                    @Override
                    public void onResponse(@NonNull Call<SaveDataModel> call, @NonNull final Response<SaveDataModel> response) {
                        if (response.code()==200) {

                            SaveDataModel mobileRegisterPojo = response.body();
                            callback.onSuccess(mobileRegisterPojo);

                        } else

                        {
                            if (response.code() == 401)
                            {
                                callback.onUnauthorized(response.code());
                            }
                            else {

                            }
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<SaveDataModel> call, @NonNull Throwable t) {
                        Log.d("Result", "t" + t.getMessage());
                        callback.onFailure(t.getMessage());

                    }
                }
        );
    }

    @Override
    public void getSavedProduct(String user_id, final DownlodableCallback<GetSavedProductModel> callback) {
        createRetrofitService().getSavedProduct(user_id ).enqueue(
                new Callback<GetSavedProductModel>() {
                    @Override
                    public void onResponse(@NonNull Call<GetSavedProductModel> call, @NonNull final Response<GetSavedProductModel> response) {
                        if (response.code()==200) {

                            GetSavedProductModel mobileRegisterPojo = response.body();
                            callback.onSuccess(mobileRegisterPojo);

                        } else

                        {
                            if (response.code() == 401)
                            {
                                callback.onUnauthorized(response.code());
                            }
                            else {

                            }
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<GetSavedProductModel> call, @NonNull Throwable t) {
                        Log.d("Result", "t" + t.getMessage());
                        callback.onFailure(t.getMessage());

                    }
                }
        );
    }

    @Override
    public void deleteProduct(String user_id, String productcode, final DownlodableCallback<SaveDataModel> callback) {
        createRetrofitService().deleteProduct(user_id, productcode ).enqueue(
                new Callback<SaveDataModel>() {
                    @Override
                    public void onResponse(@NonNull Call<SaveDataModel> call, @NonNull final Response<SaveDataModel> response) {
                        if (response.code()==200) {

                            SaveDataModel mobileRegisterPojo = response.body();
                            callback.onSuccess(mobileRegisterPojo);

                        } else

                        {
                            if (response.code() == 401)
                            {
                                callback.onUnauthorized(response.code());
                            }
                            else {

                            }
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<SaveDataModel> call, @NonNull Throwable t) {
                        Log.d("Result", "t" + t.getMessage());
                        callback.onFailure(t.getMessage());

                    }
                }
        );
    }*/


}
