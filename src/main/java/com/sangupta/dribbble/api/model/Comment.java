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

/**
 * Holds details of one comment from Dribbble.com
 * 
 * @author sangupta
 *
 */
public class Comment implements Comparable<Comment> {
	
	private long id;
	
	private String body;
	
	private int likesCount;
	
	private String createdAt;
	
	private Player player;
	
	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		
		if(obj instanceof Comment) {
			Comment other = (Comment) obj;
			return this.id == other.id;
		}
		
		return false; 
	}
	
	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Long.valueOf(id).hashCode();
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Dribble Comment ID: " + this.id;
	}
	
	/**
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Comment o) {
		if(o == null) {
			return -1;
		}
		
		return Long.valueOf(id).compareTo(Long.valueOf(o.id));
	}

	// Usual accessors follow

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * @return the likesCount
	 */
	public int getLikesCount() {
		return likesCount;
	}

	/**
	 * @param likesCount the likesCount to set
	 */
	public void setLikesCount(int likesCount) {
		this.likesCount = likesCount;
	}

	/**
	 * @return the createdAt
	 */
	public String getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @param player the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

}
