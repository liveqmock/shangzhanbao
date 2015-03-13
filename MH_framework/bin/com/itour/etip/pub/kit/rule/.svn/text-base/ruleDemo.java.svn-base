package com.itour.etip.pub.kit.rule;

import org.drools.RuleBase;
import org.drools.definition.type.FactType;

public class ruleDemo {

	public Object caculate(){
		try {
			ruleBaseFactory fac = new ruleBaseFactory();
			fac.setConfPath("/rules.properties");
			RuleBase rb = fac.getRuleBase();
			FactType appType = rb.getFactType("mortgages.LoanApplication");
			FactType incomeType = rb.getFactType("mortgages.IncomeSource");

			Object application = appType.newInstance();
			Object income = incomeType.newInstance();

			appType.set(application, "amount", 25000);
			appType.set(application, "deposit", 1500);
			appType.set(application, "lengthYears", 20);

			incomeType.set(income, "type", "Job");
			incomeType.set(income, "amount", 65000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
