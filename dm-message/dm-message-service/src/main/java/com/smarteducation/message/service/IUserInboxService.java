package com.smarteducation.message.service;

import com.smarteducation.message.domain.dto.UserInboxDTO;
import com.smarteducation.message.domain.dto.UserInboxFormDTO;
import com.smarteducation.api.dto.user.UserDTO;
import com.smarteducation.message.domain.query.UserInboxQuery;
import com.smarteducation.common.domain.dto.PageDTO;
import com.smarteducation.message.domain.po.NoticeTemplate;
import com.smarteducation.message.domain.po.UserInbox;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户通知记录 服务类
 * </p>
 *
 * @author 虎哥
 * @since 2022-08-19
 */
public interface IUserInboxService extends IService<UserInbox> {

    void saveNoticeToInbox(NoticeTemplate noticeTemplate, List<UserDTO> users);

    PageDTO<UserInboxDTO> queryUserInBoxesPage(UserInboxQuery query);

    Long sentMessageToUser(UserInboxFormDTO userInboxFormDTO);
}
