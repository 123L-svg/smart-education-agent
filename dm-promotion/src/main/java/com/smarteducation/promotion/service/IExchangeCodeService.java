package com.smarteducation.promotion.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.smarteducation.common.domain.dto.PageDTO;
import com.smarteducation.promotion.domain.po.Coupon;
import com.smarteducation.promotion.domain.po.ExchangeCode;
import com.smarteducation.promotion.domain.query.CodeQuery;
import com.smarteducation.promotion.domain.vo.ExchangeCodeVO;

/**
 * <p>
 * 兑换码 服务类
 * </p>
 *
 * @author 虎哥
 */
public interface IExchangeCodeService extends IService<ExchangeCode> {
    void asyncGenerateCode(Coupon coupon);

    boolean updateExchangeMark(long serialNum, boolean mark);

    PageDTO<ExchangeCodeVO> queryCodePage(CodeQuery query);

    Long exchangeTargetId(long serialNum);
}
