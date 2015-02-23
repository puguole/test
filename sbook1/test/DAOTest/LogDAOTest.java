package DAOTest;

import org.junit.Test;

import com.icss.dao.DiscussDAO;
import com.icss.vo.DiscussVO;
import com.icss.vo.LogVO;

public class LogDAOTest {
	@Test
	public void test1(){
		DiscussVO lvo=new DiscussVO();
		lvo.setlId(8);
		lvo.setuName("puguole");
		DiscussDAO ddao=new DiscussDAO();
		int count = 0;
		try {
			count=ddao.findDiscussCount(lvo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(count);
	}
}
