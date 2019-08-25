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
package org.jskat.data.iss;

/**
 * Move types on ISS
 */
public enum MoveType {
	/**
	 * Card dealing
	 */
	DEAL,
	/**
	 * Bid
	 */
	BID,
	/**
	 * Holding a bid
	 */
	HOLD_BID,
	/**
	 * Passing
	 */
	PASS,
	/**
	 * Requesting skat cards
	 */
	SKAT_REQUEST,
	/**
	 * Picking up skat
	 */
	PICK_UP_SKAT,
	/**
	 * Announcing game
	 */
	GAME_ANNOUNCEMENT,
	/**
	 * Card playing
	 */
	CARD_PLAY,
	/**
	 * Showing cards
	 */
	SHOW_CARDS,
	/**
	 * Resigning game
	 */
	RESIGN,
	/**
	 * Time out
	 */
	TIME_OUT,
	/**
	 * Leave table
	 */
	LEAVE_TABLE
}
