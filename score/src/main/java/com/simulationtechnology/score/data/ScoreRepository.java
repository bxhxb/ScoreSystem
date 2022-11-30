package com.simulationtechnology.score.data;

import static com.simulationtechnology.score.constant.Global.GLOBAL_TAG;

import android.content.Context;
import android.util.Log;

import com.simulationtechnology.score.vo.LessonInfo;
import com.simulationtechnology.score.vo.SearchResponse;
import com.simulationtechnology.score.vo.UserInfo;
import com.simulationtechnology.score.vo.UserInfoDao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.core.SingleOnSubscribe;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ScoreRepository {
    private static ScoreRepository instance;
    private NetworkRequest requestService;
    private OkHttpClient okHttpClient;
    private AppDatabase appDatabase;

    private ScoreRepository() {
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(180, TimeUnit.SECONDS)
                .writeTimeout(180, TimeUnit.SECONDS)
                .build();

        requestService = new Retrofit.Builder()
                .baseUrl("https://vivid.jtmap.cn/core/")
                //.baseUrl("https://www.google.com.hk/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
                .create(NetworkRequest.class);
    }

    public void setContext(Context context) {
        appDatabase = AppDatabase.getInstance(context);
    }

    public static ScoreRepository getInstance() {
        if (instance == null) {
            instance = new ScoreRepository();
        }
        return instance;
    }

    public Single<List<LessonInfo>> fetchLessonList() {
        return Single.create(new SingleOnSubscribe<List<LessonInfo>>() {
            @Override
            public void subscribe(@NonNull SingleEmitter<List<LessonInfo>> emitter) throws Throwable {
                // Sample data
                Schedulers.io().scheduleDirect(new Runnable() {
                    @Override
                    public void run() {
                        LessonInfo info1 = new LessonInfo();
                        info1.lessonName = "lesson 1";
                        info1.author = "author 1";

                        LessonInfo info2 = new LessonInfo();
                        info2.lessonName = "lesson 2";
                        info2.author = "author 2";

                        List<LessonInfo> list = new ArrayList<>();
                        list.add(info1);
                        list.add(info2);

                        emitter.onSuccess(list);
                    }
                }, 1, TimeUnit.SECONDS);
            }
        });
    }

    public Single<String> verifyAccount() {
        return Single.create(new SingleOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull SingleEmitter<String> emitter) throws Throwable {
                Log.d(GLOBAL_TAG, "in subscribe info");
                emitter.onSuccess("Single success");
            }
        });
    }

    public Single<Boolean> saveToDatabase() {
        return Single.create(emitter -> {
            UserInfo userInfo = new UserInfo();
            userInfo.userId = "first_user_id";
            userInfo.name = "first_user_name";
            userInfo.password = "first_user_password";
            appDatabase.userInfoDao().insertUserInfo(userInfo);

            List<UserInfo> userInfos = appDatabase.userInfoDao().getAllUserInfo();
            emitter.onSuccess(true);
        });
    }

    public Single<String> sendHttpRequest() {
        return Single.create(emitter -> {
//            Response<String> result = null;
//            try {
//                result = requestService.getHttpsResults().execute();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            emitter.onSuccess(result == null ? "error found" : result.body());

//            Response<SearchResponse> ticketResult = null;
//            try {
//                ticketResult = requestService.searchSpecificTicket("SCOUTNAV-6180").execute();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            if (ticketResult != null && ticketResult.isSuccessful()) {
//                SearchResponse response = ticketResult.body();
//                String filename = response.fields.attachment.get(0).filename;
//                emitter.onSuccess(filename);
//            }
        });
    }
}
