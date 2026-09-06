package com.smarteducation.promotion.service;

import com.smarteducation.api.dto.promotion.CouponDiscountDTO;
import com.smarteducation.api.dto.promotion.OrderCouponDTO;
import com.smarteducation.api.dto.promotion.OrderCourseDTO;

import java.util.List;

public interface IDiscountService {
    List<CouponDiscountDTO> findDiscountSolution(List<OrderCourseDTO> orderCourses);

    CouponDiscountDTO queryDiscountDetailByOrder(OrderCouponDTO orderCouponDTO);
}
