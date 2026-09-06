package com.smarteducation.message.service;

import com.smarteducation.api.dto.sms.SmsInfoDTO;
import com.smarteducation.api.dto.user.UserDTO;
import com.smarteducation.message.domain.po.NoticeTemplate;

import java.util.List;

public interface ISmsService {
    void sendMessageByTemplate(NoticeTemplate noticeTemplate, List<UserDTO> users);

    void sendMessage(SmsInfoDTO smsInfoDTO);

    void sendMessageAsync(SmsInfoDTO smsInfoDTO);
}
