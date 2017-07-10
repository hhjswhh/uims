package com.sdu.uims.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.sdu.uims.comm.DBUtil;
import com.sdu.uims.vo.Message;

public class MessageDao {
	
	/**
     * ��ҳ��ȡ��ǰ�û�����Ϣ�б�
     * @author ��һ��
     * @param  page ��ǰҳ   id  �û��ֻ���
     * @return  ����һ������Message��List 
     */
	public ArrayList<Message> findByPage(int page, String id) {
        int begin = (page-1) * 5;//���ݿ���ҵ�������������ÿҳ��ʾ��Ϣ���ټ���ǰҳ��Ϊ�ڼ�ҳȷ�������ݱ��еڼ��п�ʼ��
        String sql = "select * from T_SYS_MESSAGE where m_ph=? limit "+begin+",5;";//ÿ�β��� 5 ������ÿҳ��ʾ������Ϊ 5 
        ArrayList<Message> list = new ArrayList<Message>();
        try {
        	PreparedStatement pstm = DBUtil.getConPst(sql);
        	pstm.setString(1, id);
        	ResultSet rs = pstm.executeQuery();
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
	/**
     * ��ȡ��ǰ�û�����Ϣ����
     * @author ��һ��
     * @param  id �û��ֻ���
     * @return  ����ֵΪһ��intֵ��ʾ 
     */
    public int messageCount(String id){
        String sql = "select count(*) from T_SYS_MESSAGE where m_ph=?;";
        int count = 0;
        try {
        	PreparedStatement pstm = DBUtil.getConPst(sql);
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
	
}
