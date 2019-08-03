package com.code.will.bulletmessage.core.netty.message;

public class DgbMsg extends Message{

	private String rid;
	/**
	 * 礼物 id
	 */
	private String gfid;
	/**
	 * 礼物显示样式
	 */
	private String gs;
	private String uid;
	private String nn;
	private String ic;
	private String eid;
	private String level;
	/**
	 * 主播体重
	 */
	private String dw;
	/**
	 * 礼物连击次数
	 */
	private String hits;
	private String ct;
	private String cm;
	private String bnn;
	private String bl;
	private String brid;
	private String hc;
	private String sahf;
	
//	type@=dgb/rid@=291514/gfid@=713/gs@=2/uid@=37276862/nn@=逍遥侠士/ic@=avatar@Sdefault@S13/eid@=0/level@=13/dw@=81872024/ct@=0/cm@=0/bnn@=/bl@=0/brid@=0/hc@=/sahf@=0/
	
	public DgbMsg(Message message) {
        super(message);
		rid = msgDetail.get("rid");
		gfid = msgDetail.get("gfid");
		gs = msgDetail.get("gs");
		uid = msgDetail.get("uid");
		nn = msgDetail.get("nn");
		ic = msgDetail.get("ic");
		eid = msgDetail.get("eid");
		level = msgDetail.get("level");
		dw = msgDetail.get("dw");
		hits = msgDetail.get("hits");
		ct = msgDetail.get("ct");
		cm = msgDetail.get("cm");
		bnn = msgDetail.get("bnn");
		bl = msgDetail.get("bl");
		brid = msgDetail.get("brid");
		hc = msgDetail.get("hc");
		sahf = msgDetail.get("sahf");
	}

	@Override
	public String toString() {
		return String.format("[礼物][%s(L%s)]:gs(%s):gfid(%s)x %s",nn,level,gs,gfid,hits==null ?"1":hits);
	}

}
