package com.imooc.model;

import java.io.Serializable;

/**
 * 订单明细持久类
 * 
 * @author Administrator
 * 
 */
public class OrderItem implements Serializable {
	private Long id;// 主键
	private Order order; //订单
	private Commodity commodity;// 商品
	private Double discount;// 折扣
	private Double actPrice;// 实际价格
	private Double amount;// 金额
	private Integer position;
	
	

	public OrderItem() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getActPrice() {
		return actPrice;
	}

	public void setActPrice(Double actPrice) {
		this.actPrice = actPrice;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String toString() {
		return "订单明细主键:" + this.getId() + "    |   商品名称:"
				+ this.getCommodity().getName() + "    |     折扣:"
				+ this.getDiscount() + "    |   实际价格:" + this.getActPrice()
				+ "    |   金额:" + this.getAmount();
	}
}
