package DAOTest;

import java.util.ArrayList;

import org.junit.Test;

import com.icss.dao.BookDAO;
import com.icss.vo.BookVO;

public class BookDAOTest {
	private BookDAO bookDAO=new BookDAO();
	@Test
	public void test1(){
		try {
			ArrayList<BookVO> list= (ArrayList) bookDAO.findAlly("t1");
			for(BookVO vo:list){
				System.out.println(vo.getbAddress()+" "+vo.getbBirth()+" "+vo.getuName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test2(){
		try {
			System.out.println(bookDAO.findCountY("t1"));
			System.out.println(bookDAO.findCountN("t1"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
