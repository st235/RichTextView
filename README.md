<img src="https://raw.githubusercontent.com/st235/RichTextView/master/pictures/logo.png" width="410" height="138">

# RichTextView

## Install

From maven

```xml
<dependency>
  <groupId>com.github.st235</groupId>
  <artifactId>richtextview</artifactId>
  <version>0.0.2</version>
  <type>pom</type>
</dependency>
```

From gradle

```
compile 'com.github.st235:richtextview:0.0.2'
```

## Usage

<img src="https://raw.githubusercontent.com/st235/RichTextView/master/pictures/examples.png" width="270" height="480">

First of all, the library must be initialized. If this step is omitted, the attempt to use will generate an exception.

```java
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        FontProvider.init(getAssets());
    }
}
```

View easily configurable from the markup,

```xml
    <st235.github.com.richtextview.RichTextView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:gravity="center"
        android:text="No more &#xf1e2;"
        android:textSize="22sp"
        app:fontAsset="fontawesome-webfont.ttf"/>
```
but if you need to download the font manually from the Assets, not everything is lost!

```java
    /**
     * loads the font in the specified path relative to the assets folder.
     * @param fontAsset - font link
     */
    public void loadFont(@Nullable String fontAsset)
```

## License

MIT License

Copyright (c) 2018 Alexander Dadukin

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
