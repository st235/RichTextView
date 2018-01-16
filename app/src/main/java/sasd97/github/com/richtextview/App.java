package sasd97.github.com.richtextview;

import android.app.Application;

import sasd97.github.com.lib_richtextview.FontProvider;

/**
 * Created by alexander on 16/01/2018.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        FontProvider.init(getAssets());
    }
}
