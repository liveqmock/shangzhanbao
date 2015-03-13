package com.mini.pageManage.persistence;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.BasePersistence;
import com.mini.page.data.PageData;

@Component("pageManagePersistence")
public class PageManagePersistence extends BasePersistence<PageData> implements
		IPageManagePersistence {
}
