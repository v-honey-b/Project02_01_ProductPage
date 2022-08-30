package service;

import java.util.List;

import domain.ProductVO;
import repository.ProductDAO;
import repository.ProductDAOImpl;

public class ProductServiceImpl implements ProductService {
	private ProductDAO pdao;
	public ProductServiceImpl() {
		pdao = new ProductDAOImpl();
	}

	@Override
	public int productRegister(ProductVO pvo) {
		return pdao.productInsert(pvo);
	}

	@Override
	public List<ProductVO> getProductList() {
		return pdao.selectProductList();
	}

	@Override
	public ProductVO getProductDetail(int pno) {
		return pdao.selectProductOne(pno);
	}

	@Override
	public int productModify(ProductVO pvo) {
		return pdao.productUpdate(pvo);
	}

	@Override
	public int productRemove(int pno) {
		return pdao.productDelete(pno);
	}

}
