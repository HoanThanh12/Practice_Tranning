/*=========================================================
*Copyright(c) 2022 CyberLogitec
*@FileName : Practice2Trn002Event.java
*@FileTitle : Practice 2
*Open Issues :
*Change history :
*@LastModifyDate : 2022.05.31
*@LastModifier : 
*@LastVersion : 1.0
* 2022.04.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.practice2.emmsgmgmt.event;

import com.clt.apps.opus.practice2.emmsgmgmt.vo.DetailVO;
import com.clt.apps.opus.practice2.emmsgmgmt.vo.MasterVO;
import com.clt.apps.opus.practice2.emmsgmgmt.vo.SubSystemVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * PDTO (Data Transfer Object including Parameters) for PRACTICE2_TRN_002<br>
 * - Created from PRACTICE2_TRN_002HTMLAction<br>
 * - Used as PDTO delivered to ServiceCommand Layer<br>
 *
 * @author Dang Hoan Thanh
 * @see PRACTICE2_TRN_002HTMLAction 참조
 * @since J2EE 1.6
 */
public class Practice2Trn002Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object query conditions and single case processing  */
	MasterVO masterVO = null;
	DetailVO detailVO = null;
	SubSystemVO subSystemVO = null;
	
	/** Table Value Object Multi Data Processing */
	MasterVO[] masterVOs = null;
	DetailVO[] detailVOs = null;
	SubSystemVO[] subSystemVOs = null;
	
	public Practice2Trn002Event(){
		
	}
	
	public void setsubSystemVO (SubSystemVO subSystemVO){
		this.subSystemVO = subSystemVO;
	}
	
	public SubSystemVO getsubSystemVO(){
		return subSystemVO;
	}
	
	public void setsubSystemVOs(SubSystemVO[] subSystemVOs){
		this.subSystemVOs = subSystemVOs;
	}
	
	public SubSystemVO[] getsubSystemVOs(){
		return subSystemVOs;
	}
	
	
	public void setMasterVO (MasterVO masterVO){
		this.masterVO = masterVO;
	}
	
	public MasterVO getMasterVO(){
		return masterVO;
	}
	
	public void setMasterVOS(MasterVO[] masterVOs){
		this.masterVOs = masterVOs;
	}
	
	public MasterVO[] getMasterVOS(){
		return masterVOs;
	}
	
	public void setDetailVO (DetailVO detailVO){
		this.detailVO = detailVO;
	}
	
	public DetailVO getDetailVO(){
		return detailVO;
	}
	
	public void setDetailVOS(DetailVO[] detailVOs){
		this.detailVOs = detailVOs;
	}
	
	public DetailVO[] getDetailVOS(){
		return detailVOs;
	}
}