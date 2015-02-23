package tt.usersTest;

import java.util.ArrayList;

import org.junit.Test;

import com.icss.dao.LogDAO;
import com.icss.service.UsersService;
import com.icss.vo.LogVO;

public class demo1 {
	//测试登录验证
	@Test
	public void test1(){
		UsersService u=new UsersService();
		boolean b=u.checkLogin("puguole", "123");
		System.out.println("a");
		System.out.println(b);
	}
	//测试好友日志
	@Test
	public void test2(){
		LogDAO logdao=new LogDAO();
		ArrayList list=null;
		try {
			list=(ArrayList) logdao.findAll2("puguole");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<list.size();i++){
			LogVO vo=(LogVO) list.get(i);
			System.out.println(vo.getuName()+" "+vo.getlTitle()+" "+vo.getlContent());
		}
	}
}
