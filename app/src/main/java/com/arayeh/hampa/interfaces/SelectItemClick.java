package com.arayeh.hampa.interfaces;

import com.arayeh.hampa.models.ContentItem;

public interface SelectItemClick {
    public void onItemClick(int groupID, int id);
    public void onItemClick(int groupID, ContentItem contentItem);
}
