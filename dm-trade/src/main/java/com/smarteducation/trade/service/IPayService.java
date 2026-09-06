package com.smarteducation.trade.service;

import com.smarteducation.trade.domain.dto.OrderDelayQueryDTO;
import com.smarteducation.trade.domain.dto.PayApplyFormDTO;
import com.smarteducation.trade.domain.vo.PayChannelVO;

import java.util.List;

public interface IPayService {
    List<PayChannelVO> queryPayChannels();

    String applyPayOrder(PayApplyFormDTO payApply);

    void queryPayResult(OrderDelayQueryDTO message);
}
