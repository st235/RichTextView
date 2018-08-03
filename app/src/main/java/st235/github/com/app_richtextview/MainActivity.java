// Copyright © 2018 by Alexander Dadukin (st235@yandex.ru)
// All rights reserved.

package st235.github.com.app_richtextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.widget.TextView;

import st235.github.com.richtextview.CustomFontSpan;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView footer = findViewById(R.id.footer);
        SpannableString footerText = new SpannableString( "\uf0e7 Font Awesome (http://fontawesome.io/)");
        footerText.setSpan(new CustomFontSpan("", "fontawesome-webfont.ttf"), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        footer.setText(footerText);
    }
}
