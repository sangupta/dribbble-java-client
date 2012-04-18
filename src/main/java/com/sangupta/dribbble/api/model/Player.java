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
 * Holds details on a given player of Dribbble.com
 * 
 * @author sangupta
 *
 */
public class Player implements Comparable<Player> {
	
	private long id;
	
	private String name;
	
	private String username;
	
	private String url;
	
	private String avatarUrl;
	
	private String location;
	
	private String twitterScreenName;
	
	private String draftedByPlayerId;
	
	private int shotsCount;
	
	private int drafteesCount;

	private int followersCount;
	
	private int followingCount;
	
	private int commentsCount;
	
	private int commentsReceivedCount;
	
	private int likesCount;
	
	private int likesReceivedCount;
	
	private int reboundsCount;
	
	private int reboundsReceivedCount;
	
	private String createdAt;
	
	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		
		if(obj instanceof Player) {
			Player other = (Player) obj;
			return this.id == other.id;
		}
		
		return false;
	}
	
	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Long.valueOf(this.id).hashCode();
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Dribbble Player: " + this.username;
	}
	
	/**
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Player o) {
		if(o == null) {
			return -1;
		}
		
		return Long.valueOf(this.id).compareTo(Long.valueOf(o.id));
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the avatarUrl
	 */
	public String getAvatarUrl() {
		return avatarUrl;
	}

	/**
	 * @param avatarUrl the avatarUrl to set
	 */
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the twitterScreenName
	 */
	public String getTwitterScreenName() {
		return twitterScreenName;
	}

	/**
	 * @param twitterScreenName the twitterScreenName to set
	 */
	public void setTwitterScreenName(String twitterScreenName) {
		this.twitterScreenName = twitterScreenName;
	}

	/**
	 * @return the draftedByPlayerId
	 */
	public String getDraftedByPlayerId() {
		return draftedByPlayerId;
	}

	/**
	 * @param draftedByPlayerId the draftedByPlayerId to set
	 */
	public void setDraftedByPlayerId(String draftedByPlayerId) {
		this.draftedByPlayerId = draftedByPlayerId;
	}

	/**
	 * @return the shotsCount
	 */
	public int getShotsCount() {
		return shotsCount;
	}

	/**
	 * @param shotsCount the shotsCount to set
	 */
	public void setShotsCount(int shotsCount) {
		this.shotsCount = shotsCount;
	}

	/**
	 * @return the drafteesCount
	 */
	public int getDrafteesCount() {
		return drafteesCount;
	}

	/**
	 * @param drafteesCount the drafteesCount to set
	 */
	public void setDrafteesCount(int drafteesCount) {
		this.drafteesCount = drafteesCount;
	}

	/**
	 * @return the followersCount
	 */
	public int getFollowersCount() {
		return followersCount;
	}

	/**
	 * @param followersCount the followersCount to set
	 */
	public void setFollowersCount(int followersCount) {
		this.followersCount = followersCount;
	}

	/**
	 * @return the followingCount
	 */
	public int getFollowingCount() {
		return followingCount;
	}

	/**
	 * @param followingCount the followingCount to set
	 */
	public void setFollowingCount(int followingCount) {
		this.followingCount = followingCount;
	}

	/**
	 * @return the commentsCount
	 */
	public int getCommentsCount() {
		return commentsCount;
	}

	/**
	 * @param commentsCount the commentsCount to set
	 */
	public void setCommentsCount(int commentsCount) {
		this.commentsCount = commentsCount;
	}

	/**
	 * @return the commentsReceivedCount
	 */
	public int getCommentsReceivedCount() {
		return commentsReceivedCount;
	}

	/**
	 * @param commentsReceivedCount the commentsReceivedCount to set
	 */
	public void setCommentsReceivedCount(int commentsReceivedCount) {
		this.commentsReceivedCount = commentsReceivedCount;
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
	 * @return the likesReceivedCount
	 */
	public int getLikesReceivedCount() {
		return likesReceivedCount;
	}

	/**
	 * @param likesReceivedCount the likesReceivedCount to set
	 */
	public void setLikesReceivedCount(int likesReceivedCount) {
		this.likesReceivedCount = likesReceivedCount;
	}

	/**
	 * @return the reboundsCount
	 */
	public int getReboundsCount() {
		return reboundsCount;
	}

	/**
	 * @param reboundsCount the reboundsCount to set
	 */
	public void setReboundsCount(int reboundsCount) {
		this.reboundsCount = reboundsCount;
	}

	/**
	 * @return the reboundsReceivedCount
	 */
	public int getReboundsReceivedCount() {
		return reboundsReceivedCount;
	}

	/**
	 * @param reboundsReceivedCount the reboundsReceivedCount to set
	 */
	public void setReboundsReceivedCount(int reboundsReceivedCount) {
		this.reboundsReceivedCount = reboundsReceivedCount;
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

}
