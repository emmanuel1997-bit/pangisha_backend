package com.pangisha.pangisha_backend.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pangisha.pangisha_backend.model.Clicks;
import com.pangisha.pangisha_backend.repository.ClicksRepository;

import com.pangisha.pangisha_backend.service.ClicksService;

@Service
public class ClicksImplement implements ClicksService {
    final public ClicksRepository clicksRepository;

    public ClicksImplement(ClicksRepository clicksRepository) {
        super();
        this.clicksRepository = clicksRepository;
    }

    @Override
    public int getClicks(long postId) {
        List<Clicks> var = clicksRepository.Clicks(postId);
        return var.size();

    }

    @Override
    public Clicks click(Clicks userAction) {
        return clicksRepository.save(userAction);
    }

}
