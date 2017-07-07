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
	 * @param type  ���յĲ�ѯ��ݿ����Ͳ���
	 * @return   ����һ����ѯ��Ľ��
	 */
    public static List<Info> getRS(String type){
    	/**
    	 * rs���ڱ���prepareStatement(sql)��ѯ��Ľ��
    	 */
    	ResultSet rs=null;
    	PreparedStatement ps=null;
    	List<Info> inList=null;
    	/**
    	 * ʹ��ռλ�����SQL�����������ռλ��ֵ
    	 * sql���
    	 * ���ڲ�ѯ��Ҫʹ�õ������
    	 */
    	String sql="select * from t_uims_info where m_type=?";
    	  try {
    		  ps=DBUtil.getConPst(sql);//��ȡPreparedStatement����
    		    ps.setString(1, type);//Ϊ��һ������ֵ
			  rs=ps.executeQuery();
			  //ʵ��һ��List�б?���������ѯ��ݵĽ��
			  inList = new ArrayList<Info>();
				while(rs.next()){
					  Info info=new Info();
					  //��ID���ں�����о�����Ϣ�Ĳ�ѯ���������б�����ʾ����Ҫ�������ӵĲ���
					  info.setId(rs.getInt("m_id"));
					  info.setType(rs.getString("m_type"));
					  info.setTitle(rs.getString("m_title"));
					  info.setDate(rs.getString("m_date"));
					  info.setName(rs.getString("m_name"));				  
					  inList.add(info);//������д��list��
				  }
				DBUtil.close(ps,rs);//�ر�rs ,ps,con
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    	  //���ز�ѯ����ݽ�����
    	return inList;
    }
    
    public ArrayList<Info> findByPage(int page, String id) {
        DBUtil db = new DBUtil();
        int begin = (page-1) * 5;//Êý¾Ý¿â²éÕÒµÄÊýÁ¿£¬¼´¸ù¾ÝÃ¿Ò³ÏÔÊ¾ÐÅÏ¢¶àÉÙ¼°µ±Ç°Ò³ÃæÎªµÚ¼¸Ò³È·¶¨´ÓÊý¾Ý±íÖÐµÚ¼¸ÐÐ¿ªÊ¼ÕÒ
        String sql = "select * from T_UIMS_INFO where m_ph='"+id+"' limit "+begin+",5;";//Ã¿´Î²éÕÒ 5 ¸ö£¬¼´Ã¿Ò³ÏÔÊ¾µÄÊýÁ¿Îª 5 
        ArrayList<Info> list = new ArrayList<Info>();
        try {
        	ResultSet rs = db.getConPst(sql).executeQuery();
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
    public int infoCount(){
        DBUtil db = new DBUtil();
        String sql = "select count(*) from T_UIMS_INFO";
        int count = 0;
        try {
        	ResultSet rs = db.getConPst(sql).executeQuery();
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return count;
    }
public static List searchInfo(String searchword){
		
		String Search = searchword;//»ñÈ¡´«µÝÀ´µÄ¹Ø¼ü×Ö
		
		String sql="select * from t_uims_info";
		
		ResultSet rs=null;
		
		int m_id;//ÐÅÏ¢id
		String tilte;//ÐÅÏ¢±êÌâ
		String context;//ÐÅÏ¢ÄÚÈÝ
		String date;//ÐÅÏ¢Ê±¼ä
		
		String tiltearray[] = new String[1000000];//´æÈë±êÌâÊý×é
		int arrayindex=0;//´æ´¢Êý×éµÄÏÂ±ê
		//ÉùÃ÷list£¬ÓÃÓÚÎ´ÅÅÐòµÄ½á¹û¼¯
        List<Info> sumans = new ArrayList<Info>();
		try {
			//´ÓÊý¾Ý¿âÖÐ²éÕÒ³öÈ«²¿Êý¾Ý
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
		    
		//ÉùÃ÷ÏàËÆ¶ÈÊý×é
        float index[]=new float[arrayindex];
        //ÉùÃ÷list£¬ÓÃÓÚ²ÎÓëÏàËÆ¶È±È½Ï
        List<Sort> al = new ArrayList<Sort>();
        
        //aiÓÃÓÚÈ¥³ýÏàËÆ¶ÈÎª0µÄÊý¾Ý
        int ai=arrayindex;
        //ÕÒ³öÃ¿¸ö±êÌâµÄÏàËÆ¶È£¬²¢±£´æÔÚindexÊý×éÖÐ
        for(int i=0;i<arrayindex;i++)
        {
        	//»ñÈ¡ÏÂ±íÎªiµÄÏàËÆ¶È
        	index[i]=levenshtein(Search,tiltearray[i]);
        	System.out.println("ÏàËÆ¶È£º"+index[i]);
        	if(index[i]==0)
        	{
        		System.out.println("ÏàËÆ¶ÈÎª0");
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
        System.out.println("ÐòÁÐÎª£º");
        for(int i=0;i<arrayindex;i++)
        {
        	//al[i].g
        	System.out.println(index[i]);
        }
        
        //ÉùÃ÷list£¬ÓÃÓÚ±£´æÒÑÅÅÐòµÄ½á¹û¼¯
        List<Info> ans = new ArrayList<Info>();
        System.out.println("idÎª£º");
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
	//ÅÐ¶ÏÏàËÆ¶È
	public static float levenshtein(String str1,String str2) {    
        //¼ÆËãÁ½¸ö×Ö·û´®µÄ³¤¶È¡£    
        int len1 = str1.length();    
        int len2 = str2.length();    
        //½¨Á¢ÉÏÃæËµµÄÊý×é£¬±È×Ö·û³¤¶È´óÒ»¸ö¿Õ¼ä    
        int[][] dif = new int[len1 + 1][len2 + 1];    
        //¸³³õÖµ£¬²½ÖèB¡£    
        for (int a = 0; a <= len1; a++) {    
            dif[a][0] = a;    
        }    
        for (int a = 0; a <= len2; a++) {    
            dif[0][a] = a;    
        }    
        //¼ÆËãÁ½¸ö×Ö·ûÊÇ·ñÒ»Ñù£¬¼ÆËã×óÉÏµÄÖµ    
        int temp;    
        for (int i = 1; i <= len1; i++) {    
            for (int j = 1; j <= len2; j++) {    
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {    
                    temp = 0;    
                } else {    
                    temp = 1;    
                }    
                //È¡Èý¸öÖµÖÐ×îÐ¡µÄ    
                dif[i][j] = min(dif[i - 1][j - 1] + temp, dif[i][j - 1] + 1,    
                        dif[i - 1][j] + 1);    
            }    
        }    
        //System.out.println("×Ö·û´®\""+str1+"\"Óë\""+str2+"\"µÄ±È½Ï");    
        //È¡Êý×éÓÒÏÂ½ÇµÄÖµ£¬Í¬Ñù²»Í¬Î»ÖÃ´ú±í²»Í¬×Ö·û´®µÄ±È½Ï    
        //System.out.println("²îÒì²½Öè£º"+dif[len1][len2]);    
        //¼ÆËãÏàËÆ¶È    
        float similarity =1 - (float) dif[len1][len2] / Math.max(str1.length(), str2.length());    
        //System.out.println("ÏàËÆ¶È£º"+similarity);
        return similarity;
    }
	//µÃµ½×îÐ¡Öµ    
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
             //´ÓºóÍùÇ°±È½Ï
             while(end>start&&a[end]>=key)  //Èç¹ûÃ»ÓÐ±È¹Ø¼üÖµÐ¡µÄ£¬±È½ÏÏÂÒ»¸ö£¬Ö±µ½ÓÐ±È¹Ø¼üÖµÐ¡µÄ½»»»Î»ÖÃ£¬È»ºóÓÖ´ÓÇ°Íùºó±È½Ï
                 end--;
             if(a[end]<=key){
            	 float temp = a[end];
                 a[end] = a[start];
                 a[start] = temp;
             }
             //´ÓÇ°Íùºó±È½Ï
             while(end>start&&a[start]<=key)//Èç¹ûÃ»ÓÐ±È¹Ø¼üÖµ´óµÄ£¬±È½ÏÏÂÒ»¸ö£¬Ö±µ½ÓÐ±È¹Ø¼üÖµ´óµÄ½»»»Î»ÖÃ
                start++;
             if(a[start]>=key){
            	 float temp = a[start];
                 a[start] = a[end];
                 a[end] = temp;
             }
         //´ËÊ±µÚÒ»´ÎÑ­»·±È½Ï½áÊø£¬¹Ø¼üÖµµÄÎ»ÖÃÒÑ¾­È·¶¨ÁË¡£×ó±ßµÄÖµ¶¼±È¹Ø¼üÖµÐ¡£¬ÓÒ±ßµÄÖµ¶¼±È¹Ø¼üÖµ´ó£¬µ«ÊÇÁ½±ßµÄË³Ðò»¹ÓÐ¿ÉÄÜÊÇ²»Ò»ÑùµÄ£¬½øÐÐÏÂÃæµÄµÝ¹éµ÷ÓÃ
         }
         //µÝ¹é
         if(start>low) sort(a,low,start-1);//×ó±ßÐòÁÐ¡£µÚÒ»¸öË÷ÒýÎ»ÖÃµ½¹Ø¼üÖµË÷Òý-1
         if(end<high) sort(a,end+1,high);//ÓÒ±ßÐòÁÐ¡£´Ó¹Ø¼üÖµË÷Òý+1µ½×îºóÒ»¸ö
     }
    public static List<Info> getRst(String id){
 	   ResultSet rs=null;
 	  PreparedStatement ps=null;
 	 List<Info> spList=null;
 	   /**
 	    * ʹ��ռλ���SQL���������������ռλ��ֵ
 	    * �����Ϣid��ѯ��Ϣ�ľ�������
 	    */
 	     String sql="select * from t_uims_info where m_id=?";
 	     int ID=Integer.parseInt(id);
 	   
 	     try {
 	    	ps= DBUtil.getConPst(sql);  //��ȡ PreparedStatement����
 	    	 ps.setInt(1,ID);  	//Ϊ��һ��������и�ֵ    	 
				rs=ps.executeQuery();
				 //ʵ��һ��List�б?���������ѯ��ݵĽ��
				 spList = new ArrayList<Info>();
					while(rs.next()){
						  Info info=new Info();
						  info.setTitle(rs.getString("m_title"));
						  info.setDate(rs.getString("m_date"));
						  info.setContext(rs.getString("m_context"));
						  info.setPhone(rs.getString("m_ph"));
						  info.setName(rs.getString("m_name"));
						  info.setMail(rs.getString("m_mail"));  
						  spList.add(info);//������д��list��
					  }
					DBUtil.close(ps,rs);//�ر�rs,ps,con
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
 	    * ʹ��ռλ���sql���������������ռλ��ֵ
 	    * ��ݾ�����Ϣ���ڵ����ͣ���ѯ��þ�����Ϣ֮���ͬ������Ϣ
 	    * ��ʱ����н�������
 	    * ֻȡǰʮ����Ϣ
 	    */
String sql=
"select * from t_uims_info where m_type=?"+" and m_id !=?"+" order by m_date desc limit 10";
 	  int ID=Integer.parseInt(id);
     try {
 		 ps=DBUtil.getConPst(sql);//��ȡ PreparedStatement����
 		 ps.setString(1, type);//Ϊ��һ������ֵ
 		 ps.setInt(2, ID);//Ϊ�ڶ�������ֵ
 		simRs=ps.executeQuery();
 		//ʵ��һ��List�б?���������ѯ��ݵĽ��
			 simList = new ArrayList<Info>();
				while(simRs.next()){
					  Info info=new Info();
					  info.setTitle(simRs.getString("m_title"));
					  info.setDate(simRs.getString("m_date"));
					  info.setContext(simRs.getString("m_context"));
					  info.setPhone(simRs.getString("m_ph"));
					  info.setName(simRs.getString("m_name"));
					  info.setMail(simRs.getString("m_mail"));	
					  simList.add(info);//������д��list��
				  }
				DBUtil.close(ps, simRs);//�ر�rs,ps,con
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
 	    return simList;
 	   
    }
}
