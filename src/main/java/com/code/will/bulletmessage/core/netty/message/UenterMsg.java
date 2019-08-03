package com.code.will.bulletmessage.core.netty.message;

public class UenterMsg extends Message{

	private String rid;
	private String uid;
	private String nn;
	private String level;
	private String ic;
	private String rni;
	private String el;
	private String sahf;
	private String wgei;
	
	public UenterMsg(Message message) {
		super(message);
		type = msgDetail.get("type");
		rid = msgDetail.get("rid");
		uid = msgDetail.get("uid");
		nn = msgDetail.get("nn");
		level = msgDetail.get("level");
		ic = msgDetail.get("ic");
		rni = msgDetail.get("rni");
		el = msgDetail.get("el");
		sahf = msgDetail.get("sahf");
		wgei = msgDetail.get("wgei");
	}
//type@=uenter/rid@=291514/uid@=5990581/nn@=木亦哥哥/level@=45/ic@=avanew@Sface@S201704@S08@S02@S40b2d71d6918cdfc6fbe17c89362903b/rni@=0/el@=/sahf@=0/wgei@=0/

	@Override
	public String toString() {
		return String.format("[用户进入][%s(L%s)] 进入房间(%s)",nn,level,rid);
	}
}
