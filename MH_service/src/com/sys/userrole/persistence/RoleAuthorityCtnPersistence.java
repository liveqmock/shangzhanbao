package com.sys.userrole.persistence;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.BasePersistence;
import com.sys.userrole.data.RoleAuthorityCtnData;
@Component("roleAuthorityCtnPersistence")
public class RoleAuthorityCtnPersistence extends BasePersistence<RoleAuthorityCtnData> implements
	IRoleAuthorityCtnPersistence {

}
