package com.mini.pageManage.persistence;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.BasePersistence;
import com.mini.page.data.PageServiceData;


@Component("pageServicePersistence")
public class PageServicePersistence extends BasePersistence<PageServiceData> implements
		IPageServicePersistence {
}
