package com.imooc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 订单持久化类
 * 
 * @author Administrator
 * 
 */
public class Order implements Serializable {
	private Long id;// 主键
	private Customer customer;// 客户
	private Date tradeDate;// 购买日期
	private String status;// 状态
	private Double amount;// 交易金额
	private Set<OrderItem> orderItems;// 订单明细	
	
	public Order() {
	
	}

	/*public Order(Date tradeDate, String status, Double amount) {
		super();
		this.tradeDate = tradeDate;
		this.status = status;
		this.amount = amount;
	}

	public Order(Customer customer, Date tradeDate, String status, Double amount) {
		this.customer = customer;
		this.tradeDate = tradeDate;
		this.status = status;
		this.amount = amount;
	}*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public String toString() {
		return "订单主键:" + this.getId() + "    |    客户:"
				+ this.getCustomer().getName() + "    |     购买日期:"
				+ this.getTradeDate() + "    |   订单状态:" + this.getStatus()
				+ "    |   交易金额:" + this.getAmount(); 
	}	
}
