package com.rnapp;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import android.content.Intent;

public class MyAppNativeModule extends ReactContextBaseJavaModule {

    private static ReactApplicationContext reactContext;
    private static String name;

    MyAppNativeModule(ReactApplicationContext context) {
        super(context);
        this.reactContext = context;
    }

    @Override
    public String getName() {
        return "MyAppNativeModule";
    }


    @ReactMethod
    public void getData(Callback cb) {
        System.out.println("getData == name ===" + name);
        cb.invoke("name");
    }

    @ReactMethod
    public void launchYourScreen() {
        ReactApplicationContext reactContext = getReactApplicationContext();
        if (reactContext == null) {
            return;
        }
        // Check if the current activity is not null
        if (reactContext.getCurrentActivity() != null) {
            // Create an Intent to launch the Activity from the AAR
            Intent intent = new Intent(reactContext.getCurrentActivity(), com.testsdk.MainActivity.class);
            reactContext.getCurrentActivity().startActivity(intent);
        }
    }
}

