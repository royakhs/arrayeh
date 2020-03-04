package com.arayeh.hampa;

public class ContextItem {
    private String header;
    private String context;
    private String img;
    private String video;
    public  ContextItem(String header, String context){
        this.header=header;
        this.context=context;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
