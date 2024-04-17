package com.pangisha.pangisha_backend.service;

import com.pangisha.pangisha_backend.model.Clicks;

public interface ClicksService {

    public int getClicks(long postId);

    public Clicks click(Clicks userAction);
}
