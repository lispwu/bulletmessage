package com.code.will.bulletmessage.core.netty.message;

public class ChatMsg extends Message {

	/**
	 * 房间 ID
	 */
	private String rid ;
	
	/**
	 * 客户端类型：默认值 0（表示 web 用户）
	 */
	private String ct ;

	/**
	 *  用户 ID
	 */
	private String uid ;
	/**
	 * 用户昵称
	 */
	private String nn ;
	/**
	 * 弹幕文本内容
	 */
	private String txt ;
	/**
	 * 弹幕唯一 ID
	 */
	private String cid ;
	
	/**
	 * 图标
	 * avanew@Sface@S201706@S08@S21@S05 e00080744c2fb42121d17f0ee68bfe
	 * 
	 * avatar@Sdefault@S13
	 */
	private String ic ;
	/**
	 * 用户等级
	 */
	private String level ;
	
	/**
	 * 0
	 */
	private String sahf ;
	/**
	 * 粉丝勋章
	 */
	private String bnn ;
	/**
	 * 粉丝勋章等级
	 */
	private String bl ;
	/**
	 * 粉丝勋章所在的房间号
	 */
	private String brid ;

	/**
	 * 32位的字符，像是某个数据的hash
	 */
	private String hc ;
	private String el ;
	
	public ChatMsg(Message message) {
		super(message);
		rid = msgDetail.get("rid");
		ct = msgDetail.get("ct");
		uid = msgDetail.get("uid");
		nn = msgDetail.get("nn");
		txt = msgDetail.get("txt");
		cid = msgDetail.get("cid");
		ic = msgDetail.get("ic");
		level = msgDetail.get("level");
		sahf = msgDetail.get("sahf");
		bnn = msgDetail.get("bnn");
		bl = msgDetail.get("bl");
		brid = msgDetail.get("brid");
		hc = msgDetail.get("hc");
		el = msgDetail.get("el");
		
		if (txt != null) {
            // @S --> /
            // @A --> @
            // \\ --> \
			txt = txt.replace("@S", "/").replace("@A", "@").replace("\\\\", "\\");
        } else {
        	txt = "";
        }
	}

	@Override
	public String toString() {
//		return String.format("[%s(L%s)]:%s|%s|%s",nn,level,txt,sahf,ic);
		return String.format("[弹幕][%s(L%s)]:%s",nn,level,txt);
	}

}
