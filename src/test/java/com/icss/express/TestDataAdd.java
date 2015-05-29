package com.icss.express;

import java.util.Date;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.icss.express.po.DotInfo;
import com.icss.express.po.StationInfo;
import com.icss.express.po.StationType;
import com.icss.express.po.UserInfo;
import com.icss.express.po.UserType;

/**
 * 
 * @author jokhan（徐晓龙）
 *dat2015,2015年1月12日,上午10:20:48
 *function:
 */
public class TestDataAdd extends TestSupport {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Test
	public void main(){
		System.out.println("-----------------");
		System.out.println(this.getClass());
		System.out.println("添加测试数据");
		System.out.println("-----------------");
	}
	@Test
	public void testDataAdd(){
		Session session = sessionFactory.openSession();
		Assert.assertNotNull(session);
		Transaction transaction = session.beginTransaction();
		try{
			/************添加用户类型***************/
			UserType userType = null;
			userType = new UserType(1, "后台管理员", null);
			session.save(userType);
			userType = new UserType(2, "网点管理员", null);
			session.save(userType);
			userType = new UserType(3, "仓库管理员", null);
			session.save(userType);
			/****************添加用户********************/
			Random random = new Random();
			String[] ns = new String[]{"零","一","二","三","四","五","六","七","八","九"};
			for(int i=0;i<100;i++){
				UserInfo userInfo = new UserInfo();
				String id = i<10?("0"+i):(""+i);
				
				userInfo.setUserName("user"+id);
				userInfo.setUserPwd("123");
				
				userInfo.setCreateTime(getRandomDate());
				char[] ncss = id.toCharArray();
				String name="员工";
				for(char nc : ncss){
					name += ns[Integer.parseInt(""+nc)];
				}
				userInfo.setUserRealName(name);
				userInfo.setUserSex(random.nextBoolean());
				String tel = "13";
				for(int j=0;j<9;j++){
					tel += random.nextInt(10);
				}
				userInfo.setUserTel(tel);
				userInfo.setUserType(new UserType((i % 2) + 2));
				if(i==0){
					userInfo.setUserName("admin");
					userInfo.setUserPwd("admin");
					userInfo.setUserType(new UserType(1));
				}
				session.save(userInfo);
				
			}
			
			transaction.commit();
			session.close();
		}catch(Throwable ex){
			ex.printStackTrace();
			transaction.rollback();
		}
		
		
	}
	
