package com.hfad.androiduberclone.Service;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.hfad.androiduberclone.Common.Common;
import com.hfad.androiduberclone.Model.Token;

public class MyFirebaseIdService extends FirebaseInstanceIdService {

    //Press Ctrl+O

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("OBI.M",refreshedToken);
        updateTokenToServer(refreshedToken); //After refresh token, it needs to update to Realtime database
    }

    private void updateTokenToServer(String refreshedToken) {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference tokens = db.getReference(Common.token_tbl);

        Token token = new Token(refreshedToken);
        if (FirebaseAuth.getInstance().getCurrentUser() != null) // if its already in login, must update token
            tokens.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
            .setValue(token);

    }
}
