package com.smarteducation.learning.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.smarteducation.common.domain.dto.PageDTO;
import com.smarteducation.learning.domain.dto.QuestionFormDTO;
import com.smarteducation.learning.domain.po.InteractionQuestion;
import com.smarteducation.learning.domain.query.QuestionAdminPageQuery;
import com.smarteducation.learning.domain.query.QuestionPageQuery;
import com.smarteducation.learning.domain.vo.QuestionAdminVO;
import com.smarteducation.learning.domain.vo.QuestionVO;

/**
 * <p>
 * 互动提问的问题表 服务类
 * </p>
 *
 * @author 虎哥
 */
public interface IInteractionQuestionService extends IService<InteractionQuestion> {

    InteractionQuestion saveQuestion(QuestionFormDTO questionDTO);

    PageDTO<QuestionVO> queryQuestionPage(QuestionPageQuery query);

    QuestionVO queryQuestionById(Long id);

    PageDTO<QuestionAdminVO> queryQuestionPageAdmin(QuestionAdminPageQuery query);

    QuestionAdminVO queryQuestionByIdAdmin(Long id);

    void hiddenQuestion(Long id, Boolean hidden);

    void updateQuestion(Long id, QuestionFormDTO questionDTO);

    void deleteById(Long id);
}
