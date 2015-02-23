package DAOTest;

import java.util.ArrayList;

import org.junit.Test;

import com.icss.dao.MailDAO;
import com.icss.vo.MailVO;

public class MailDAOTest {
	@Test
	public void test1(){
		MailDAO mdao=new MailDAO();
		ArrayList<MailVO> list=new ArrayList<MailVO>();
		try {
			list=(ArrayList<MailVO>) mdao.findAll2("puguole");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("s");
	}
	@Test
	public void test2(){
		MailDAO mdao=new MailDAO();
		MailVO vo=new MailVO();
		vo.setuName("puguole");
		vo.seteTouname("t1");
		vo.seteTitle("需求分工");
		vo.seteTotime("2014-04-09 12:22:10");
		MailVO vo2=new MailVO();
		try {
			vo2=mdao.findEmail(vo);
			System.out.println(vo2.geteContent());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test3(){
		MailDAO mdao=new MailDAO();
		try {
			long count=mdao.findCount("puguole", "已读");
			System.out.println(count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
