package pojo.util;

import java.util.List;

import org.hibernate.transform.ResultTransformer;

import Bean.ReportBean;

public class ReportResultTransformer implements ResultTransformer {

	
	private static final long serialVersionUID = 1L;

	public Object transformTuple(Object[] paramArrayOfObject, String[] paramArrayOfString) {
		ReportBean reportBean = new ReportBean();

		reportBean.setCustomerId((int) paramArrayOfObject[0]);
		reportBean.setCustomerName((String) paramArrayOfObject[1]);
		reportBean.setTotalOrderPrice((double) paramArrayOfObject[2]);
		return reportBean;
	}

	public List transformList(List paramList) {
		return paramList;
	}

}
