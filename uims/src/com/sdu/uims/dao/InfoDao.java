package com.sdu.uims.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sdu.uims.comm.DBUtil;
import com.sdu.uims.vo.Info;
import com.sdu.uims.vo.Sort;

public class InfoDao {
	/**
	 * 
	 * @param type  锟斤拷锟秸的诧拷询锟斤拷菘锟斤拷锟斤拷筒锟斤拷锟�
	 * @return   锟斤拷锟斤拷一锟斤拷锟斤拷询锟斤拷慕锟斤拷
	 */
    public static List<Info> getRS(String type){
    	/**
    	 * rs锟斤拷锟节憋拷锟斤拷prepareStatement(sql)锟斤拷询锟斤拷慕锟斤拷
    	 */
    	ResultSet rs=null;
    	PreparedStatement ps=null;
    	List<Info> inList=null;
    	/**
    	 * 使锟斤拷占位锟斤拷锟斤拷锟絊QL锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟秸嘉伙拷锟街�
    	 * sql锟斤拷锟�
    	 * 锟斤拷锟节诧拷询锟斤拷要使锟矫碉拷锟斤拷锟斤拷锟�
    	 */
    	String sql="select * from t_uims_info where m_type=?";
    	  try {
    		  ps=DBUtil.getConPst(sql);//锟斤拷取PreparedStatement锟斤拷锟斤拷
    		    ps.setString(1, type);//为锟斤拷一锟斤拷锟斤拷锟斤拷值
			  rs=ps.executeQuery();
			  //实锟斤拷一锟斤拷List锟叫�锟斤拷锟斤拷锟斤拷锟斤拷锟窖拷锟捷的斤拷锟�
			  inList = new ArrayList<Info>();
				while(rs.next()){
					  Info info=new Info();
					  //锟斤拷ID锟斤拷锟节猴拷锟斤拷锟斤拷芯锟斤拷锟斤拷锟较拷牟锟窖拷锟斤拷锟斤拷锟斤拷锟斤拷斜锟斤拷锟斤拷锟绞撅拷锟斤拷锟揭拷锟斤拷锟斤拷锟斤拷拥牟锟斤拷锟�
					  info.setId(rs.getInt("m_id"));
					  info.setType(rs.getString("m_type"));
					  info.setTitle(rs.getString("m_title"));
					  info.setDate(rs.getString("m_date"));
					  info.setName(rs.getString("m_name"));				  
					  inList.add(info);//锟斤拷锟斤拷锟斤拷写锟斤拷list锟斤拷
				  }
				DBUtil.close(ps,rs);//锟截憋拷rs ,ps,con
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    	  //锟斤拷锟截诧拷询锟斤拷锟斤拷萁锟斤拷锟斤拷锟�
    	return inList;
    }
    
    /**
     * 分页获取当前用户的历史发布列表
     * @author 蔡一玮
     * @param page 当前页数  ，id 用户手机号
     * @return  返回一个包含了消息的list 
     */
    public ArrayList<Info> findByPage(int page, String id) {
        int begin = (page-1) * 5;//根据传入的page确定查询开始位置
        String sql = "select * from T_UIMS_INFO where m_ph=? limit "+begin+",5;";//查询语句，通过手机号并从开始位置查找5条语句
        ArrayList<Info> list = new ArrayList<Info>();
        try {
        	PreparedStatement pstm = DBUtil.getConPst(sql);
        	pstm.setString(1, id);
        	ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Info info = new Info();
                info.setId(rs.getInt("m_id"));
                info.setContext(rs.getString("m_context"));
                info.setDate(rs.getString("m_date"));
                info.setMail(rs.getString("m_mail"));
                info.setName(rs.getString("m_name"));
                info.setPayState(rs.getString("m_payState"));
                info.setPayType(rs.getString("m_payType"));
                info.setPhone(rs.getString("m_ph"));
                info.setReviewState(rs.getString("m_reviewState"));
                info.setTitle(rs.getString("m_title"));
                info.setType(rs.getString("m_type"));
                list.add(info);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    /**
     * 获取当前用户的历史发布总数
     * @author 蔡一玮
     * @param String   用户手机号
     * @return  返回值为一个int值表示 
     */
    public int infoCount(String id){
        String sql = "select count(*) from T_UIMS_INFO where m_ph=?;";
        PreparedStatement pstm = DBUtil.getConPst(sql);
        int count = 0;
        try {
        	pstm.setString(1, id);
        	ResultSet rs = pstm.executeQuery();
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return count;
    }
public static List searchInfo(String searchword){
		
		String Search = searchword;//禄帽脠隆麓芦碌脻脌麓碌脛鹿脴录眉脳脰
		
		String sql="select * from t_uims_info";
		
		ResultSet rs=null;
		
		int m_id;//脨脜脧垄id
		String tilte;//脨脜脧垄卤锚脤芒
		String context;//脨脜脧垄脛脷脠脻
		String date;//脨脜脧垄脢卤录盲
		
		String tiltearray[] = new String[1000000];//麓忙脠毛卤锚脤芒脢媒脳茅
		int arrayindex=0;//麓忙麓垄脢媒脳茅碌脛脧脗卤锚
		//脡霉脙梅list拢卢脫脙脫脷脦麓脜脜脨貌碌脛陆谩鹿没录炉
        List<Info> sumans = new ArrayList<Info>();
		try {
			//麓脫脢媒戮脻驴芒脰脨虏茅脮脪鲁枚脠芦虏驴脢媒戮脻
			rs = DBUtil.getConPst(sql).executeQuery();
			while(rs.next())
			{
				m_id=rs.getInt("m_id");
				tilte=rs.getString("m_title");
				context=rs.getString("m_context");
				date=rs.getString("m_date");
				tiltearray[arrayindex++]=tilte;
				
				Info a=new Info();
	        	a.setId(m_id);
	        	a.setTitle(tilte);
	        	a.setContext(context);
	        	a.setDate(date);
	        	sumans.add(a);
				System.out.println(m_id+" "+tilte+" "+context+" "+date);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    
		//脡霉脙梅脧脿脣脝露脠脢媒脳茅
        float index[]=new float[arrayindex];
        //脡霉脙梅list拢卢脫脙脫脷虏脦脫毛脧脿脣脝露脠卤脠陆脧
        List<Sort> al = new ArrayList<Sort>();
        
        //ai脫脙脫脷脠楼鲁媒脧脿脣脝露脠脦陋0碌脛脢媒戮脻
        int ai=arrayindex;
        //脮脪鲁枚脙驴赂枚卤锚脤芒碌脛脧脿脣脝露脠拢卢虏垄卤拢麓忙脭脷index脢媒脳茅脰脨
        for(int i=0;i<arrayindex;i++)
        {
        	//禄帽脠隆脧脗卤铆脦陋i碌脛脧脿脣脝露脠
        	index[i]=levenshtein(Search,tiltearray[i]);
        	System.out.println("脧脿脣脝露脠拢潞"+index[i]);
        	if(index[i]==0)
        	{
        		System.out.println("脧脿脣脝露脠脦陋0");
        		Sort a=new Sort();
            	a.setSimilarity(index[i]);
            	a.setId(i);
            	a.setTitle(tiltearray[i]);
            	al.add(a);
            	ai--;
        	}
        	
        }
        arrayindex=ai;
       
        sort(index,0,arrayindex-1);
        System.out.println("脨貌脕脨脦陋拢潞");
        for(int i=0;i<arrayindex;i++)
        {
        	//al[i].g
        	System.out.println(index[i]);
        }
        
        //脡霉脙梅list拢卢脫脙脫脷卤拢麓忙脪脩脜脜脨貌碌脛陆谩鹿没录炉
        List<Info> ans = new ArrayList<Info>();
        System.out.println("id脦陋拢潞");
        for(int j=arrayindex-1;j>=0;j--)
        {
        	for(int i=0;i<al.size();i++){
            	if(al.get(i).getSimilarity()==index[j])
            	{
            		for(int k=0;k<sumans.size();k++)
            		{
            			if(al.get(i).getId()==sumans.get(k).getId())
            			{
            				ans.add(sumans.remove(k));
            			}
            		}
            		System.out.println(al.get(i).getTitle());
            		al.remove(i);
            	}
            }
        }
        return ans;
    }
	//脜脨露脧脧脿脣脝露脠
	public static float levenshtein(String str1,String str2) {    
        //录脝脣茫脕陆赂枚脳脰路没麓庐碌脛鲁陇露脠隆拢    
        int len1 = str1.length();    
        int len2 = str2.length();    
        //陆篓脕垄脡脧脙忙脣碌碌脛脢媒脳茅拢卢卤脠脳脰路没鲁陇露脠麓贸脪禄赂枚驴脮录盲    
        int[][] dif = new int[len1 + 1][len2 + 1];    
        //赂鲁鲁玫脰碌拢卢虏陆脰猫B隆拢    
        for (int a = 0; a <= len1; a++) {    
            dif[a][0] = a;    
        }    
        for (int a = 0; a <= len2; a++) {    
            dif[0][a] = a;    
        }    
        //录脝脣茫脕陆赂枚脳脰路没脢脟路帽脪禄脩霉拢卢录脝脣茫脳贸脡脧碌脛脰碌    
        int temp;    
        for (int i = 1; i <= len1; i++) {    
            for (int j = 1; j <= len2; j++) {    
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {    
                    temp = 0;    
                } else {    
                    temp = 1;    
                }    
                //脠隆脠媒赂枚脰碌脰脨脳卯脨隆碌脛    
                dif[i][j] = min(dif[i - 1][j - 1] + temp, dif[i][j - 1] + 1,    
                        dif[i - 1][j] + 1);    
            }    
        }    
        //System.out.println("脳脰路没麓庐\""+str1+"\"脫毛\""+str2+"\"碌脛卤脠陆脧");    
        //脠隆脢媒脳茅脫脪脧脗陆脟碌脛脰碌拢卢脥卢脩霉虏禄脥卢脦禄脰脙麓煤卤铆虏禄脥卢脳脰路没麓庐碌脛卤脠陆脧    
        //System.out.println("虏卯脪矛虏陆脰猫拢潞"+dif[len1][len2]);    
        //录脝脣茫脧脿脣脝露脠    
        float similarity =1 - (float) dif[len1][len2] / Math.max(str1.length(), str2.length());    
        //System.out.println("脧脿脣脝露脠拢潞"+similarity);
        return similarity;
    }
	//碌脙碌陆脳卯脨隆脰碌    
    private static int min(int... is) {    
        int min = Integer.MAX_VALUE;    
        for (int i : is) {    
            if (min > i) {    
                min = i;    
            }    
        }    
        return min;    
    }    
    public static void sort(float[] a,int low,int high){
         int start = low;
         int end = high;
         float key = a[low];
         
         
         while(end>start){
             //麓脫潞贸脥霉脟掳卤脠陆脧
             while(end>start&&a[end]>=key)  //脠莽鹿没脙禄脫脨卤脠鹿脴录眉脰碌脨隆碌脛拢卢卤脠陆脧脧脗脪禄赂枚拢卢脰卤碌陆脫脨卤脠鹿脴录眉脰碌脨隆碌脛陆禄禄禄脦禄脰脙拢卢脠禄潞贸脫脰麓脫脟掳脥霉潞贸卤脠陆脧
                 end--;
             if(a[end]<=key){
            	 float temp = a[end];
                 a[end] = a[start];
                 a[start] = temp;
             }
             //麓脫脟掳脥霉潞贸卤脠陆脧
             while(end>start&&a[start]<=key)//脠莽鹿没脙禄脫脨卤脠鹿脴录眉脰碌麓贸碌脛拢卢卤脠陆脧脧脗脪禄赂枚拢卢脰卤碌陆脫脨卤脠鹿脴录眉脰碌麓贸碌脛陆禄禄禄脦禄脰脙
                start++;
             if(a[start]>=key){
            	 float temp = a[start];
                 a[start] = a[end];
                 a[end] = temp;
             }
         //麓脣脢卤碌脷脪禄麓脦脩颅禄路卤脠陆脧陆谩脢酶拢卢鹿脴录眉脰碌碌脛脦禄脰脙脪脩戮颅脠路露篓脕脣隆拢脳贸卤脽碌脛脰碌露录卤脠鹿脴录眉脰碌脨隆拢卢脫脪卤脽碌脛脰碌露录卤脠鹿脴录眉脰碌麓贸拢卢碌芦脢脟脕陆卤脽碌脛脣鲁脨貌禄鹿脫脨驴脡脛脺脢脟虏禄脪禄脩霉碌脛拢卢陆酶脨脨脧脗脙忙碌脛碌脻鹿茅碌梅脫脙
         }
         //碌脻鹿茅
         if(start>low) sort(a,low,start-1);//脳贸卤脽脨貌脕脨隆拢碌脷脪禄赂枚脣梅脪媒脦禄脰脙碌陆鹿脴录眉脰碌脣梅脪媒-1
         if(end<high) sort(a,end+1,high);//脫脪卤脽脨貌脕脨隆拢麓脫鹿脴录眉脰碌脣梅脪媒+1碌陆脳卯潞贸脪禄赂枚
     }
    public static List<Info> getRst(String id){
 	   ResultSet rs=null;
 	  PreparedStatement ps=null;
 	 List<Info> spList=null;
 	   /**
 	    * 使锟斤拷占位锟斤拷锟絊QL锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟秸嘉伙拷锟街�
 	    * 锟斤拷锟斤拷锟较d锟斤拷询锟斤拷息锟侥撅拷锟斤拷锟斤拷锟斤拷
 	    */
 	     String sql="select * from t_uims_info where m_id=?";
 	     int ID=Integer.parseInt(id);
 	   
 	     try {
 	    	ps= DBUtil.getConPst(sql);  //锟斤拷取 PreparedStatement锟斤拷锟斤拷
 	    	 ps.setInt(1,ID);  	//为锟斤拷一锟斤拷锟斤拷锟斤拷锟斤拷懈锟街�   	 
				rs=ps.executeQuery();
				 //实锟斤拷一锟斤拷List锟叫�锟斤拷锟斤拷锟斤拷锟斤拷锟窖拷锟捷的斤拷锟�
				 spList = new ArrayList<Info>();
					while(rs.next()){
						  Info info=new Info();
						  info.setTitle(rs.getString("m_title"));
						  info.setDate(rs.getString("m_date"));
						  info.setContext(rs.getString("m_context"));
						  info.setPhone(rs.getString("m_ph"));
						  info.setName(rs.getString("m_name"));
						  info.setMail(rs.getString("m_mail"));  
						  spList.add(info);//锟斤拷锟斤拷锟斤拷写锟斤拷list锟斤拷
					  }
					DBUtil.close(ps,rs);//锟截憋拷rs,ps,con
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 	   return spList;
    }
    public static List<Info> getSimRS(String type,String id){
 	   ResultSet simRs=null;
 	   PreparedStatement ps=null;
 	  List<Info> simList=null;
 	   /**
 	    * 使锟斤拷占位锟斤拷锟絪ql锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟秸嘉伙拷锟街�
 	    * 锟斤拷菥锟斤拷锟斤拷锟较拷锟斤拷诘锟斤拷锟斤拷停锟斤拷锟窖拷锟矫撅拷锟斤拷锟斤拷息之锟斤拷锟酵拷锟斤拷锟斤拷锟较�
 	    * 锟斤拷时锟斤拷锟斤拷薪锟斤拷锟斤拷锟斤拷锟�
 	    * 只取前十锟斤拷锟斤拷息
 	    */
String sql=
"select * from t_uims_info where m_type=?"+" and m_id !=?"+" order by m_date desc limit 10";
 	  int ID=Integer.parseInt(id);
     try {
 		 ps=DBUtil.getConPst(sql);//锟斤拷取 PreparedStatement锟斤拷锟斤拷
 		 ps.setString(1, type);//为锟斤拷一锟斤拷锟斤拷锟斤拷值
 		 ps.setInt(2, ID);//为锟节讹拷锟斤拷锟斤拷锟斤拷值
 		simRs=ps.executeQuery();
 		//实锟斤拷一锟斤拷List锟叫�锟斤拷锟斤拷锟斤拷锟斤拷锟窖拷锟捷的斤拷锟�
			 simList = new ArrayList<Info>();
				while(simRs.next()){
					  Info info=new Info();
					  info.setTitle(simRs.getString("m_title"));
					  info.setDate(simRs.getString("m_date"));
					  info.setContext(simRs.getString("m_context"));
					  info.setPhone(simRs.getString("m_ph"));
					  info.setName(simRs.getString("m_name"));
					  info.setMail(simRs.getString("m_mail"));	
					  simList.add(info);//锟斤拷锟斤拷锟斤拷写锟斤拷list锟斤拷
				  }
				DBUtil.close(ps, simRs);//锟截憋拷rs,ps,con
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
 	    return simList;
 	   
    }
}
