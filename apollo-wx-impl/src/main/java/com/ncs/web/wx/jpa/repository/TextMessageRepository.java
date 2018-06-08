package com.ncs.web.wx.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncs.web.wx.jpa.entity.TextMessageEntity;

public interface TextMessageRepository extends JpaRepository<TextMessageEntity, Long> {
}
