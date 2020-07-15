package com.softsquared.examplesharedpreference;

public class Data {
    String title;
    String contents;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Data(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