	@Test
	public void testStationAdd(){
		Session session = sessionFactory.openSession();
		Assert.assertNotNull(session);
		Transaction transaction = session.beginTransaction();
		try{
			/*********添加站点类型*********/
			StationType stationType = null;
			stationType = new StationType(1,"stotage",null);
			session.save(stationType);
			stationType = new StationType(2,"dot",null);
			session.save(stationType);
			
			/*********添加站点信息******************/
			
			String[] sheng = new String[]{"北京市", "天津市", "上海市", "重庆市", "河北省", "山西省", "内蒙古", "辽宁省", "吉林省", "黑龙江省", "江苏省", "浙江省", "安徽省", "福建省", "江西省", "山东省", "河南省", "湖北省", "湖南省", "广东省", "广西省", "海南省", "四川省", "贵州省", "云南省", "西藏", "陕西省", "甘肃省", "青海省", "宁夏", "新疆", "香港", "澳门", "台湾"}; 
			String[] shi = new String[]{"北京","天津","上海","重庆","石家庄","太原","呼和浩特","沈阳","长春","哈尔滨","南京","杭州","合肥","福州","南昌","济南","郑州","武汉","长沙","广州","南宁","海口","成都","贵阳","昆明","拉萨","西安","兰州","西宁","银川","乌鲁木齐","香港", "澳门", "台湾"};
			StationInfo stationInfo = null;
			for(int i = 0; i < (2 * sheng.length); i = i + 2){
				/******添加仓库*******/
				stationInfo = new StationInfo();
				stationInfo.setStationId(i + 1);
				stationInfo.setStationName(sheng[i/2] +  shi[i/2] + "仓库");
				stationInfo.setStationAddr(sheng[i/2] + "大"+ shi[i/2]);
				stationInfo.setStationSheng(sheng[i/2]);
				stationInfo.setStationShi(shi[i/2]);
				stationInfo.setStationType(new StationType(1));
				stationInfo.setUserInfo(new UserInfo(i + 2));
				session.save(stationInfo);
				
				/******添加网点*****/
				stationInfo = new StationInfo();
				stationInfo.setStationId(i + 2);
				stationInfo.setStationName(sheng[i/2] + shi[i/2] + "网点");
				stationInfo.setStationAddr(sheng[i/2] + "大"+ shi[i/2] + "的网点");
				stationInfo.setStationSheng(sheng[i/2]);
				stationInfo.setStationShi(shi[i/2]);
				stationInfo.setStationType(new StationType(2));
				stationInfo.setUserInfo(new UserInfo(i + 3));
				session.save(stationInfo);
			}
			
			
//			stationInfo = new StationInfo();
//			stationInfo.setStationId(1);
//			stationInfo.setStationName("武汉仓库");
//			stationInfo.setStationAddr("武汉");
//			stationInfo.setStationSheng("湖北");
//			stationInfo.setStationShi("武汉");
//			stationInfo.setStationType(new StationType(1));
//			stationInfo.setUserInfo(new UserInfo(2));
//			session.save(stationInfo);
//			
//			stationInfo = new StationInfo();
//			stationInfo.setStationId(2);
//			stationInfo.setStationName("升升网点");
//			stationInfo.setStationAddr("武汉理工");
//			stationInfo.setStationSheng("湖北");
//			stationInfo.setStationShi("武汉");
//			stationInfo.setStationType(new StationType(2));
//			stationInfo.setUserInfo(new UserInfo(5));
//			session.save(stationInfo);
			
			
			transaction.commit();
			session.close();
		}catch(Throwable ex){
			ex.printStackTrace();
			transaction.rollback();
		}
		
		
	}
	
	@Test
	public void testDotAdd() {
		Session session = sessionFactory.openSession();
		Assert.assertNotNull(session);
		Transaction transaction = session.beginTransaction();
		try{
			/*********添加网点信息******************/
			DotInfo dotInfo = null;
			for(int i = 2; i <= 68; i = i + 2) {
				dotInfo = new DotInfo(i,i + "县",new StationInfo(i - 1));
				session.save(dotInfo);
			}
			
			transaction.commit();
			session.close();
		}catch(Throwable ex){
			ex.printStackTrace();
			transaction.rollback();
		}
		
	}
	
	
	private Date getRandomDate(){
		Random random = new Random();
		Date date = new Date();
		return new Date(date.getTime()-Math.abs(random.nextInt()*363*47*69*600L)-random.nextInt());
	}
	
	@Test
	public void testMe() {
		String[] sheng = new String[]{"北京市", "天津市", "上海市", "重庆市", "河北省", "山西省", "内蒙古", "辽宁省", "吉林省", "黑龙江省", "江苏省", "浙江省", "安徽省", "福建省", "江西省", "山东省", "河南省", "湖北省", "湖南省", "广东省", "广西省", "海南省", "四川省", "贵州省", "云南省", "西藏", "陕西省", "甘肃省", "青海省", "宁夏", "新疆", "香港", "澳门", "台湾"}; 
		String[] shi = new String[]{"北京","天津","上海","重庆","石家庄","太原","呼和浩特","沈阳","长春","哈尔滨","南京","杭州","合肥","福州","南昌","济南","郑州","武汉","长沙","广州","南宁","海口","成都","贵阳","昆明","拉萨","西安","兰州","西宁","银川","乌鲁木齐","香港", "澳门", "台湾"};
		System.out.println(sheng.length);
		System.out.println(shi.length);
		System.out.println(new Date());
		
	}
	
//	public static void main(String[] args){
//		TestDataAdd testDataAdd = new TestDataAdd();
//		for(int i=0;i<100;i++){
//			System.out.println(testDataAdd.getRandomDate().toLocaleString());
//		}
//	}
}
