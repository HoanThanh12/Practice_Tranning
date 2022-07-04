package com.clt.apps.opus.practice4.revlane.event;

import com.clt.apps.opus.practice4.emmsgmgmt.vo.RevLaneVO;
import com.clt.framework.support.layer.event.EventSupport;

public class RevLaneEvent extends EventSupport{
	private static final long serialVersionUID = 1L;
	
	RevLaneVO revLaneVO = null;
	
	public RevLaneEvent() {
		
	}
	
	public RevLaneVO getRevLaneVO(){
		return revLaneVO;
	}
	public void setRevLaneVO(RevLaneVO revLaneVO){
		this.revLaneVO = revLaneVO;
	}
}
