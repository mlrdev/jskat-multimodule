/**
 * Copyright (C) 2019 Jan Schäfer (jansch@users.sourceforge.net)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jskat.gui.human;

import org.jskat.gui.action.JSkatActionEvent;
import org.jskat.player.AbstractJSkatPlayer;

/**
 * Abstract implementation of a human player for JSkat
 */
public abstract class AbstractHumanJSkatPlayer extends AbstractJSkatPlayer {

	@Override
	public final Boolean isAIPlayer() {
		return false;
	}

	/**
	 * Informs the human player about an action that was performed
	 * 
	 * @param e
	 *            Action
	 */
	public abstract void actionPerformed(final JSkatActionEvent e);
}
