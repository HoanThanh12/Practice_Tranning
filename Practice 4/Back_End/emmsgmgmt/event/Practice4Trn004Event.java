/*=========================================================
 *Copyright(c) 2022 CyberLogitec
 *@FileName : Practice4Trn004Event.java
 *@FileTitle : Practivce 4
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2022.06.30
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2022.05.16
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.practice4.emmsgmgmt.event;

import com.clt.apps.opus.practice4.emmsgmgmt.vo.CarrierVO;
import com.clt.framework.support.layer.event.EventSupport;

public class Practice4Trn004Event extends EventSupport{
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object query conditions and single case processing  */
	CarrierVO carrierVO = null;
	
	/** Table Value Object Multi Data Processing */
	CarrierVO[] carrierVOs = null;
	
	public void setCarrierVO (CarrierVO carrierVO){
		this.carrierVO = carrierVO;
	}	
	public CarrierVO getCarrierVO(){
		return carrierVO;
	}
	
	public void setCarrierVOs (CarrierVO[] carrierVOs){
		this.carrierVOs = carrierVOs;
	}	
	public CarrierVO[] getCarrierVOs(){
		return carrierVOs;
	}
}
