package com.smarteducation.message.service;

import com.smarteducation.message.domain.dto.SmsThirdPlatformDTO;
import com.smarteducation.message.domain.dto.SmsThirdPlatformFormDTO;
import com.smarteducation.message.domain.query.SmsThirdPlatformPageQuery;
import com.smarteducation.common.domain.dto.PageDTO;
import com.smarteducation.message.domain.po.SmsThirdPlatform;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 第三方云通讯平台 服务类
 * </p>
 *
 * @author 虎哥
 * @since 2022-08-19
 */
public interface ISmsThirdPlatformService extends IService<SmsThirdPlatform> {

    List<SmsThirdPlatform> queryAllPlatform();

    Long saveSmsThirdPlatform(SmsThirdPlatformFormDTO thirdPlatformDTO);

    void updateSmsThirdPlatform(SmsThirdPlatformFormDTO thirdPlatformDTO);

    PageDTO<SmsThirdPlatformDTO> querySmsThirdPlatforms(SmsThirdPlatformPageQuery query);

    SmsThirdPlatformDTO querySmsThirdPlatform(Long id);
}
