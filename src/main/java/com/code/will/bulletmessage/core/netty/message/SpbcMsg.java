package com.code.will.bulletmessage.core.netty.message;

public class SpbcMsg extends Message{
	
	private String sn;
	private String dn;
	private String gn;
	private String gc;
	private String drid;
	private String gs;
	private String gb;
	private String es;
	private String gfid;
	private String eid;
	private String bgl;
	private String ifs;
	private String rid;
	private String gid;
	private String bid;
	private String sid;
	private String cl2;

	public SpbcMsg(Message message) {
		super(message);
		sn = msgDetail.get("sn");
		dn = msgDetail.get("dn");
		gn = msgDetail.get("gn");
		gc = msgDetail.get("gc");
		drid = msgDetail.get("drid");
		gs = msgDetail.get("gs");
		gb = msgDetail.get("gb");
		es = msgDetail.get("es");
		gfid = msgDetail.get("gfid");
		eid = msgDetail.get("eid");
		bgl = msgDetail.get("bgl");
		ifs = msgDetail.get("ifs");
		rid = msgDetail.get("rid");
		gid = msgDetail.get("gid");
		bid = msgDetail.get("bid");
		sid = msgDetail.get("sid");
		cl2 = msgDetail.get("cl2");
	}
	// type@=spbc/sn@=大大棒棒歌/dn@=White55开解说/gn@=火箭/gc@=1/drid@=138286/gs@=6/gb@=1/es@=1/gfid@=196/eid@=143/bgl@=3/ifs@=0/rid@=291514/gid@=0/bid@=30002_1497455820_33/sid@=73345180/cl2@=0/
//	type@=spbc/sn@=超级跳跳跳跳/dn@=木木一mango/gn@=城堡/gc@=1/drid@=1833034/gs@=6/gb@=0/es@=3/gfid@=686/eid@=139/bgl@=3/ifs@=0/rid@=291514/gid@=0/bid@=30127_1497455847_715/sid@=6181901/cl2@=0/

	@Override
	public String toString() {
		return String.format("[礼物广播][%s]->[%s] [%s]",sn,dn,gn);
	}
	
}
