/*=========================================================
*Copyright(c) 2022 CyberLogitec
*@FileName : Practice2MgmtDBDAOMasterVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2022.06.08
*@LastModifier : 
*@LastVersion : 1.0
* 2022.06.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.practice2.emmsgmgmt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dang Hoan Thanh
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Practice2MgmtDBDAOMasterVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public Practice2MgmtDBDAOMasterVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ownr_sub_sys_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intg_cd_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.practice2.emmsgmgmt.integration").append("\n"); 
		query.append("FileName : Practice2MgmtDBDAOMasterVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("select " ).append("\n"); 
		query.append("    ownr_sub_sys_cd, " ).append("\n"); 
		query.append("    intg_cd_id, " ).append("\n"); 
		query.append("    intg_cd_nm, " ).append("\n"); 
		query.append("    intg_cd_len, " ).append("\n"); 
		query.append("    intg_cd_tp_cd, " ).append("\n"); 
		query.append("    mng_tbl_nm, " ).append("\n"); 
		query.append("    intg_cd_desc, " ).append("\n"); 
		query.append("    intg_cd_use_flg, " ).append("\n"); 
		query.append("    cre_usr_id, " ).append("\n"); 
		query.append("    cre_dt," ).append("\n"); 
		query.append("    upd_usr_id, " ).append("\n"); 
		query.append("	upd_dt" ).append("\n"); 
		query.append("from com_intg_cd" ).append("\n"); 
		query.append("where 1 = 1" ).append("\n"); 
		query.append("#if (${ownr_sub_sys_cd} != '') " ).append("\n"); 
		query.append("and UPPER(ownr_sub_sys_cd) like '%'||UPPER(@[ownr_sub_sys_cd])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${intg_cd_id} != '') " ).append("\n"); 
		query.append("and	UPPER(intg_cd_id) like '%'||UPPER(@[intg_cd_id])|| '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}