package DAOTest;

import java.util.ArrayList;

import org.junit.Test;

import com.icss.dao.FriendsDAO;
import com.icss.vo.FriendsVO;
import com.icss.vo.UsersVO;

public class FriendsDAOTest {
	private FriendsDAO dao=new FriendsDAO();
	@Test
	public void test1(){
		ArrayList<FriendsVO> list=new ArrayList<FriendsVO>();
		try {
			list=(ArrayList<FriendsVO>) dao.findAll2("puguole");
			for(FriendsVO vo:list){
				System.out.println(vo.getfName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test2(){
		try {
			UsersVO vo=dao.find12("puguole");
			System.out.println(vo.getuReadingschool());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
