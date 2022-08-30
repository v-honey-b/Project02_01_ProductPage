package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.ProductVO;
import orm.DatabaseConnector;

public class ProductDAOImpl implements ProductDAO {
	// DatabaseConnector
	private Connection conn;
	private PreparedStatement pst;
	private String query = "";
	
	public ProductDAOImpl() {
		DatabaseConnector dbc = DatabaseConnector.getInstance();
		conn = dbc.getConnection();
	}
	@Override
	public int productInsert(ProductVO pvo) {
		// 직접 sql 쿼리 구문 작성 -> PreparedStatement : mapper와 연결하지 않고 바로 작성
		query = "insert into product (pname, price, made_by) values (?, ?, ?)";
		try {
			// pname(String), price(int), made_by(String) 설정
			pst = conn.prepareStatement(query);
			pst.setString(1, pvo.getPname());	// param index(위치), 값
			pst.setInt(2, pvo.getPrice());
			pst.setString(3, pvo.getMade_by());
			return pst.executeUpdate();	// 쿼리 실행 & 변경
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public List<ProductVO> selectProductList() {
		query = "select * from product order by pno desc";
		List<ProductVO> productlist = new ArrayList<ProductVO>();
		try {
			pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();	// 쿼리 실행
			while (rs.next()) {
				productlist.add(new ProductVO(rs.getInt("pno"), rs.getString("pname"), rs.getString("reg_date")));
			}
			return productlist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public ProductVO selectProductOne(int pno) {
		query = "select * from product where pno = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, pno);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return new ProductVO(rs.getInt("pno"), rs.getString("pname"), rs.getInt("price"), rs.getString("reg_date"), rs.getString("made_by"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int productUpdate(ProductVO pvo) {
		query = "update product set pname=?, price=?, reg_date=now(), made_by=? where pno=?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, pvo.getPname());
			pst.setInt(2, pvo.getPrice());
			pst.setString(3, pvo.getMade_by());
			pst.setInt(4, pvo.getPno());
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int productDelete(int pno) {
		query = "delete from product where pno=?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, pno);
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
