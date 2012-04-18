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
 * Holds details of one shot from Dribbble.com
 * 
 * @author sangupta
 *
 */
public class Shot {
	
	private long id;
	
	private String title;
	
	private String url;
	
	private String shortUrl;
	
	private String imageUrl;
	
	private String imageTeaserUrl;
	
	private int width;
	
	private int height;
	
	private int viewsCount;
	
	private int likesCount;
	
	private int commentsCount;
	
	private int reboundsCount;
	
	private int reboundSourceId;
	
	private String createdAt;
	
	private Player player;
	
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @return the shortUrl
	 */
	public String getShortUrl() {
		return shortUrl;
	}

	/**
	 * @param shortUrl the shortUrl to set
	 */
	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * @return the imageTeaserUrl
	 */
	public String getImageTeaserUrl() {
		return imageTeaserUrl;
	}

	/**
	 * @param imageTeaserUrl the imageTeaserUrl to set
	 */
	public void setImageTeaserUrl(String imageTeaserUrl) {
		this.imageTeaserUrl = imageTeaserUrl;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the viewsCount
	 */
	public int getViewsCount() {
		return viewsCount;
	}

	/**
	 * @param viewsCount the viewsCount to set
	 */
	public void setViewsCount(int viewsCount) {
		this.viewsCount = viewsCount;
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
	 * @return the reboundSourceId
	 */
	public int getReboundSourceId() {
		return reboundSourceId;
	}

	/**
	 * @param reboundSourceId the reboundSourceId to set
	 */
	public void setReboundSourceId(int reboundSourceId) {
		this.reboundSourceId = reboundSourceId;
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
