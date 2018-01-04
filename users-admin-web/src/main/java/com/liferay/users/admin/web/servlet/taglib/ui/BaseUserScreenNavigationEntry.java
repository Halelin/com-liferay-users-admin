/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.users.admin.web.servlet.taglib.ui;

import com.liferay.frontend.taglib.servlet.taglib.ScreenNavigationEntry;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.AggregateResourceBundle;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.users.admin.web.constants.UserFormConstants;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Pei-Jung Lan
 */
public abstract class BaseUserScreenNavigationEntry
	implements ScreenNavigationEntry<User> {

	@Override
	public String getLabel(Locale locale) {
		return LanguageUtil.get(getResourceBundle(locale), getEntryKey());
	}

	@Override
	public String getScreenNavigationKey() {
		return UserFormConstants.SCREEN_NAVIGATION_KEY_USERS;
	}

	protected ResourceBundle getResourceBundle(Locale locale) {
		ResourceBundle bundleResourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return new AggregateResourceBundle(
			bundleResourceBundle, PortalUtil.getResourceBundle(locale));
	}

}