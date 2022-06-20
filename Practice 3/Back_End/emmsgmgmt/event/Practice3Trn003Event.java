/*=========================================================
 *Copyright(c) 2022 CyberLogitec
 *@FileName : Practice3Trn003Event.java
 *@FileTitle : Practice 3
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2022.06.13
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2022.04.22
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.practice3.emmsgmgmt.event;

import com.clt.apps.opus.practice3.emmsgmgmt.vo.DetailVO;
import com.clt.apps.opus.practice3.emmsgmgmt.vo.SummarySearchTradeVO;
import com.clt.apps.opus.practice3.emmsgmgmt.vo.SummaryVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * PDTO (Data Transfer Object including Parameters) for PRACTICE3_TRN_003<br>
 * - Created from PRATICE3_TRN_003HTMLAction<br>
 * - Used as PDTO delivered to ServiceCommand Layer<br>
 *
 * @author Dang Hoan Thanh
 * @see PRACTICE3_TRN_003HTMLAction 참조
 * @since J2EE 1.6
 */
public class Practice3Trn003Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object query conditions and single case processing  */
	SummaryVO summaryVO = null;	
	DetailVO detailVO = null;	
	SummarySearchTradeVO tradeVO = null;
	
	/** Table Value Object Multi Data Processing */
	SummaryVO[] summaryVOs = null;
	DetailVO[] detailVOs = null;
	
	public Practice3Trn003Event(){}
	
	// get set SummaryVO
	public void setSummaryVO (SummaryVO summaryVO){
		this.summaryVO = summaryVO;
	}	
	public SummaryVO getSummaryVO(){
		return summaryVO;
	}
	
	//get set SummaryVO[]
	public void setSummaryVOS(SummaryVO[] summaryVOs){
		this.summaryVOs = summaryVOs;
	}
	public SummaryVO[] getSummaryVOS(){
		return summaryVOs;
	}
	
	//get set DetailVO
	public void setDetailVO (DetailVO detailVO){
		this.detailVO = detailVO;
	}
	public DetailVO getDetailVO(){
		return detailVO;
	}
	
	//get set DetailVO[]
	public void setDetailVOS(DetailVO[] detailVOs){
		this.detailVOs = detailVOs;
	}
	public DetailVO[] getDetailVOS(){
		return detailVOs;
	}
	
	//get set TradeVO
	public void setTradeVO(SummarySearchTradeVO tradeVO){
		this.tradeVO = tradeVO;
	}
	public SummarySearchTradeVO getTradeVO(){
		return tradeVO;
	}
}
