/**
 *
 * dribbble-java-client: Java Client for Dribbble.com API
 * Copyright (c) 2012, Sandeep Gupta
 * 
 * http://www.sangupta/projects/dribbble-java-client
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package com.sangupta.dribbble.api.model;

import java.util.List;

/**
 * Holds details of one page of player list from Dribbble.com
 * 
 * @author sangupta
 *
 */
public class PlayerList {
	
	private int page;
	
	private int pages;
	
	private int perPage;
	
	private long total;
	
	private List<Player> players;
	
	// Usual accessors follow

	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * @return the pages
	 */
	public int getPages() {
		return pages;
	}

	/**
	 * @param pages the pages to set
	 */
	public void setPages(int pages) {
		this.pages = pages;
	}

	/**
	 * @return the perPage
	 */
	public int getPerPage() {
		return perPage;
	}

	/**
	 * @param perPage the perPage to set
	 */
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	/**
	 * @return the total
	 */
	public long getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(long total) {
		this.total = total;
	}

	/**
	 * @return the players
	 */
	public List<Player> getPlayers() {
		return players;
	}

	/**
	 * @param players the players to set
	 */
	public void setPlayers(List<Player> players) {
		this.players = players;
	}

}
