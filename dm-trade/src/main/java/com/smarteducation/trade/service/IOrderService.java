package com.smarteducation.trade.service;

import com.smarteducation.common.domain.dto.PageDTO;
import com.smarteducation.pay.sdk.dto.PayResultDTO;
import com.smarteducation.trade.constants.OrderCancelReason;
import com.smarteducation.trade.domain.dto.PlaceOrderDTO;
import com.smarteducation.trade.domain.po.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smarteducation.trade.domain.po.OrderDetail;
import com.smarteducation.trade.domain.query.OrderPageQuery;
import com.smarteducation.trade.domain.vo.OrderConfirmVO;
import com.smarteducation.trade.domain.vo.OrderPageVO;
import com.smarteducation.trade.domain.vo.OrderVO;
import com.smarteducation.trade.domain.vo.PlaceOrderResultVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 订单 服务类
 * </p>
 *
 * @author 虎哥
 * @since 2022-08-29
 */
public interface IOrderService extends IService<Order> {

    PlaceOrderResultVO placeOrder(PlaceOrderDTO placeOrderDTO);

    @Transactional
    void saveOrderAndDetails(Order order, List<OrderDetail> orderDetails);

    void cancelOrder(Long orderId, OrderCancelReason cancelReason);

    void deleteOrder(Long id);

    PageDTO<OrderPageVO> queryMyOrderPage(OrderPageQuery pageQuery);

    OrderVO queryOrderById(Long id);

    PlaceOrderResultVO queryOrderStatus(Long orderId);

    void handlePaySuccess(PayResultDTO payResult);

    PlaceOrderResultVO enrolledFreeCourse(Long courseId);

    OrderConfirmVO prePlaceOrder(List<Long> courseIds);

}
