package service;

import java.util.List;

import domain.ProductVO;

public interface ProductService {

	int productRegister(ProductVO pvo);

	List<ProductVO> getProductList();

	ProductVO getProductDetail(int pno);

	int productModify(ProductVO pvo);

	int productRemove(int pno);

}
