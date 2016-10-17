package com.spring.Hit.dao;

import java.util.List;

import com.spring.Hit.dto.MemberDto;
import com.spring.Hit.dto.OrderDto;
import com.spring.Hit.dto.ProductDto;
import com.spring.Hit.dto.ReviewDto;

public interface ProductIDao {

	// ī�װ��� ��ǰ ����Ʈ ������
	public List<ProductDto> listDao(ProductDto pdt);

	// ��ǰ �� ���� ������ , ��ǰ ��� ����
	public ProductDto viewDao(int item_no);

	// ��ǰ �̸����� �˻�
	public ProductDto searchItem(String item_name);

	// ��ü ���� ���
	public List<ReviewDto> selectAllReview();

	// ��ǰ�� ���� ���
	public List<ReviewDto> getReview(int item_no);

	// ��ü ���� ���(���̵�)
	public List<ReviewDto> getReviewList(String id);

	// ���� ���
	public void addReview(ReviewDto rd);

	// ���� ����
	public void updateReview(ReviewDto rd);

	// ���� ����
	public void deleteReview(int item_no);

	// ���� �� ����
	public void deleteList(ReviewDto rd);

	// ���� �Ѱ� ����
	public ReviewDto selectReview(int review_no);

	// ���� ���� //����¡ ó��
	public int reviewCount();

	// ����������
	public List<MemberDto> vmemDao(String id);

	// ���� �Է�
	public void orderinsertDao(OrderDto order);

	// ���� ���̺�
	public List<OrderDto> vieworderDao(String id);

	// �ֱ� �ֹ� ��� ����Ʈ
	public List<OrderDto> viewRecentOrderDao(String id);

	// ���� ���
	public void deleteorder(int order_no);

	// �ֹ���Ҵ��
	public void orderdel(int order_no);

	// ������ ����
	public void minuspd(OrderDto order);

	// ������ ���ϱ�
	public void pluspd(OrderDto order);

}
