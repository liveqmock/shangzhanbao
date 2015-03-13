package com.mini.order.persistence;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.BasePersistence;
import com.mini.order.data.InvoiceData;


/**
 * 发票持久层实现类
 * @author jmj
 * 2013-9-2 上午09:53:53
 */
@Component("invoicePersistence")
public class InvoicePersistence extends BasePersistence<InvoiceData> implements IInvoicePersistence{


}
