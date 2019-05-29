package com.hfad.androiduberclone.Common;

import android.location.Location;

import com.hfad.androiduberclone.Model.User;
import com.hfad.androiduberclone.Remote.FCMClient;
import com.hfad.androiduberclone.Remote.IFCMService;
import com.hfad.androiduberclone.Remote.IGoogleAPI;
import com.hfad.androiduberclone.Remote.RetrofitClient;

public class Common {

    //public static String currentToken = "";

    public static final String driver_tbl = "Drivers";
    public static final String user_driver_tbl = "DriverInformation";
    public static final String user_rider_tbl = "RidersInformation";
    public static final String pickup_request_tbl = "PickupRequest";
    public static final String token_tbl = "Tokens";

    public static User currentUser;

    public static Location mLastLocation = null;


    public static final String baseURL = "https://maps.googleapis.com";
    public static final String fcmURL = "https://fcm.googleapis.com/";


    public static double base_fare = 255;
    private static double time_rate = 35;
    private static double distance_rate = 175;

    public static double formulaPrice(double km,double min)
    {
        return base_fare+(distance_rate*km)+(time_rate*min);
    }

    public static IGoogleAPI getGoogleAPI(){
        return RetrofitClient.getClient(baseURL).create(IGoogleAPI.class);
    }

    public static IFCMService getFCMService(){
        return FCMClient.getClient(fcmURL).create(IFCMService.class);
    }
}
