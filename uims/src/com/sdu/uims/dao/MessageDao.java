package com.sdu.uims.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.sdu.uims.comm.DBUtil;
import com.sdu.uims.vo.Message;

public class MessageDao {
	
	/**
     * 分页获取当前用户的消息列表
     * @author 蔡一玮
     * @param  page 当前页   id  用户手机号
     * @return  返回一个包含Message的List 
     */
	public ArrayList<Message> findByPage(int page, String id) {
        int begin = (page-1) * 5;//数据库查找的数量，即根据每页显示信息多少及当前页面为第几页确定从数据表中第几行开始找
        String sql = "select * from T_SYS_MESSAGE where m_ph=? limit "+begin+",5;";//每次查找 5 个，即每页显示的数量为 5 
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
     * 获取当前用户的消息总数
     * @author 蔡一玮
     * @param  id 用户手机号
     * @return  返回值为一个int值表示 
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
