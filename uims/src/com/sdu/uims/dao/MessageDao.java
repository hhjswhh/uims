package com.sdu.uims.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sdu.uims.comm.DBUtil;
import com.sdu.uims.vo.Info;
import com.sdu.uims.vo.Message;

public class MessageDao {
	DBUtil db = new DBUtil();
	
	public Message[] showList(String sql){
		
		return null;
	}
	
	public ArrayList<Message> findByPage(int page, String id) {
        DBUtil db = new DBUtil();
        int begin = (page-1) * 5;//���ݿ���ҵ�������������ÿҳ��ʾ��Ϣ���ټ���ǰҳ��Ϊ�ڼ�ҳȷ�������ݱ��еڼ��п�ʼ��
        String sql = "select * from T_SYS_MESSAGE where m_ph='"+id+"' limit "+begin+",5;";//ÿ�β��� 5 ������ÿҳ��ʾ������Ϊ 5 
        ArrayList<Message> list = new ArrayList<Message>();
        try {
        	ResultSet rs = db.getConPst(sql).executeQuery();
            while(rs.next()){
            	Message msg = new Message();
            	msg.setDate(rs.getString("m_date"));
            	msg.setInfoId(rs.getInt("m_info_lid"));
            	msg.setMessageContext(rs.getString("m_messageContext"));
            	msg.setPhone(rs.getString("m_ph"));
                list.add(msg);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    
    public int messageCount(){
        DBUtil db = new DBUtil();
        String sql = "select count(*) from T_SYS_MESSAGE";
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
	
}
