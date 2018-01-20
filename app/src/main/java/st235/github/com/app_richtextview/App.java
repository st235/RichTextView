// Copyright © 2018 by Alexander Dadukin (st235@yandex.ru)
// All rights reserved.

package st235.github.com.app_richtextview;

import android.app.Application;

import st235.github.com.richtextview.FontProvider;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        FontProvider.init(getAssets());
    }
}
