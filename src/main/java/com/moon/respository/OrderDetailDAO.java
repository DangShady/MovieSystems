package com.moon.respository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.moon.entity.OrderDetail;
import com.moon.report.ReportTotalSale;

@Repository
public interface OrderDetailDAO extends JpaRepository<OrderDetail, Integer>{
	
	@Query("SELECT d.product.name,d.product.image,d.product.price,SUM(d.quantity),SUM(d.price*d.quantity)"
			+ " FROM OrderDetail d"
			+ " GROUP BY d.product.name,d.product.image,d.product.price ORDER BY SUM(d.quantity) DESC")
	public Page<Object[]> topProductDashboard(Pageable pageable);
	
	@Query("SELECT new com.moon.report.ReportTotalSale(AVG(d.amount),SUM(d.amount))"
			+ " FROM Order d WHERE d.status = true")
	public ReportTotalSale revenueByDashboardTotalSales();
	
	@Query("SELECT SUM(d.amount)"
			+ " FROM Order d"
			+ " WHERE DATEPART(MONTH,GETDATE()) = DATEPART(MONTH,d.orderdate) AND d.status = true")
	public Object revenueByDashboardByMonth();
	
	@Query("SELECT SUM(d.amount)"
			+ " FROM Order d"
			+ " WHERE DATEPART(WEEK,GETDATE()) = DATEPART(WEEK,d.orderdate) AND d.status = true")
	public Object revenueByDashboardByWeek();
	
}
