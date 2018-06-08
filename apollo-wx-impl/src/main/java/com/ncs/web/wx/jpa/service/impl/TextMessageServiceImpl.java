package com.ncs.web.wx.jpa.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.web.wx.jpa.entity.TextMessageEntity;
import com.ncs.web.wx.jpa.repository.TextMessageRepository;
import com.ncs.web.wx.jpa.service.TextMessageService;

@Service
public class TextMessageServiceImpl implements TextMessageService {
	@Autowired
	private TextMessageRepository textMessageRepository;

	public TextMessageRepository getTextMessageRepository() {
		return textMessageRepository;
	}

	public void setTextMessageRepository(TextMessageRepository textMessageRepository) {
		this.textMessageRepository = textMessageRepository;
	}

	@Transactional
	public long Create(TextMessageEntity textMessageEntity) {
		return textMessageRepository.saveAndFlush(textMessageEntity).getId();
	}
}
