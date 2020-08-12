package com.secondshop.services;

import com.secondshop.mappers.OrderMapper;
import com.secondshop.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    /**
     * 根据买家id查询订单
     * @param customerId 买家id
     * @return 订单信息
     */
    @Transactional
    public List<Order> getOrderByCustomerId(Integer customerId){
        return orderMapper.getOrderByCustomerId(customerId);
    }

    /**
     * 查询全部订单信息
     * @return
     */
    @Transactional
    public List<Order> getOrderList(){
        return orderMapper.getOrderList();
    }

    /**
     * 根据卖家id查询订单信息
     * @param sellerId 卖家id
     * @return
     */
    @Transactional
    public List<Order> getOrderBySellerId(Integer sellerId){
        return orderMapper.getOrderBySellerId(sellerId);
    }

    /**
     * 根据买家id和订单id查询订单
     * @param customerId 买家id
     * @param orderId 订单id
     * @return
     */
    @Transactional
    public List<Order> getOtherOrderByCustomerId(Integer customerId, Integer orderId){
        return orderMapper.getOtherOrderByCustomerId(customerId, orderId);
    }

    /**
     * 根据卖家id和订单id查询订单
     * @param sellerId 卖家id
     * @param orderId 订单id
     * @return
     */
    @Transactional
    public List<Order> getOtherOrderBySellerId(Integer sellerId, Integer orderId){
        return orderMapper.getOtherOrderBySellerId(sellerId, orderId);
    }

    /**
     * 根据订单id查询订单
     * @param orderId
     * @return
     */
    @Transactional
    public Order getOrderById(Integer orderId){
        return orderMapper.getOrderById(orderId);
    }

    /**
     * 根据状态id和订单id修改订单
     * @param statusId 状态id
     * @param orderId 订单id
     * @return
     */
    @Transactional
    public int updateStatus(Integer statusId, Integer orderId){
        return orderMapper.updateStatus(statusId, orderId);
    }

    /**
     * 根据订单id删除订单
     * @param orderId 订单id
     * @return
     */
    @Transactional
    public int deleteOrderById(Integer orderId){
        return orderMapper.deleteOrderById(orderId);
    }

    /**
     * 添加订单
     * @param order 订单
     * @return
     */
    @Transactional
    public int insertOrder(Order order){
        return orderMapper.insertOrder(order);
    }

}
