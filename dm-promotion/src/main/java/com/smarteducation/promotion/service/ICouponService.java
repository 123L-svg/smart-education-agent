package com.smarteducation.promotion.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.smarteducation.common.domain.dto.PageDTO;
import com.smarteducation.promotion.domain.dto.CouponFormDTO;
import com.smarteducation.promotion.domain.dto.CouponIssueFormDTO;
import com.smarteducation.promotion.domain.po.Coupon;
import com.smarteducation.promotion.domain.query.CouponQuery;
import com.smarteducation.promotion.domain.vo.CouponDetailVO;
import com.smarteducation.promotion.domain.vo.CouponPageVO;
import com.smarteducation.promotion.domain.vo.CouponVO;

import java.util.List;

/**
 * <p>
 * 优惠券的规则信息 服务类
 * </p>
 *
 * @author 虎哥
 */
public interface ICouponService extends IService<Coupon> {

    void saveCoupon(CouponFormDTO dto);

    PageDTO<CouponPageVO> queryCouponByPage(CouponQuery query);

    void beginIssue(CouponIssueFormDTO dto);

    List<CouponVO> queryIssuingCoupons();

    void pauseIssue(Long id);

    void deleteById(Long id);

    CouponDetailVO queryCouponById(Long id);

    void beginIssueBatch(List<Coupon> coupons);
}
